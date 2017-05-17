package org.ncibi.db.gene2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "gene.Gene")
@Table (name = "Gene", schema = "gene")
public class Gene
{
    private Integer geneId;
    private Integer taxid;
    private String symbol;
    private String locusTag;
    private String chromosome;
    private String mapLoc;
    private String geneType;
    private String description;   
    private Set<GeneExternalRef> erefs = new HashSet<GeneExternalRef>(0);
    private Set<GeneName> names = new HashSet<GeneName>(); 
    private Set<GenePublication> pubs = new HashSet<GenePublication>();
    private Set<GoEntry> goEntries = new HashSet<GoEntry>();
    
    @Id
    @Column(name = "geneid", unique = true, nullable = false)
    public Integer getGeneId()
    {
        return geneId;
    }
    
    public void setGeneId(Integer geneId)
    {
        this.geneId = geneId;
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
    
    @Column(name = "symbol")
    public String getSymbol()
    {
        return symbol;
    }
    
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
    
    @Column(name = "locustag")
    public String getLocusTag()
    {
        return locusTag;
    }
    
    public void setLocusTag(String locusTag)
    {
        this.locusTag = locusTag;
    }
    
    @Column(name = "chromosome")
    public String getChromosome()
    {
        return chromosome;
    }
    
    public void setChromosome(String chromosome)
    {
        this.chromosome = chromosome;
    }
    
    @Column(name = "maploc")
    public String getMapLoc()
    {
        return mapLoc;
    }
    
    public void setMapLoc(String mapLoc)
    {
        this.mapLoc = mapLoc;
    }
    
    @Column(name = "genetype")
    public String getGeneType()
    {
        return geneType;
    }
    
    public void setGeneType(String geneType)
    {
        this.geneType = geneType;
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
    
    public void addExternalRef(GeneExternalRef eref)
    {
        eref.setGene(this);
        erefs.add(eref);
    }
    
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "gene")
    public Set<GeneExternalRef> getErefs()
    {
        return erefs;
    }
    
    public void setErefs(Set<GeneExternalRef> erefs)
    {
        this.erefs = erefs;
    }
    
    public void addName(GeneName gname)
    {
        gname.setGene(this);
        names.add(gname);
    }
    
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "gene")
    public Set<GeneName> getNames()
    {
        return names;
    }
    
    public void setNames(Set<GeneName> names)
    {
        this.names = names;
    }
    
    public void addPublication(GenePublication pub)
    {
        pub.setGene(this);
        pubs.add(pub);
    }
    
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "gene")
    public Set<GenePublication> getPubs()
    {
        return pubs;
    }
    
    public void setPubs(Set<GenePublication> pubs)
    {
        this.pubs = pubs;
    }
    
    public void addGoEntry(GoEntry entry)
    {
        entry.setGene(this);
        goEntries.add(entry);
    }
    
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "gene")
    public Set<GoEntry> getGoEntries()
    {
        return goEntries;
    }
    
    public void setGoEntries(Set<GoEntry> goEntries)
    {
        this.goEntries = goEntries;
    }
}
