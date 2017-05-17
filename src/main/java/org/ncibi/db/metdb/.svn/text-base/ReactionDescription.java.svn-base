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

@Entity(name = "metdb.ReactionDescription")
@Table (name = "ReactionDescription", schema = "metdb")
@GenericGenerator(name = "reaction-desc-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class ReactionDescription
{
    private Integer id;
    private String description;   
    private Reaction reaction;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "reaction-desc-increment")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
