package org.ncibi.hibernate.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.joda.time.LocalDate;

/**
 * Implements a Hibernate Composite User Type for the Joda LocalDate class. The composite type
 * stores the 3 parts of a LocalDate (year, month of year, day of month) into 3 separate columns so
 * that queries can easily be composed on the different parts of the date.
 * <p>
 * The LocalDate class is used to limit dates down to a day in precision - more than that isn't
 * required for Hibernate classes that use this.
 * <p>
 * This class assumes that the object is immutable.
 * 
 * @author gtarcea
 * 
 */
public class LocalDateCompositeUserType implements CompositeUserType
{
    /**
     * The next 3 fields indicate the column index. Columns are indexed in order of YEAR,
     * MONTH_OF_YEAR, DAY_OF_MONTH (eg, 2010-12-01). If the order of the indexes is changed it will
     * affect the code.
     */
    private static final int YEAR = 0;
    private static final int MONTH_OF_YEAR = 1;
    private static final int DAY_OF_MONTH = 2;

    /**
     * The order of the property names must match the order of the indexes: year, month of year, day
     * of month.
     */
    private static final String[] PROPERTY_NAMES = { "year", "monthOfYear", "dayOfMonth" };

    /**
     * This is the types of the individual columns. The order is YEAR, MONTH_OF_YEAR, DAY_OF MONTH.
     */
    private static final Type[] PROPERTY_TYPES = { StandardBasicTypes.INTEGER, // YEAR
        StandardBasicTypes.INTEGER, // MONTH_OF_YEAR
        StandardBasicTypes.INTEGER // DAY_OF_MONTH
    };

    /**
     * For immutable types return the cached object.
     */
    @Override
    public Object assemble(final Serializable cached, final SessionImplementor session,
            final Object owner) throws HibernateException
    {
        return cached;
    }

    /**
     * There is no deep copy required, just return the original value.
     */
    @Override
    public Object deepCopy(final Object value) throws HibernateException
    {
        return value;
    }

    /**
     * Nothing to do, return the original value.
     */
    @Override
    public Serializable disassemble(final Object value, final SessionImplementor session)
            throws HibernateException
    {
        return (Serializable) value;
    }

    /**
     * A standard equals.
     */
    @Override
    public boolean equals(final Object x, final Object y) throws HibernateException
    {
        if (x == y)
        {
            return true;
        }
        else if (x == null || y == null)
        {
            return false;
        }
        else
        {
            return x.equals(y);
        }
    }

    /**
     * The property names as contained in PROPERTY_NAMES.
     */
    @Override
    public String[] getPropertyNames()
    {
        return LocalDateCompositeUserType.PROPERTY_NAMES;
    }

    /**
     * The property types as contained in PROPERTY_TYPES.
     */
    @Override
    public Type[] getPropertyTypes()
    {
        return LocalDateCompositeUserType.PROPERTY_TYPES;
    }

    /**
     * Return the value based on the index. See comments on indices at start of class.
     */
    @Override
    public Object getPropertyValue(final Object component, final int propertyIndex)
            throws HibernateException
    {
        final LocalDate ld = (LocalDate) component;

        if (propertyIndex == YEAR)
        {
            return ld.getYear();
        }
        else if (propertyIndex == MONTH_OF_YEAR)
        {
            return ld.getMonthOfYear();
        }
        else if (propertyIndex == DAY_OF_MONTH)
        {
            return ld.getDayOfMonth();
        }
        else
        {
            throw new HibernateException(
                    "Argument index out of range for ProvenanceDateCompositeUserType: "
                            + propertyIndex);
        }
    }

    /**
     * Return underlying objects hash code.
     */
    @Override
    public int hashCode(final Object obj) throws HibernateException
    {
        return obj.hashCode();
    }

    /**
     * This is an immutable object.
     */
    @Override
    public boolean isMutable()
    {
        return false;
    }

    /**
     * If all the columns were retrieved then return a new LocalDate, otherwise return a null.
     */
    @Override
    public Object nullSafeGet(final ResultSet resultSet, final String[] names,
            final SessionImplementor session, final Object owner) throws HibernateException,
            SQLException
    {
        final int year = resultSet.getInt(names[YEAR]);
        if (resultSet.wasNull())
        {
            return null;
        }

        final int monthOfYear = resultSet.getInt(names[MONTH_OF_YEAR]);
        final int dayOfMonth = resultSet.getInt(names[DAY_OF_MONTH]);

        return new LocalDate(year, monthOfYear, dayOfMonth);
    }

    /**
     * A helper function. The PROPERTY_TYPES are of type Type, convert these entries to NullableType
     * and return the corresponding sqlType for that NullableType.
     * 
     * @param index
     *            The index into PROPERTY_TYPES.
     * @return The sqlType.
     */
    private static int getSqlTypeFor(final int index)
    {
        final IntegerType it = (IntegerType) PROPERTY_TYPES[index];
        return it.sqlType();
    }

    /**
     * If no value, then null out, otherwise set the columns from a LocalDate.
     */
    @Override
    public void nullSafeSet(final PreparedStatement statement, final Object value, final int index,
            final SessionImplementor session) throws HibernateException, SQLException
    {
        if (value == null)
        {
            statement.setNull(YEAR, getSqlTypeFor(YEAR));
            statement.setNull(MONTH_OF_YEAR, getSqlTypeFor(MONTH_OF_YEAR));
            statement.setNull(DAY_OF_MONTH, getSqlTypeFor(DAY_OF_MONTH));
        }
        else
        {
            final LocalDate d = (LocalDate) value;
            statement.setInt(YEAR, d.getYear());
            statement.setInt(MONTH_OF_YEAR, d.getMonthOfYear());
            statement.setInt(DAY_OF_MONTH, d.getDayOfMonth());
        }
    }

    /**
     * Return the original object.
     */
    @Override
    public Object replace(final Object original, final Object target,
            final SessionImplementor session, final Object owner) throws HibernateException
    {
        return original;
    }

    /**
     * This composite type is for LocalDate.
     */
    @SuppressWarnings("unchecked")
    @Override
    public Class returnedClass()
    {
        return LocalDate.class;
    }

    /**
     * Not supported on a immutable type.
     */
    @Override
    public void setPropertyValue(final Object arg0, final int arg1, final Object arg2)
            throws HibernateException
    {
        throw new HibernateException("LocalDateCompositeUserType is immutable.");
    }

}
