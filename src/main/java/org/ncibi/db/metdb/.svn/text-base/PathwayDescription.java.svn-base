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

@Entity(name = "metdb.PathwayDescription")
@GenericGenerator(name = "pathway-desc-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
@Table (name = "PathwayDescription", schema = "metdb")
public class PathwayDescription
{
    private Integer id;
    private String description; 
    private Pathway pathway;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "pathway-desc-increment")
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
