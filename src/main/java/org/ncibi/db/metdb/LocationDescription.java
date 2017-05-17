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

@Entity(name = "metdb.LocationDescription")
@Table (name = "LocationDescription", schema = "metdb")
@GenericGenerator(name = "location-desc-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class LocationDescription
{
    private Integer id;
    private String description;  
    private Location location;
    
    public LocationDescription()
    {
        
    }
    
    public LocationDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the id
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "location-desc-increment")
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
     * @return the description
     */
    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
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
