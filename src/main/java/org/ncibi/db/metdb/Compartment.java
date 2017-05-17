package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "metdb.Compartment")
@Table (name = "Compartment", schema = "metdb")
public class Compartment
{
    private Integer id;  
    private String compartment;

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

    @Column(name = "compartment")
    public String getCompartment()
    {
        return compartment;
    }

    public void setCompartment(String compartment)
    {
        this.compartment = compartment;
    }
    

}
