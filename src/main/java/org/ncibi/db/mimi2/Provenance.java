package org.ncibi.db.mimi2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gtarcea
 */
@Entity(name = "mimi.Provenance")
@Table (name = "Provenance", schema = "mimi")
public class Provenance
{ 
    private int id; 
    private String provSource; 
    private String sourceDate;
    private String loadDate;
    private String notes;

    @Id
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
    public String getProvSource()
    {
        return provSource;
    }

    public void setProvSource(String provSource)
    {
        this.provSource = provSource;
    }

    @Column (name = "sourceDate", nullable = false)
    public String getSourceDate()
    {
        return sourceDate;
    }

    public void setSourceDate(String sourceDate)
    {
        this.sourceDate = sourceDate;
    }

    @Column (name = "loadDate", nullable = false)
    public String getLoadDate()
    {
        return loadDate;
    }

    public void setLoadDate(String loadDate)
    {
        this.loadDate = loadDate;
    }

    @Column (name = "notes", nullable = false)
    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }
}

