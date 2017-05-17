package org.ncibi.db.mimi2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "mimi.GeneGeneInteractionAttribute")
@Table(name = "GeneGeneInteractionAttribute", schema = "denorm")
@IdClass(org.ncibi.db.mimi2.GeneGeneInteractionAttributePk.class)
public class GeneGeneInteractionAttribute {
	
	private int ggIntID;
	private String attrType;
	private String attrValue;
	
	@Id
	public int getGgIntID() {
		return ggIntID;
	}
	public void setGgIntID(int ggIntID) {
		this.ggIntID = ggIntID;
	}
	
	@Id
	public String getAttrType() {
		return attrType;
	}
	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}
	
	@Id
	public String getAttrValue() {
		return attrValue;
	}
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
}
