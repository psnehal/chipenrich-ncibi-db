package org.ncibi.db.gene2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "gene.Homolog")
@Table (name = "Homolog", schema = "gene")
@GenericGenerator(name = "homolog-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "gene") })
public class Homolog
{
    private Integer id;
    private Integer hid;
    private Integer taxid;
    private Integer geneid;
    private String symbol;
    private Integer proteinGI;
    private String proteinAccession;

    @Id
    @GeneratedValue(generator = "homolog-increment")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "hid")
    public Integer getHid()
    {
        return hid;
    }

    public void setHid(Integer hid)
    {
        this.hid = hid;
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

    @Column(name = "geneid")
    public Integer getGeneid()
    {
        return geneid;
    }

    public void setGeneid(Integer geneid)
    {
        this.geneid = geneid;
    }

    @Column(name = "symbol")
    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    @Column(name = "protein_gi")
    public Integer getProteinGI()
    {
        return proteinGI;
    }

    public void setProteinGI(Integer proteinGI)
    {
        this.proteinGI = proteinGI;
    }

    @Column(name = "protein_accession")
    public String getProteinAccession()
    {
        return proteinAccession;
    }

    public void setProteinAccession(String proteinAccession)
    {
        this.proteinAccession = proteinAccession;
    }
}
