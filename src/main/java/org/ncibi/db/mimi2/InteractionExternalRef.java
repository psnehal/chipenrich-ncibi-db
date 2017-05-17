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

@Entity(name = "mimi.InteractionExternalRef")
@Table (name = "InteractionExternalRef", schema = "mimi")
public class InteractionExternalRef
{   
    private int id;
    private String idtype;
    private String idvalue;
    private Interaction interaction;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
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
    @JoinColumn (name = "interactionId", nullable = false)
    public Interaction getInteraction()
    {
        return interaction;
    }

    public void setInteraction(Interaction interaction)
    {
        this.interaction = interaction;
    }
}
