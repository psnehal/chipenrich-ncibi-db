package org.ncibi.db.mimi2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "mimi.InteractionType")
@Table (name = "InteractionType", schema = "mimi")
public class InteractionType
{  
    private int id;  
    private String idtype;
    private String idvalue;
    private String interactionType;
    
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

    @Column (name = "interactionType")
    public String getInteractionType()
    {
        return interactionType;
    }

    public void setInteractionType(String interactionType)
    {
        this.interactionType = interactionType;
    }
}
