package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "metdb.ReactionExternalRef")
@Table (name = "ReactionExternalRef", schema = "metdb")
@GenericGenerator(name = "reaction-ref-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class ReactionExternalRef
{
    private Integer id;
    private String idtype;
    private String idvalue;
    private boolean uniqueRef;  
    private Reaction reaction;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "reaction-ref-increment")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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

    @Column(name = "uniqueref")
    public boolean isUniqueRef()
    {
        return uniqueRef;
    }

    public void setUniqueRef(boolean uniqueRef)
    {
        this.uniqueRef = uniqueRef;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "reactionid", nullable = false)
    public Reaction getReaction()
    {
        return reaction;
    }

    public void setReaction(Reaction reaction)
    {
        this.reaction = reaction;
    }
}
