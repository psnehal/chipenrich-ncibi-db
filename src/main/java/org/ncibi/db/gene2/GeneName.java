package org.ncibi.db.gene2;

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

@Entity(name = "gene.GeneName")
@Table(name = "GeneName", schema = "gene")
@GenericGenerator(name = "genename-increment", strategy = "increment", parameters = { @Parameter(name = "schema", value = "gene") })
public class GeneName
{
    private Integer id;
    private String name;
    private String nametype;
    private Integer geneid;
    private Gene gene;

    @Id
    @GeneratedValue(generator = "genename-increment")
    @Column(name = "id", unique = true, nullable = false)
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
    public String getNametype()
    {
        return nametype;
    }

    public void setNametype(String nameType)
    {
        this.nametype = nameType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geneid", nullable = false, insertable = false, updatable = false)
    public Gene getGene()
    {
        return gene;
    }

    public void setGene(Gene gene)
    {
        this.gene = gene;
    }

    @Column(name = "geneid", nullable = false)
    public Integer getGeneid()
    {
        return this.geneid;
    }

    public void setGeneid(int geneid)
    {
        this.geneid = geneid;
    }
}
