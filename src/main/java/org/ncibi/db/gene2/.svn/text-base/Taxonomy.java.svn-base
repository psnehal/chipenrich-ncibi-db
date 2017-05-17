package org.ncibi.db.gene2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "gene.Taxonomy")
@Table (name = "Taxonomy", schema = "gene")
@GenericGenerator(name = "taxonomy-increment", strategy = "increment", parameters = { @Parameter(name = "schema", value = "gene") })
public class Taxonomy
{
    private Integer id;
    private Integer taxid;
    private Integer parentid;
    private String rank;
    private String embl;
    private String division;
    private String inheritedDiv;
    private String gc;
    private String inheritedGC;
    private String mitoGC;
    private String inheritedMitoGC;
    private String genbankHidden;
    private String subtreeHidden;
    private String comment;

    @Id
    @GeneratedValue(generator = "taxonomy-increment")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "taxid")
    public Integer getTaxid()
    {
        return taxid;
    }

    public void setTaxid(Integer taxid)
    {
        this.taxid = taxid;
    }

    @Column(name = "parentid")
    public Integer getParentid()
    {
        return parentid;
    }

    public void setParentid(Integer parentid)
    {
        this.parentid = parentid;
    }

    @Column(name = "rank")
    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    @Column(name = "embl")
    public String getEmbl()
    {
        return embl;
    }

    public void setEmbl(String embl)
    {
        this.embl = embl;
    }

    @Column(name = "division")
    public String getDivision()
    {
        return division;
    }

    public void setDivision(String division)
    {
        this.division = division;
    }

    @Column(name = "inheritedDiv")
    public String getInheritedDiv()
    {
        return inheritedDiv;
    }

    public void setInheritedDiv(String inheritedDiv)
    {
        this.inheritedDiv = inheritedDiv;
    }

    @Column(name = "gc")
    public String getGc()
    {
        return gc;
    }

    public void setGc(String gc)
    {
        this.gc = gc;
    }

    @Column(name = "inheritedGC")
    public String getInheritedGC()
    {
        return inheritedGC;
    }

    public void setInheritedGC(String inheritedGC)
    {
        this.inheritedGC = inheritedGC;
    }

    @Column(name = "mitoGC")
    public String getMitoGC()
    {
        return mitoGC;
    }

    public void setMitoGC(String mitoGC)
    {
        this.mitoGC = mitoGC;
    }

    @Column(name = "inheritedMitoGC")
    public String getInheritedMitoGC()
    {
        return inheritedMitoGC;
    }

    public void setInheritedMitoGC(String inheritedMitoGC)
    {
        this.inheritedMitoGC = inheritedMitoGC;
    }

    @Column(name = "genbankHidden")
    public String getGenbankHidden()
    {
        return genbankHidden;
    }

    public void setGenbankHidden(String genbankHidden)
    {
        this.genbankHidden = genbankHidden;
    }

    @Column(name = "subtreeHidden")
    public String getSubtreeHidden()
    {
        return subtreeHidden;
    }

    public void setSubtreeHidden(String subtreeHidden)
    {
        this.subtreeHidden = subtreeHidden;
    }

    @Column(name = "comment")
    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
