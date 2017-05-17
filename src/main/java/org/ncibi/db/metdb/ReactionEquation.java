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

@Entity(name = "metdb.ReactionEquation")
@Table (name = "ReactionEquation", schema = "metdb")
@GenericGenerator(name = "reaction-eq-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class ReactionEquation
{
    private int id;
    private String etype;
    private String equation;
    private Reaction reaction;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "reaction-eq-increment")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "etype")
    public String getEtype()
    {
        return etype;
    }

    public void setEtype(String etype)
    {
        this.etype = etype;
    }

    @Column(name = "equation")
    public String getEquation()
    {
        return equation;
    }

    public void setEquation(String equation)
    {
        this.equation = equation;
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
