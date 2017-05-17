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

@Entity(name = "mimi.EntityName")
@Table (name = "EntityName", schema = "mimi")
public class EntityName
{   
    private int id;
    private String nameType; 
    private String name; 
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

    @Column (name = "nameType")
    public String getNameType()
    {
        return nameType;
    }

    public void setNameType(String nameType)
    {
        this.nameType = nameType;
    }

    @Column (name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        int length = name.length();
        if (length > 254)
        {
            System.out.println("(" + length + ") Truncating name:" + name);
            this.name = name.substring(0, 254);
        }
        else
        {
            this.name = name;
        }
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
