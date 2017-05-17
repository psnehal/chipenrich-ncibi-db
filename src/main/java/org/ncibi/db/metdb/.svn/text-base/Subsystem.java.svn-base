package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "metdb.Subsystem")
@Table (name = "Subsystem", schema = "metdb")
public class Subsystem
{
    private Integer id;  
    private String subsystem;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "subsystem")
    public String getSubsystem()
    {
        return subsystem;
    }

    public void setSubsystem(String subsystem)
    {
        this.subsystem = subsystem;
    }
}
