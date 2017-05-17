package org.ncibi.db.mimi2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "mimi.EntityDescription")
@Table (name = "EntityDescription", schema = "mimi")
public class EntityDescription
{
    private int id;
    private String description;
    private BioEntity entity;

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

    @Column (name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "entityId", nullable = false)
    public BioEntity getEntity()
    {
        return entity;
    }

    public void setEntity(BioEntity entity)
    {
        this.entity = entity;
    }
}
