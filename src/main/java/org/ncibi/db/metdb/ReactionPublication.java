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

@Entity(name = "metdb.ReactionPublication")
@Table (name = "ReactionPublication", schema = "metdb")
@GenericGenerator(name = "reaction-pub-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class ReactionPublication
{
    private Integer id;
    private String pubid;
    private String pubtype;    
    private Reaction reaction;

    /**
     * @return the id
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "reaction-pub-increment")
    public Integer getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * @return the pubid
     */
    @Column(name = "pubid")
    public String getPubid()
    {
        return pubid;
    }

    /**
     * @param pubid the pubid to set
     */
    public void setPubid(String pubid)
    {
        this.pubid = pubid;
    }

    /**
     * @return the pubtype
     */
    @Column(name = "pubtype")
    public String getPubtype()
    {
        return pubtype;
    }

    /**
     * @param pubtype the pubtype to set
     */
    public void setPubtype(String pubtype)
    {
        this.pubtype = pubtype;
    }

    /**
     * @return the reaction
     */
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "reactionid", nullable = false)
    public Reaction getReaction()
    {
        return reaction;
    }

    /**
     * @param reaction the reaction to set
     */
    public void setReaction(Reaction reaction)
    {
        this.reaction = reaction;
    } 
}
