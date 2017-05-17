package org.ncibi.db.conceptgen;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LRPATH_CONCEPT", catalog = "conceptgen")
 
public class LRpathConcept {

	private Integer conceptId;
	private Integer extId;
	private Integer conceptTypeId;
	private Integer elementSize;
	private String conceptName;
	private String description;
	private String owner;
	private Date createDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONCEPT_ID", unique = true, nullable = false)
	public Integer getConceptId() {
		return conceptId;
	}

	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}

	@Column(name = "EXT_ID")
	public Integer getExtId() {
		return extId;
	}

	public void setExtId(Integer extId) {
		this.extId = extId;
	}

	@Column(name = "CONCEPT_TYPE_ID")
	public Integer getConceptTypeId() {
		return conceptTypeId;
	}

	public void setConceptTypeId(Integer conceptTypeId) {
		this.conceptTypeId = conceptTypeId;
	}

	@Column(name = "ELEMENT_SIZE")
	public Integer getElementSize() {
		return elementSize;
	}

	public void setElementSize(Integer elementSize) {
		this.elementSize = elementSize;
	}

	@Column(name = "CONCEPT_NAME")
	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "OWNER")
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}