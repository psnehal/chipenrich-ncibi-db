package org.ncibi.db.conceptgen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LRPATH_ANALYSIS", catalog = "conceptgen")
public class LRpathAnalysis {

	private Integer analysisId;
	private Integer geneId;
	private double sigval;
	private String direction;

	@Id
	@Column(name = "ANALYSIS_ID", unique = true, nullable = false)
	public Integer getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(Integer analysisId) {
		this.analysisId = analysisId;
	}
	
	@Column(name = "GENE_ID")
	public Integer getGeneId() {
		return geneId;
	}

	public void setGeneId(Integer geneId) {
		this.geneId = geneId;
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
