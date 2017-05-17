package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "metdb.CompoundDescription")
@Table (name = "CompoundDescription", schema = "metdb")
@GenericGenerator(name = "cmpd-desc-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class CompoundDescription
{
    private Integer id;  
    private String description;
    private Compound compound;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "cmpd-desc-increment")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "compoundid", nullable = false)
    public Compound getCompound()
    {
        return compound;
    }

    public void setCompound(Compound compound)
    {
        this.compound = compound;
    }
}
