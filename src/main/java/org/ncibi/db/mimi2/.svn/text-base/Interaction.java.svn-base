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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "mimi.Interaction")
@Table(name = "Interaction", schema = "mimi")
public class Interaction
{
    private int id;
    private BioEntity entityById1;
    private BioEntity entityById2;
    private Set<InteractionType> interactionTypes = new HashSet<InteractionType>(0);
    private Set<Experiment> experiments = new HashSet<Experiment>(0);
    private Set<InteractionDescription> descriptions = new HashSet<InteractionDescription>(0);
    private Set<InteractionExternalRef> externalrefs = new HashSet<InteractionExternalRef>(0);
    private Set<InteractionPublication> publications = new HashSet<InteractionPublication>(0);
    private Set<Provenance> provenance = new HashSet<Provenance>(0);

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entityById1", nullable = false)
    public BioEntity getEntityById1()
    {
        return entityById1;
    }

    public void setEntityById1(final BioEntity entityById1)
    {
        this.entityById1 = entityById1;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entityById2", nullable = false)
    public BioEntity getEntityById2()
    {
        return entityById2;
    }

    public void setEntityById2(final BioEntity entityById2)
    {
        this.entityById2 = entityById2;
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "Interaction2Type", schema = "mimi", joinColumns = { @JoinColumn(name = "interactionId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "interactionTypeId") })
    public Set<InteractionType> getInteractionTypes()
    {
        return interactionTypes;
    }

    public void setInteractionTypes(final Set<InteractionType> interactionTypes)
    {
        this.interactionTypes = interactionTypes;
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "Interaction2Experiment", schema = "mimi", joinColumns = { @JoinColumn(name = "interactionId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "experimentId") })
    public Set<Experiment> getExperiments()
    {
        return experiments;
    }

    public void setExperiments(final Set<Experiment> experiments)
    {
        this.experiments = experiments;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "interaction")
    public Set<InteractionDescription> getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(final Set<InteractionDescription> descriptions)
    {
        this.descriptions = descriptions;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "interaction")
    public Set<InteractionExternalRef> getExternalrefs()
    {
        return externalrefs;
    }

    public void setExternalrefs(final Set<InteractionExternalRef> externalrefs)
    {
        this.externalrefs = externalrefs;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "interaction")
    public Set<InteractionPublication> getPublications()
    {
        return publications;
    }

    public void setPublications(final Set<InteractionPublication> publications)
    {
        this.publications = publications;
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "Interaction2Provenance", schema = "mimi", joinColumns = { @JoinColumn(name = "interactionId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "provenanceId") })
    public Set<Provenance> getProvenance()
    {
        return provenance;
    }

    public void setProvenance(final Set<Provenance> provenance)
    {
        this.provenance = provenance;
    }

    public void setProvenance(final Provenance p)
    {
        provenance.add(p);
    }

    public void addDescription(final InteractionDescription d)
    {
        d.setInteraction(this);
        descriptions.add(d);
    }

    public void addExternalRef(final InteractionExternalRef er)
    {
        er.setInteraction(this);
        externalrefs.add(er);
    }

    public void addExperiment(final Experiment e)
    {
        experiments.add(e);
    }

    public void addPub(final InteractionPublication p)
    {
        p.setInteraction(this);
        publications.add(p);
    }

    public void addInteractionType(final InteractionType it)
    {
        interactionTypes.add(it);
    }
}