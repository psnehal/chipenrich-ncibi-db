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

@Entity(name = "gene.GenePublication")
@Table (name = "GenePub", schema = "gene")
@GenericGenerator(name = "genepub-increment", strategy = "increment", parameters = { @Parameter(name = "schema", value = "gene") })
public class GenePublication
{
    private Integer id;
    private Integer pubmedId;
    private Gene gene;
    
    @Id
    @GeneratedValue(generator = "genepub-increment")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    @Column(name = "pubmedid")
    public Integer getPubmedId()
    {
        return pubmedId;
    }
    
    public void setPubmedId(Integer pubmedId)
    {
        this.pubmedId = pubmedId;
    }
    
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
}
