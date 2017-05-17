package org.ncibi.db.provenance;

import org.joda.time.LocalDate;
import org.ncibi.commons.exception.ConstructorCalledError;

/**
 * Utility class for creating a provenance style date. Performs
 * validation of the date and provides static factories for
 * common date elements. Class is immutable.
 * 
 * @author gtarcea
 *
 */
public final class ProvenanceDate
{
    
    /**
     * Utility class, no constructor.
     */
    private ProvenanceDate()
    {
        throw new ConstructorCalledError(this.getClass());
    }
    
    /**
     * Get the date for today.
     * @return
     */
    public static LocalDate today()
    {
        return new LocalDate();
    }
}
