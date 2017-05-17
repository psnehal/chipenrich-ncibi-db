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

@Entity(name = "metdb.Compound")
@GenericGenerator(name = "cmpd-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
@Table (name = "Compound", schema = "metdb")
public class Compound
{
    private int id;
    private Double mw;
    private Integer approximateMw;
    private String formula;
    private String cid;
    private String smile;
    private String casnum;
    private String name;
    private Set<CompoundDescription> descriptions = new HashSet<CompoundDescription>();
    private Set<CompoundExternalRef> externalRefs = new HashSet<CompoundExternalRef>();
    private Set<Reaction> reactions = new HashSet<Reaction>();
    private Set<CompoundName> names = new HashSet<CompoundName>();
    private Set<Compartment> compartments = new HashSet<Compartment>();
    private Set<Pathway> pathways = new HashSet<Pathway>();
    private Set<Location> locations = new HashSet<Location>();
    private Provenance provenance;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "cmpd-increment")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "mw")
    public Double getMw()
    {
        return mw;
    }

    public void setMw(Double mw)
    {
        this.mw = mw;
    }
    
    @Column(name = "approximateMw")
    public Integer getApproximateMw()
    {
        return this.approximateMw;
    }
    
    public void setApproximateMw(Integer approximateMw)
    {
        this.approximateMw = approximateMw;
    }

    @Column(name = "formula")
    public String getFormula()
    {
        return formula;
    }

    public void setFormula(String formula)
    {
        this.formula = formula;
    }

    @Column(name = "cid")
    public String getCid()
    {
        return cid;
    }

    public void setCid(String cid)
    {
        this.cid = cid;
    }

    @Column(name = "smile")
    public String getSmile()
    {
        return smile;
    }

    public void setSmile(String smile)
    {
        this.smile = smile;
    }

    @Column(name = "casnum")
    public String getCasnum()
    {
        return casnum;
    }

    public void setCasnum(String casnum)
    {
        this.casnum = casnum;
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

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "compound")
    public Set<CompoundDescription> getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(Set<CompoundDescription> descriptions)
    {
        this.descriptions = descriptions;
    }
    
    public void addDescription(CompoundDescription cd)
    {
        cd.setCompound(this);
        descriptions.add(cd);
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "compound")
    public Set<CompoundExternalRef> getExternalRefs()
    {
        return externalRefs;
    }

    public void setExternalRefs(Set<CompoundExternalRef> externalRefs)
    {
        this.externalRefs = externalRefs;
    }
    
    public void addExternalRef(CompoundExternalRef eref)
    {
        eref.setCompound(this);
        externalRefs.add(eref);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Compound2Reaction", schema = "metdb",
        joinColumns = { @JoinColumn (name = "compoundid", nullable = false) },
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
            fetch = FetchType.LAZY, mappedBy = "compound")
    public Set<CompoundName> getNames()
    {
        return names;
    }

    public void setNames(Set<CompoundName> names)
    {
        this.names = names;
    }
    
    public void addName(CompoundName name)
    {
        name.setCompound(this);
        names.add(name);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Compound2Compartment", schema = "metdb",
        joinColumns = { @JoinColumn (name = "compoundid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compartmentid") })
    public Set<Compartment> getCompartments()
    {
        return compartments;
    }

    public void setCompartments(Set<Compartment> compartments)
    {
        this.compartments = compartments;
    }
    
    public void addCompartment(Compartment c)
    {
        compartments.add(c);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Pathway2Compound", schema = "metdb",
        joinColumns = { @JoinColumn (name = "compoundid", nullable = false) },
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

    /**
     * @return the locations
     */
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Compound2Location", schema = "metdb",
        joinColumns = { @JoinColumn (name = "compoundid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "locationid") })
    public Set<Location> getLocations()
    {
        return locations;
    }

    /**
     * @param locations the locations to set
     */
    public void setLocations(Set<Location> locations)
    {
        this.locations = locations;
    }
    
    public void addLocation(Location l)
    {
        locations.add(l);
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
    
    private void printStr(String name, String str)
    {
        if (str == null)
        {
            System.out.println(name + " is null");
        }
        else
        {
            System.out.println(name + " = " + str + "/" + str.length());
        }
    }
    
    public void print()
    {
        System.out.println("\n\nCompound \n\n");
        printStr("formula", formula);
        printStr("cid", cid);
        printStr("smile", smile);
        printStr("casnum", casnum);
        
        System.out.println("=== compartments ===");
        for(Compartment c : compartments)
        {
            printStr("compartment", c.getCompartment());
        }
        
        System.out.println("=== names ===");
        for(CompoundName cn : names)
        {
            printStr("name", cn.getName());
        }
        
        System.out.println("=== externalRefs ===");
        for (CompoundExternalRef ref : externalRefs)
        {
            printStr("idtype", ref.getIdtype());
            printStr("idvalue", ref.getIdvalue());
        }
    }
}
