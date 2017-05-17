package org.ncibi.db.idmap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "idmap.ProteinIdTypeMap")
@Table (name = "ProteinIdTypeMap", schema = "idmap")
public class ProteinIdTypeMap
{
    private int id;
    private String idtype; 
    private String idtypemap;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "id", unique = true, nullable = false)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    @Column(name = "idtypemap")
    public String getIdtypemap()
    {
        return idtypemap;
    }

    public void setIdtypemap(String idtypemap)
    {
        this.idtypemap = idtypemap;
    }
}
