package org.ncibi.db.mimi2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gtarcea
 */
@Entity(name = "mimi.ExternalRef")
@Table (name = "ExternalRef", schema = "mimi")
public class ExternalRef
{  
    private int id;
    private String idtype;
    private String idvalue;
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

    @Column(name = "idtype")
    public String getIdtype()
    {
        return idtype;
    }

    public void setIdtype(String idtype)
    {
        this.idtype = idtype;
    }

    @Column(name = "idvalue")
    public String getIdvalue()
    {
        return idvalue;
    }

    public void setIdvalue(String idvalue)
    {
        this.idvalue = idvalue;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinTable (name = "Entity2ExternalRef", schema = "mimi",
        joinColumns = {@JoinColumn (name = "erefId", nullable = false)},
        inverseJoinColumns = {@JoinColumn (name = "entityId")})
    public BioEntity getEntity()
    {
        return entity;
    }

    public void setEntity(BioEntity entity)
    {
        this.entity = entity;
    }
}

