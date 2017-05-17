package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "metdb.PathwayClass")
@Table (name = "PathwayClass", schema = "metdb")
@GenericGenerator(name = "pathway-class-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class PathwayClass
{
    private Integer id;
    private String className;    
    
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "pathway-class-increment")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "pathwayclass")
    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }
}
