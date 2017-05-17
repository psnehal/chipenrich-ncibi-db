package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "metdb.ReactionEquationDenorm")
@Table (name = "ReactionEquationDenorm", schema = "metdb")
@GenericGenerator(name = "reaction-eq-denorm-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class ReactionEquationDenorm
{
    private int id;
    private String rid;
    private boolean reversible;
    private String equation;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "reaction-eq-denorm-increment")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "rid")
    public String getRid()
    {
        return rid;
    }

    public void setRid(String rid)
    {
        this.rid = rid;
    }
    
    @Column(name = "reversible")
    public boolean isReversible()
    {
        return reversible;
    }

    public void setReversible(boolean reversible)
    {
        this.reversible = reversible;
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
    
}
