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

/**
 *
 * @author gtarcea
 */
@Entity(name = "mimi.EntityPublication")
@Table (name = "EntityPublication", schema = "mimi")
public class EntityPublication
{  
    private int id; 
    private int pmid; 
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

    @Column(name = "pmid", unique = true, nullable = false)
    public int getPmid()
    {
        return pmid;
    }

    public void setPmid(int pmid)
    {
        this.pmid = pmid;
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

