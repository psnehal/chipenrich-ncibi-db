package org.ncibi.db.mimi2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "mimi.Experiment")
@Table (name = "Experiment", schema = "mimi")
public class Experiment 
{
    private int id;
    private String idtype;
    private String idvalue;
    private String experiment;
    
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

    @Column (name = "experiment")
    public String getExperiment()
    {
        return experiment;
    }

    public void setExperiment(String e)
    {
        experiment = e;
    }

    @Override
    public String toString()
    {
        return "Experiment [id=" + id + ", idtype=" + idtype + ", idvalue=" + idvalue + ", experiment="
                + experiment + "]";
    }
}
