package org.ncibi.db.conceptgen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LRPATH_ANALYSIS_DATA", catalog = "conceptgen")
public class LRpathAnalysisData {

	private Integer conceptId;
	private Integer geneId;
	private Integer nlp;
	private Integer nlpAdj;
	private Integer elementId;
	private double sigval;
	private String direction;

	@Id
	@Column(name = "CONCEPT_ID", unique = true, nullable = false)
	public Integer getConceptId() {
		return conceptId;
	}

	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}

	@Column(name = "GENE_ID")
	public Integer getGeneId() {
		return geneId;
	}

	public void setGeneId(Integer geneId) {
		this.geneId = geneId;
	}

	@Column(name = "NLP")
	public Integer getNlp() {
		return nlp;
	}

	public void setNlp(Integer nlp) {
		this.nlp = nlp;
	}

	@Column(name = "NLP_ADJ")
	public Integer getNlpAdj() {
		return nlpAdj;
	}

	public void setNlpAdj(Integer nlpAdj) {
		this.nlpAdj = nlpAdj;
	}

	@Column(name = "ELEMENT_ID")
	public Integer getElementId() {
		return elementId;
	}

	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}

	@Column(name = "SIGVAL")
	public double getSigval() {
		return sigval;
	}

	public void setSigval(double sigval) {
		this.sigval = sigval;
	}

	@Column(name = "DIRECTION")
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
