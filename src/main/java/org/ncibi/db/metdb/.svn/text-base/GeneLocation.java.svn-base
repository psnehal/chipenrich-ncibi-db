package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity(name = "metdb.GeneLocation")
@Table(name = "GeneLocation", schema = "metdb")
public class GeneLocation
{
    private int id;
    private int geneid;
    private String location;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    @Column(name = "geneid")
    public int getGeneid()
    {
        return geneid;
    }

    public void setGeneid(int geneid)
    {
        this.geneid = geneid;
    }

    @Column(name = "location")
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
