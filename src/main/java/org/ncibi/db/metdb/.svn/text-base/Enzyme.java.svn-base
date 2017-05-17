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

@Entity(name = "metdb.Enzyme")
@GenericGenerator(name = "enzyme-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
@Table (name = "Enzyme", schema = "metdb")
public class Enzyme
{
    private Integer id;
    private String ecnum;
    private Set<EnzymeName> names = new HashSet<EnzymeName>();
    private Set<EnzymeClass> eclasses = new HashSet<EnzymeClass>();
    private Set<EnzymeDescription> descriptions = new HashSet<EnzymeDescription>();
    private Set<Compound> cofactors = new HashSet<Compound>();
    private Set<Compound> substrates = new HashSet<Compound>();
    private Set<Compound> products = new HashSet<Compound>();
    private Set<Reaction> reactions = new HashSet<Reaction>();
    private Set<EnzymeExternalRef> externalRefs = new HashSet<EnzymeExternalRef>();
    private Set<Gene> genes = new HashSet<Gene>();
    private Set<Pathway> pathways = new HashSet<Pathway>();
    private Provenance provenance;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "enzyme-increment")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "ecnum")
    public String getEcnum()
    {
        return ecnum;
    }

    public void setEcnum(String ecnum)
    {
        this.ecnum = ecnum;
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "enzyme")
    public Set<EnzymeName> getNames()
    {
        return names;
    }

    public void setNames(Set<EnzymeName> names)
    {
        this.names = names;
    }
    
    public void addName(EnzymeName en)
    {
        en.setEnzyme(this);
        names.add(en);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Enzyme2Class", schema = "metdb",
        joinColumns = { @JoinColumn (name = "enzymeid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "classid") })
    public Set<EnzymeClass> getEclasses()
    {
        return eclasses;
    }

    public void setEclasses(Set<EnzymeClass> eclasses)
    {
        this.eclasses = eclasses;
    }
    
    public void addEnzymeClass(EnzymeClass ec)
    {
        eclasses.add(ec);
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "enzyme")
    public Set<EnzymeDescription> getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(Set<EnzymeDescription> descriptions)
    {
        this.descriptions = descriptions;
    }
    
    public void addDescription(EnzymeDescription ed)
    {
        ed.setEnzyme(this);
        descriptions.add(ed);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Enzyme2Cofactor", schema = "metdb",
        joinColumns = { @JoinColumn (name = "enzymeid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    public Set<Compound> getCofactors()
    {
        return cofactors;
    }

    public void setCofactors(Set<Compound> cofactors)
    {
        this.cofactors = cofactors;
    }
    
    public void addCofactor(Compound c)
    {
        cofactors.add(c);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Enzyme2Substrate", schema = "metdb",
        joinColumns = { @JoinColumn (name = "enzymeid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    public Set<Compound> getSubstrates()
    {
        return substrates;
    }

    public void setSubstrates(Set<Compound> substrates)
    {
        this.substrates = substrates;
    }
    
    public void addSubstrate(Compound c)
    {
        substrates.add(c);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Enzyme2Product", schema = "metdb",
        joinColumns = { @JoinColumn (name = "enzymeid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    public Set<Compound> getProducts()
    {
        return products;
    }

    public void setProducts(Set<Compound> products)
    {
        this.products = products;
    }
    
    public void addProduct(Compound c)
    {
        products.add(c);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Enzyme", schema = "metdb",
        joinColumns = { @JoinColumn (name = "enzymeid", nullable = false) },
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

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "enzyme")
    public Set<EnzymeExternalRef> getExternalRefs()
    {
        return externalRefs;
    }

    public void setExternalRefs(Set<EnzymeExternalRef> externalRefs)
    {
        this.externalRefs = externalRefs;
    }
    
    public void addExternalRef(EnzymeExternalRef eref)
    {
        eref.setEnzyme(this);
        externalRefs.add(eref);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Gene2Enzyme", schema = "metdb",
        joinColumns = { @JoinColumn (name = "enzymeid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "geneid") })
    public Set<Gene> getGenes()
    {
        return genes;
    }

    public void setGenes(Set<Gene> genes)
    {
        this.genes = genes;
    }
    
    public void addGene(Gene gene)
    {
        genes.add(gene);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Enzyme2Pathway", schema = "metdb",
        joinColumns = { @JoinColumn (name = "enzymeid", nullable = false) },
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
