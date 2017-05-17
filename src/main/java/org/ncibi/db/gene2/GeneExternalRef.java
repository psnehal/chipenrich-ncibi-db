package org.ncibi.db.gene2;

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

@Entity(name = "gene.GeneExternalRef")
@Table (name = "ExternalRef", schema = "gene")
@GenericGenerator(name = "genexref-increment", strategy = "increment", 
        parameters = { @Parameter(name = "schema", value = "gene") })
public class GeneExternalRef
{
    private Integer id;
    private String idtype;
    private String idvalue;
    private boolean uniqueRef;
    private Gene gene;
    
    @Id
    @GeneratedValue(generator = "genexref-increment")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
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
    
//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinTable (name = "Gene2ExternalRef", schema = "gene",
//        joinColumns = {@JoinColumn (name = "eref_id", nullable = false)},
//        inverseJoinColumns = {@JoinColumn (name = "geneid")})
        
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "geneid", nullable = false)
    public Gene getGene()
    {
        return gene;
    }
    
    public void setGene(Gene gene)
    {
        this.gene = gene;
    }

    @Column(name = "uniqueref")
    public boolean isUniqueRef()
    {
        return uniqueRef;
    }

    public void setUniqueRef(boolean uniqueRef)
    {
        this.uniqueRef = uniqueRef;
    }
}
