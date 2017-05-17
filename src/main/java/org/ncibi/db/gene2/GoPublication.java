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

@Entity(name = "gene.GoPublication")
@Table (name = "GoPub", schema = "gene")
@GenericGenerator(name = "genegopub-increment", strategy = "increment", parameters = { @Parameter(name = "schema", value = "gene") })
public class GoPublication
{
    private Integer id;
    private Integer pubmedId;
    private GoEntry goEntry;
    
    @Id
    @GeneratedValue(generator = "genegopub-increment")
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
    @JoinColumn (name = "goentry_id", nullable = false)
    public GoEntry getGoEntry()
    {
        return goEntry;
    }
    
    public void setGoEntry(GoEntry goEntry)
    {
        this.goEntry = goEntry;
    }
}
