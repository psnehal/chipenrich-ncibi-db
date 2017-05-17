package org.ncibi.db.gene2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "gene.GoEntry")
@Table (name = "GoEntry", schema = "gene")
@GenericGenerator(name = "genego-increment", strategy = "increment", parameters = { @Parameter(name = "schema", value = "gene") })
public class GoEntry
{
    private Integer id;
    private String goId;
    private String evidence;
    private String qualifier;
    private String goterm;
    private String category;
    private Gene gene;
    private Set<GoPublication> pubs = new HashSet<GoPublication>();

    @Id
    @GeneratedValue(generator = "genego-increment")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "goid")
    public String getGoId()
    {
        return goId;
    }

    public void setGoId(String goId)
    {
        this.goId = goId;
    }

    @Column(name = "evidence")
    public String getEvidence()
    {
        return evidence;
    }

    public void setEvidence(String evidence)
    {
        this.evidence = evidence;
    }

    @Column(name = "qualifier")
    public String getQualifier()
    {
        return qualifier;
    }

    public void setQualifier(String qualifier)
    {
        this.qualifier = qualifier;
    }

    @Column(name = "goterm")
    public String getGoterm()
    {
        return goterm;
    }

    public void setGoterm(String goTerm)
    {
        this.goterm = goTerm;
    }

    @Column(name = "category")
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinTable (name = "Gene2Go", schema = "gene",
//        joinColumns = {@JoinColumn (name = "go_id", nullable = false)},
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
    
    public void addPublication(GoPublication pub)
    {
        pub.setGoEntry(this);
        pubs.add(pub);
    }
    
    @OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "goEntry")
    public Set<GoPublication> getPubs()
    {
        return pubs;
    }
    
    public void setPubs(Set<GoPublication> pubs)
    {
        this.pubs = pubs;
    }

    @Override
    public String toString()
    {
        return "GoEntry [id=" + id + ", goId=" + goId + ", evidence=" + evidence + ", qualifier=" + qualifier
                + ", goTerm=" + goterm + ", category=" + category + ", gene=" + gene + ", pubs=" + pubs + "]";
    }
    
    
}
