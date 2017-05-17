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
import org.hibernate.annotations.WhereJoinTable;

@Entity(name = "metdb.Reaction")
@GenericGenerator(name = "reaction-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
@Table (name = "Reaction", schema = "metdb")
public class Reaction
{
    private int id;
    private String rid;    
    private Boolean reversible;
    private Set<ReactionDescription> descriptions = new HashSet<ReactionDescription>();
    private Set<ReactionExternalRef> externalRefs = new HashSet<ReactionExternalRef>();
    private Set<ReactionEquation> equations = new HashSet<ReactionEquation>();
    private Set<Pathway> pathways = new HashSet<Pathway>();
    private Set<Enzyme> enzymes = new HashSet<Enzyme>();
    private Set<Subsystem> subsystems = new HashSet<Subsystem>();
    private Set<Compartment> compartments = new HashSet<Compartment>();
    private Set<ReactionName> names = new HashSet<ReactionName>();
    private Set<Compound> inputs = new HashSet<Compound>();
    private Set<Compound> outputs = new HashSet<Compound>();
    private Set<Compound> allCmpds = new HashSet<Compound>();
    private Set<Compound> mainCmpds = new HashSet<Compound>();
    private Set<Location> locations = new HashSet<Location>();
    private Set<ReactionPublication> publications = new HashSet<ReactionPublication>();
    private Provenance provenance;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "reaction-increment")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "rid")
    public String getRid()
    {
        return rid;
    }

    public void setRid(String rid)
    {
        this.rid = rid;
    }

    @Column(name = "reversible")
    public Boolean getReversible()
    {
        return reversible;
    }

    public void setReversible(Boolean reversible)
    {
        this.reversible = reversible;
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "reaction")
    public Set<ReactionDescription> getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(Set<ReactionDescription> descriptions)
    {
        this.descriptions = descriptions;
    }
    
    public void addDescription(ReactionDescription d)
    {
        d.setReaction(this);
        descriptions.add(d);
    }
    
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "reaction")
    public Set<ReactionExternalRef> getExternalRefs()
    {
        return externalRefs;
    }

    public void setExternalRefs(Set<ReactionExternalRef> externalRefs)
    {
        this.externalRefs = externalRefs;
    }
    
    public void addExternalRef(ReactionExternalRef eref)
    {
        eref.setReaction(this);
        externalRefs.add(eref);
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "reaction")
    public Set<ReactionEquation> getEquations()
    {
        return equations;
    }

    public void setEquations(Set<ReactionEquation> equations)
    {
        this.equations = equations;
    }
    
    public void addEquation(ReactionEquation e)
    {
        e.setReaction(this);
        equations.add(e);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Pathway", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
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
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Enzyme", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
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
    @JoinTable (name = "Reaction2Subsystem", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "subsystemid") })
    public Set<Subsystem> getSubsystems()
    {
        return subsystems;
    }

    public void setSubsystems(Set<Subsystem> subsystems)
    {
        this.subsystems = subsystems;
    }
    
    public void addSubsystem(Subsystem s)
    {
        subsystems.add(s);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Compartment", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
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

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "reaction")
    public Set<ReactionName> getNames()
    {
        return names;
    }

    public void setNames(Set<ReactionName> names)
    {
        this.names = names;
    }
    
    public void addName(ReactionName rn)
    {
        rn.setReaction(this);
        names.add(rn);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Inputs", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    public Set<Compound> getInputs()
    {
        return inputs;
    }

    public void setInputs(Set<Compound> inputs)
    {
        this.inputs = inputs;
    }
    
    public void addInput(Compound c)
    {
        inputs.add(c);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Outputs", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    public Set<Compound> getOutputs()
    {
        return outputs;
    }

    public void setOutputs(Set<Compound> outputs)
    {
        this.outputs = outputs;
    }
    
    public void addOutput(Compound c)
    {
        outputs.add(c);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Compound2Reaction", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    public Set<Compound> getAllCmpds() {
		return allCmpds;
	}

	public void setAllCmpds(Set<Compound> allCmpds) {
		this.allCmpds = allCmpds;
	}

	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Compound2Reaction", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    @WhereJoinTable (clause = "ismain = 1")
    public Set<Compound> getMainCmpds() 
    {
		return mainCmpds;
	}

	public void setMainCmpds(Set<Compound> mainCmpds) 
	{
		this.mainCmpds = mainCmpds;
	}

	/**
     * @return the locations
     */
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Location", schema = "metdb",
        joinColumns = { @JoinColumn (name = "reactionid", nullable = false) },
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

    /**
     * @return the publications
     */
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "reaction")
    public Set<ReactionPublication> getPublications()
    {
        return publications;
    }

    /**
     * @param publications the publications to set
     */
    public void setPublications(Set<ReactionPublication> publications)
    {
        this.publications = publications;
    }
    
    public void addPublication(ReactionPublication pub)
    {
        pub.setReaction(this);
        this.publications.add(pub);
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
