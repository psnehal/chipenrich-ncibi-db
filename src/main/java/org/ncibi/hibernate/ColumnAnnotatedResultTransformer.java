package org.ncibi.hibernate;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.hibernate.transform.ResultTransformer;
import org.ncibi.commons.lang.PreCond;

/**
 * A transformer implementing the Hibernate ResultTransformer interface. This
 * transformer will set field values according to Column annotations on the
 * fields. This allows business objects to be created that have fields mapping
 * to specific columns in a query and have those fields automatically set from
 * the columns.
 * <nl>
 * TODO: Need to support method annotations.
 * 
 * @author gtarcea
 */
public class ColumnAnnotatedResultTransformer implements ResultTransformer
{
    private static final long serialVersionUID = 1L;

    /**
     * The class that is being transformed. This is the class with the
     * javax.persistence.Column annotations on its fields.
     */
    private final Class<?> resultClass;

    /**
     * If no @Column annotation is present this field specifies whether to fall
     * back to the field name. If this is set to false and there is no column
     * annotation then an exception will be raised.
     */
    private final boolean fallbackToFieldName;

    /**
     * A map that contains the column name to field mapping for a particular
     * class of objects.
     */
    private final Map<String, Field> columnFields = new HashMap<String, Field>();

    /**
     * Constructor. This constructor will fall back to using the field name as
     * the column name for a field if no @Column annotation is included on a
     * field.
     * 
     * @param <T>
     *            The type of class.
     * @param cls
     *            The class of object we are transforming to.
     */
    public ColumnAnnotatedResultTransformer(final Class<?> cls)
    {
        PreCond.requireArg(cls != null, "cls != null");
        resultClass = cls;
        fallbackToFieldName = true;
        identifyColumnFields();
    }

    /**
     * Constructor. Allows the user to specify whether or not there to fall back
     * to the field name if no @Column annotation is specified on a field. If
     * useField is set to false and there is no annotation then this constructor
     * will raise an IllegalStateException when it encounters a field with no @Column
     * annotation.
     * 
     * @param <T>
     *            The type of class.
     * @param cls
     *            The class of object we are transforming to.
     * @param useField
     *            Should unannotated fields use the field name as the column
     *            name?
     * @throws IllegalStateException
     *             when a field is encountered that has no column annotation (if
     *             useField == false)
     */
    public ColumnAnnotatedResultTransformer(final Class<?> cls,
            final boolean useField)
    {
        PreCond.requireArg(cls != null, "cls != null");
        resultClass = cls;
        fallbackToFieldName = useField;
        identifyColumnFields();
    }

    /**
     * Creates a mapping of a class' fields to column names. Uses the field name
     * as the column name if no field name is specified unless
     * fallbackToFieldName is set to false. If fallbackToFieldName is set to
     * false and there is no @Column annotation then it raises
     * IllegalStateException.
     */
    private void identifyColumnFields()
    {
        final Field[] fields = resultClass.getDeclaredFields();

        /**
         * Go through the fields and look for javax.persistence.Column
         * annotation.
         */
        for (final Field field : fields)
        {
            field.setAccessible(true);
            final Column columnAnnotation = field.getAnnotation(Column.class);        
            
            /**
             * Check for the javax.persistence.Column annotation.
             */         
            if (columnAnnotation != null)
            {
                final String columnName = columnAnnotation.name();     
                columnFields.put(columnName, field);
            }
            else
            {
                /**
                 * If the field wasn't annotated then use the field name as the
                 * name of the column - unless we were explicitly told not to.
                 */
                if (fallbackToFieldName)
                {
                    columnFields.put(field.getName(), field);
                }
                else
                {
                    throw new IllegalStateException(
                            "No defined mapping for field: " + field.getName());
                }
            }
        }
    }

    /**
     * Transforms a row into a new object by mapping the columns to fields. The
     * two parameters are arrays which are indexed the same, one containing
     * column values, the other containing column names.
     * 
     * @param columnValue
     *            An array of objects representing each columns value.
     * @param columns
     *            An array of objects representing the name of each column.
     * @return A new instance of the resultClass passed into the constructor.
     * @throws IllegalStateException
     *             When the resultClass can't be instantiated or a field cannot
     *             be set.
     */
    @Override
    public Object transformTuple(final Object[] columnValue, final String[] columns)
    {
        Object result;

        try
        {
            result = resultClass.newInstance();
            int index = 0;
            for (final String column : columns)
            {
                final Field f = columnFields.get(column);
                if (f != null)
                {
                    f.set(result, columnValue[index]);
                }
                index++;
            }
        }
        catch (final InstantiationException e)
        {
            throw new IllegalStateException("Unable to instantiate a new "
                    + resultClass.getName(), e);
        }
        catch (final IllegalAccessException e)
        {
            e.printStackTrace();
            throw new IllegalStateException("Unable to set a field for class "
                    + resultClass.getName(), e);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
            throw new IllegalStateException("An unexpected exception occured: "
                    + e.getClass(), e);
        }

        return result;
    }

    /**
     * Does nothing in this transformer (at least right now).
     */
    @SuppressWarnings("unchecked")
    @Override
    public List transformList(final List collection)
    {
        return collection;
    }
}
