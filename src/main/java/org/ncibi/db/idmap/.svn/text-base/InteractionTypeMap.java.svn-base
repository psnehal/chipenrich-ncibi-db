package org.ncibi.db.idmap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "idmap.InteractionTypeMap")
@Table (name = "InteractionTypeMap", schema = "idmap")
public class InteractionTypeMap
{
    private int id;
    private String idtype;
    private String idvalue;
    private String interactionType;   
    private String imap;

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

    @Column(name = "interactionType")
    public String getInteractionType()
    {
        return interactionType;
    }

    public void setInteractionType(String interactionType)
    {
        this.interactionType = interactionType;
    }

    @Column(name = "imap")
    public String getImap()
    {
        return imap;
    }

    public void setImap(String imap)
    {
        this.imap = imap;
    }
}
