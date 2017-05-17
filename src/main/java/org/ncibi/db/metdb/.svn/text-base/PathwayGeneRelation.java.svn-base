package org.ncibi.db.metdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "metdb.PathwayGeneRelation")
@Table (name = "PathwayGeneRelation", schema = "metdb")
public class PathwayGeneRelation
{
    private int id;
    private String pathway;
    private String pid;
    private Integer geneid1;
    private Integer geneid2;  
    private String relation;

    /**
     * @return the id
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the pathway
     */
    @Column(name = "pathway")
    public String getPathway()
    {
        return pathway;
    }

    /**
     * @param pathway the pathway to set
     */
    public void setPathway(String pathway)
    {
        this.pathway = pathway;
    }

    /**
     * @return the pid
     */
    @Column(name = "pid")
    public String getPid()
    {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid)
    {
        this.pid = pid;
    }

    /**
     * @return the geneid1
     */
    @Column(name = "geneid1")
    public Integer getGeneid1()
    {
        return geneid1;
    }

    /**
     * @param geneid1 the geneid1 to set
     */
    public void setGeneid1(Integer geneid1)
    {
        this.geneid1 = geneid1;
    }

    /**
     * @return the geneid2
     */
    @Column(name = "geneid2")
    public Integer getGeneid2()
    {
        return geneid2;
    }

    /**
     * @param geneid2 the geneid2 to set
     */
    public void setGeneid2(Integer geneid2)
    {
        this.geneid2 = geneid2;
    }

    /**
     * @return the relation
     */
    @Column(name = "relation")
    public String getRelation()
    {
        return relation;
    }

    /**
     * @param relation the relation to set
     */
    public void setRelation(String relation)
    {
        this.relation = relation;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((geneid1 == null) ? 0 : geneid1.hashCode());
        result = prime * result + ((geneid2 == null) ? 0 : geneid2.hashCode());
        result = prime * result + id;
        result = prime * result + ((pathway == null) ? 0 : pathway.hashCode());
        result = prime * result + ((pid == null) ? 0 : pid.hashCode());
        result = prime * result + ((relation == null) ? 0 : relation.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof PathwayGeneRelation))
        {
            return false;
        }
        PathwayGeneRelation other = (PathwayGeneRelation) obj;
        if (geneid1 == null)
        {
            if (other.geneid1 != null)
            {
                return false;
            }
        }
        else if (!geneid1.equals(other.geneid1))
        {
            return false;
        }
        if (geneid2 == null)
        {
            if (other.geneid2 != null)
            {
                return false;
            }
        }
        else if (!geneid2.equals(other.geneid2))
        {
            return false;
        }
        if (id != other.id)
        {
            return false;
        }
        if (pathway == null)
        {
            if (other.pathway != null)
            {
                return false;
            }
        }
        else if (!pathway.equals(other.pathway))
        {
            return false;
        }
        if (pid == null)
        {
            if (other.pid != null)
            {
                return false;
            }
        }
        else if (!pid.equals(other.pid))
        {
            return false;
        }
        if (relation == null)
        {
            if (other.relation != null)
            {
                return false;
            }
        }
        else if (!relation.equals(other.relation))
        {
            return false;
        }
        return true;
    }
}
