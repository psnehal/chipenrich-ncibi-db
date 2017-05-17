package org.ncibi.db.provenance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity(name = "prov.Provenance")
@GenericGenerator(name = "prov-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "prov") })
@Table (name = "Provenance", schema = "prov")
public class Provenance
{
    private int id; 
    private String source;
    private LocalDate sourceDate;
    private LocalDate loadDate;
    private String notes;

    @Id
    @GeneratedValue(generator = "prov-increment")
    @Column (name = "id", unique = true, nullable = false)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column (name = "source", nullable = false)
    public String getSource()
    {
        return source;
    }
    
    public void setSource(String source)
    {
        this.source = source;
    }

    @Type(type = "org.ncibi.hibernate.usertype.LocalDateCompositeUserType")
    @Columns(columns = { @Column(name = "sourceYear"), @Column(name = "sourceMonth"), @Column(name = "sourceDay")})
    public LocalDate getSourceDate()
    {
        return sourceDate;
    }

    public void setSourceDate(LocalDate sourceDate)
    {
        this.sourceDate = sourceDate;
    }

    @Type(type = "org.ncibi.hibernate.usertype.LocalDateCompositeUserType")
    @Columns(columns = { @Column(name = "loadYear"), @Column(name = "loadMonth"), @Column(name = "loadDay")})
    public LocalDate getLoadDate()
    {
        return loadDate;
    }

    public void setLoadDate(LocalDate loadDate)
    {
        this.loadDate = loadDate;
    }

    @Column(name = "notes")
    public String getNotes()
    {
        return notes;
    }
    
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    @Override
    public String toString()
    {
        return "Provenance [id=" + id + ", loadDate=" + loadDate + ", notes="
                + notes + ", source=" + source + ", sourceDate=" + sourceDate
                + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result
                + ((loadDate == null) ? 0 : loadDate.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result
                + ((sourceDate == null) ? 0 : sourceDate.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (!(obj instanceof Provenance)) { return false; }
        Provenance other = (Provenance) obj;
        if (id != other.id) { return false; }
        if (loadDate == null)
        {
            if (other.loadDate != null) { return false; }
        }
        else if (!loadDate.equals(other.loadDate)) { return false; }
        if (notes == null)
        {
            if (other.notes != null) { return false; }
        }
        else if (!notes.equals(other.notes)) { return false; }
        if (source == null)
        {
            if (other.source != null) { return false; }
        }
        else if (!source.equals(other.source)) { return false; }
        if (sourceDate == null)
        {
            if (other.sourceDate != null) { return false; }
        }
        else if (!sourceDate.equals(other.sourceDate)) { return false; }
        return true;
    }
    
    
}
