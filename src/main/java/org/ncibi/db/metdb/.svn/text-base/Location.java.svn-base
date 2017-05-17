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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "metdb.Location")
@Table (name = "Location", schema = "metdb")
@GenericGenerator(name = "location-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class Location
{
    private Integer id;
    private String name;
    //private String abbrev;
    private Set<LocationDescription> descriptions = new HashSet<LocationDescription>();
    private Set<LocationExternalRef> externalRefs = new HashSet<LocationExternalRef>();
    private Set<Compound> compounds = new HashSet<Compound>();
    private Set<Reaction> reactions = new HashSet<Reaction>();
    
    /**
     * @return the id
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "location-increment")
    public Integer getId()
    {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    /**
     * @return the location
     */
    @Column(name = "name")
    public String getName()
    {
        return name;
    }
    
    /**
     * @param location the location to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
//    @Column(name = "abbrev")
//    public String getAbbrev()
//    {
//        return this.abbrev;
//    }
//    
//    public void setAbbrev(String abbrev)
//    {
//        this.abbrev = abbrev;
//    }

    /**
     * @return the descriptions
     */
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "location")
    public Set<LocationDescription> getDescriptions()
    {
        return descriptions;
    }

    /**
     * @param descriptions the descriptions to set
     */
    public void setDescriptions(Set<LocationDescription> descriptions)
    {
        this.descriptions = descriptions;
    }
    
    /**
     * Add a description.
     * @param d
     */
    public void addDescription(LocationDescription d)
    {
        d.setLocation(this);
        descriptions.add(d);
    }

    /**
     * @return the externalRefs
     */
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "location")
    public Set<LocationExternalRef> getExternalRefs()
    {
        return externalRefs;
    }

    /**
     * @param externalRefs the externalRefs to set
     */
    public void setExternalRefs(Set<LocationExternalRef> externalRefs)
    {
        this.externalRefs = externalRefs;
    }
    
    /**
     * Add a LocationExternalRef.
     * 
     * @param eref
     */
    public void addExternalRef(LocationExternalRef eref)
    {
        eref.setLocation(this);
        externalRefs.add(eref);
    }

    /**
     * @return the compounds
     */
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Compound2Locations", schema = "metdb",
        joinColumns = { @JoinColumn (name = "locationid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "compoundid") })
    public Set<Compound> getCompounds()
    {
        return compounds;
    }

    /**
     * @param compounds the compounds to set
     */
    public void setCompounds(Set<Compound> compounds)
    {
        this.compounds = compounds;
    }
    
    /**
     * Add a compound.
     * @param c
     */
    public void addCompound(Compound c)
    {
        compounds.add(c);
    }

    /**
     * @return the reactions
     */
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "Reaction2Locations", schema = "metdb",
        joinColumns = { @JoinColumn (name = "locationid", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "reactionid") })
    public Set<Reaction> getReactions()
    {
        return reactions;
    }

    /**
     * @param reactions the reactions to set
     */
    public void setReactions(Set<Reaction> reactions)
    {
        this.reactions = reactions;
    }
    
    /**
     * Add a reaction.
     * @param r
     */
    public void addReaction(Reaction r)
    {
        reactions.add(r);
    }
}
