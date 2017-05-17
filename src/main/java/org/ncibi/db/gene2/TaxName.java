package org.ncibi.db.gene2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "gene.TaxName")
@Table (name = "TaxName", schema = "gene")
@GenericGenerator(name = "taxname-increment", strategy = "increment", parameters = { @Parameter(name = "schema", value = "gene") })
public class TaxName
{
    private Integer id;
    private Integer taxid;
    private String taxName;
    private String uniqueName; 
    private String taxClass;

    @Id
    @GeneratedValue(generator = "taxname-increment")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "taxid")
    public Integer getTaxid()
    {
        return taxid;
    }

    public void setTaxid(Integer taxid)
    {
        this.taxid = taxid;
    }

    @Column(name = "taxname")
    public String getTaxName()
    {
        return taxName;
    }

    public void setTaxName(String taxName)
    {
        this.taxName = taxName;
    }

    @Column(name = "uniqueName")
    public String getUniqueName()
    {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName)
    {
        this.uniqueName = uniqueName;
    }

    @Column(name = "taxclass")
    public String getTaxClass()
    {
        return taxClass;
    }

    public void setTaxClass(String taxClass)
    {
        this.taxClass = taxClass;
    }
}
