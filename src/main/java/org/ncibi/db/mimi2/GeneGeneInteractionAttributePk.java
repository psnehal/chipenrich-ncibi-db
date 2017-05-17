package org.ncibi.db.mimi2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GeneGeneInteractionAttributePk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ggIntID;
	private String attrType;
	private String attrValue;
	
	@Column(name = "ggIntID")
	public int getGgIntID() {
		return ggIntID;
	}
	public void setGgIntID(int ggIntID) {
		this.ggIntID = ggIntID;
	}
	
	@Column(name = "attrType")
	public String getAttrType() {
		return attrType;
	}
	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}
	
	@Column(name = "attrValue")
	public String getAttrValue() {
		return attrValue;
	}
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attrType == null) ? 0 : attrType.hashCode());
		result = prime * result
				+ ((attrValue == null) ? 0 : attrValue.hashCode());
		result = prime * result + ggIntID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneGeneInteractionAttributePk other = (GeneGeneInteractionAttributePk) obj;
		if (attrType == null) {
			if (other.attrType != null)
				return false;
		} else if (!attrType.equals(other.attrType))
			return false;
		if (attrValue == null) {
			if (other.attrValue != null)
				return false;
		} else if (!attrValue.equals(other.attrValue))
			return false;
		if (ggIntID != other.ggIntID)
			return false;
		return true;
	}

}
