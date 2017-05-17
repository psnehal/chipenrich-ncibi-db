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

@Entity(name = "metdb.LocationExternalRef")
@Table (name = "LocationExternalRef", schema = "metdb")
@GenericGenerator(name = "location-eref-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class LocationExternalRef
{
    private Integer id;
    private String idtype;   
    private String idvalue;
    private Location location;
    
    public LocationExternalRef()
    {
        
    }
    
    public LocationExternalRef(String idtype, String idvalue)
    {
        this.idtype = idtype;
        this.idvalue = idvalue;
    }

    /**
     * @return the id
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "location-eref-increment")
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
     * @return the idtype
     */
    @Column(name = "idtype")
    public String getIdtype()
    {
        return idtype;
    }

    /**
     * @param idtype the idtype to set
     */
    public void setIdtype(String idtype)
    {
        this.idtype = idtype;
    }

    /**
     * @return the idvalue
     */
    @Column(name = "idvalue")
    public String getIdvalue()
    {
        return idvalue;
    }

    /**
     * @param idvalue the idvalue to set
     */
    public void setIdvalue(String idvalue)
    {
        this.idvalue = idvalue;
    }

    /**
     * @return the location
     */
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "locationid", nullable = false)
    public Location getLocation()
    {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
}
