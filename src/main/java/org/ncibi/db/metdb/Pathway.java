package org.ncibi.db.metdb;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "metdb.Pathway")
@GenericGenerator(name = "pathway-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
@Table (name = "Pathway", schema = "metdb")
public class Pathway
{
    private int id;
    private String name;   
    private String pid;
    private Set<PathwayDescription> descriptions = new HashSet<PathwayDescription>();
    private Set<PathwayExternalRef> externalRefs = new HashSet<PathwayExternalRef>();
    private Set<Pathway> relatedPathways = new HashSet<Pathway>();
    private Set<Reaction> reactions = new HashSet<Reaction>();
    private Set<Compound> compounds = new HashSet<Compound>();
    private Set<Enzyme> enzymes = new HashSet<Enzyme>();
    private Set<Gene> genes = new HashSet<Gene>();
    private Set<PathwayClass> pclasses = new HashSet<PathwayClass>();
    private Set<PathwayName> names = new HashSet<PathwayName>();
    private Provenance provenance;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "pathway-increment")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    @Column(name = "pid")
    public String getPid()
    {
        return pid;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "pathway")
    public Set<PathwayDescription> getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(Set<PathwayDescription> descriptions)
    {
        this.descriptions = descriptions;
    }
    
    public void addDescription(PathwayDescription pd)
    {
        pd.setPathway(this);
        descriptions.add(pd);
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "pathway")
    public Set<PathwayExternalRef> getExternalRefs()
    {
        return externalRefs;
    }

    public void setExternalRefs(Set<PathwayExternalRef> externalRefs)
    {
        this.externalRefs = externalRefs;
    }
    
    public void addExternalRef(PathwayExternalRef eref)
    {
        eref.setPathway(this);
        externalRefs.add(eref);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Pathway2RelatedPathway", schema = "metdb",
        joinColumns = { @JoinColumn (name = "pathwayid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "relatedid") })
    public Set<Pathway> getRelatedPathways()
    {
        return relatedPathways;
    }

    public void setRelatedPathways(Set<Pathway> relatedPathways)
    {
        this.relatedPathways = relatedPathways;
    }
    
    public void addRelatedPathway(Pathway p)
    {
        relatedPathways.add(p);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Pathway", schema = "metdb",
        joinColumns = { @JoinColumn (name = "pathwayid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "reactionid") })
    public Set<Reaction> getReactions()
    {
        return reactions;
    }

    public void setReactions(Set<Reaction> reactions)
    {
        this.reactions = reactions;
    }
    
    public void addReaction(Reaction r)
    {
        reactions.add(r);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Pathway2Compound", schema = "metdb",
        joinColumns = { @JoinColumn (name = "pathwayid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    public Set<Compound> getCompounds()
    {
        return compounds;
    }

    public void setCompounds(Set<Compound> compounds)
    {
        this.compounds = compounds;
    }
    
    public void addCompound(Compound c)
    {
        compounds.add(c);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Enzyme2Pathway", schema = "metdb",
        joinColumns = { @JoinColumn (name = "pathwayid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "enzymeid") })
    public Set<Enzyme> getEnzymes()
    {
        return this.enzymes;
    }
    
    public void setEnzymes(Set<Enzyme> enzymes)
    {
        this.enzymes = enzymes;
    }
    
    public void addEnzyme(Enzyme e)
    {
        this.enzymes.add(e);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Gene2Pathway", schema = "metdb",
        joinColumns = { @JoinColumn (name = "pathwayid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "geneid") })
    public Set<Gene> getGenes()
    {
        return this.genes;
    }
    
    public void setGenes(Set<Gene> genes)
    {
        this.genes = genes;
    }
    
    public void addGene(Gene g)
    {
        this.genes.add(g);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Pathway2Class", schema = "metdb",
        joinColumns = { @JoinColumn (name = "pathwayid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "classid") })
    public Set<PathwayClass> getPclasses()
    {
        return pclasses;
    }

    public void setPclasses(Set<PathwayClass> pclasses)
    {
        this.pclasses = pclasses;
    }
    
    public void addPathwayClass(PathwayClass pc)
    {
        pclasses.add(pc);
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "pathway")
    public Set<PathwayName> getNames()
    {
        return names;
    }

    public void setNames(Set<PathwayName> names)
    {
        this.names = names;
    }
    
    public void addName(PathwayName pn)
    {
        pn.setPathway(this);
        names.add(pn);
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "provenanceid", nullable = false)
    public Provenance getProvenance()
    {
        return provenance;
    }
    
    public void setProvenance(Provenance provenance)
    {
        this.provenance = provenance;
    }
}
