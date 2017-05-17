package org.ncibi.db.metdb;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "metdb.Gene")
@Table (name = "Gene", schema = "metdb")
public class Gene
{
    private Integer geneid;
    private Integer taxid;
    private String symbol;
    private String description;
    private Set<Enzyme> enzymes = new HashSet<Enzyme>();
    private Set<Pathway> pathways = new HashSet<Pathway>();

    @Id
    @Column(name = "geneid", unique = true, nullable = false)
    public Integer getGeneid()
    {
        return geneid;
    }
    
    public void setGeneid(Integer geneid)
    {
        this.geneid = geneid;
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

    /**
     * @return the symbol
     */
    @Column(name = "symbol")
    public String getSymbol()
    {
        return this.symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
    
    /**
     * @return the description
     */
    @Column(name = "description")
    public String getDescription()
    {
        return this.description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Gene2Enzyme", schema = "metdb",
        joinColumns = { @JoinColumn (name = "geneid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "enzymeid") })
    public Set<Enzyme> getEnzymes()
    {
        return enzymes;
    }

    public void setEnzymes(Set<Enzyme> enzymes)
    {
        this.enzymes = enzymes;
    }
    
    public void addEnzyme(Enzyme e)
    {
        enzymes.add(e);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Gene2Pathway", schema = "metdb",
        joinColumns = { @JoinColumn (name = "geneid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "pathwayid") })
    public Set<Pathway> getPathways()
    {
        return pathways;
    }

    public void setPathways(Set<Pathway> pathways)
    {
        this.pathways = pathways;
    }
    
    public void addPathway(Pathway p)
    {
        pathways.add(p);
    }
    
}
