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

@Entity(name = "metdb.PathwayName")
@Table (name = "PathwayName", schema = "metdb")
@GenericGenerator(name = "pathway-name-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class PathwayName
{
    private Integer id;
    private String name;    
    private String nameType;
    private Pathway pathway;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "pathway-name-increment")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "nametype")
    public String getNameType()
    {
        return nameType;
    }

    public void setNameType(String nameType)
    {
        this.nameType = nameType;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "pathwayid", nullable = false)
    public Pathway getPathway()
    {
        return pathway;
    }

    public void setPathway(Pathway pathway)
    {
        this.pathway = pathway;
    }
}
