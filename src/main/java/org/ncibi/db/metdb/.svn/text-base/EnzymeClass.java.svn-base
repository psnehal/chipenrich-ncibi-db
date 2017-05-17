package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "metdb.EnzymeClass")
@Table (name = "EnzymeClass", schema = "metdb")
@GenericGenerator(name = "enzyme-class-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "metdb") })
public class EnzymeClass
{
    private Integer id;
    private String className;  

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "enzyme-class-increment")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "enzymeclass")
    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }  
}
