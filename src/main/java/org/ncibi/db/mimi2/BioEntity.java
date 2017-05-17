package org.ncibi.db.mimi2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "mimi.BioEntity")
@Table (name = "BioEntity", schema = "mimi")
public class BioEntity
{  
    private int id;   
    private int taxid;    
    private Set<EntityExternalRef> externalrefs = new HashSet<EntityExternalRef>(0);    
    private Set<EntityName> names = new HashSet<EntityName>();    
    private Set<PTM> ptms = new HashSet<PTM>();   
    private Set<EntityDescription> descriptions = new HashSet<EntityDescription>(0);   
    private Set<ExternalRef> erefs = new HashSet<ExternalRef>(0);  
    private Set<Provenance> provenance = new HashSet<Provenance>(0);

    //@OneToOne(cascade = [ CascadeType.PERSIST, CascadeType.MERGE ], fetch = FetchType.LAZY, mappedBy = "entity")
    //@JoinColumn(name = "entityTypeId")
    // EntityType entityType
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "id", unique = true, nullable = false)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "taxid", nullable = false)
    public int getTaxid()
    {
        return taxid;
    }

    public void setTaxid(int taxid)
    {
        this.taxid = taxid;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "entity")
    public Set<EntityExternalRef> getExternalrefs()
    {
        return externalrefs;
    }

    public void setExternalrefs(Set<EntityExternalRef> externalrefs)
    {
        this.externalrefs = externalrefs;
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "entity")
    public Set<EntityName> getNames()
    {
        return names;
    }

    public void setNames(Set<EntityName> names)
    {
        this.names = names;
    }

    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "entity")
    public Set<PTM> getPtms()
    {
        return ptms;
    }

    public void setPtms(Set<PTM> ptms)
    {
        this.ptms = ptms;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "entity")
    public Set<EntityDescription> getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(Set<EntityDescription> descriptions)
    {
        this.descriptions = descriptions;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entity")
    public Set<ExternalRef> getErefs()
    {
        return erefs;
    }

    public void setErefs(Set<ExternalRef> erefs)
    {
        this.erefs = erefs;
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)//, mappedBy = "interaction")
    @JoinTable (name = "Entity2Provenance", schema = "mimi",
        joinColumns = {@JoinColumn (name = "entityId", nullable = false)},
        inverseJoinColumns = {@JoinColumn (name = "provenanceId")})
    public Set<Provenance> getProvenance()
    {
        return provenance;
    }

    public void setProvenance(Set<Provenance> provenance)
    {
        this.provenance = provenance;
    }
    
    public void setProvenance(Provenance p)
    {
        provenance.add(p);
    }

    public void addExternalRef(EntityExternalRef eref)
    {
        eref.setEntity(this);
        externalrefs.add(eref);
    }

    public void addEntityName(EntityName en)
    {
        en.setEntity(this);
        names.add(en);  
    }

    public void addPtm(PTM ptm)
    {
        ptm.setEntity(this);
        ptms.add(ptm);
    }

    public void addDescription(EntityDescription d)
    {
        d.setEntity(this);
        descriptions.add(d);
    }
}