package org.ncibi.db.conceptgen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LRPATH_STATS", catalog = "conceptgen")
public class LRpathStats {

	private Integer lrpathStatsId;
	private Integer conceptId1;
	private Integer conceptId2;
	private double oddsRatio;
	private double pValue;
	private double fdr;

	@Id
	@Column(name = "LRPATH_STATS_ID", unique = true, nullable = false)
	public Integer getLrpathStatsId() {
		return lrpathStatsId;
	}

	public void setLrpathStatsId(Integer lrpathStatsId) {
		this.lrpathStatsId = lrpathStatsId;
	}

	@Column(name = "CONCEPT_ID1")
	public Integer getConceptId1() {
		return conceptId1;
	}

	public void setConceptId1(Integer conceptId1) {
		this.conceptId1 = conceptId1;
	}

	@Column(name = "CONCEPT_ID2")
	public Integer getConceptId2() {
		return conceptId2;
	}

	public void setConceptId2(Integer conceptId2) {
		this.conceptId2 = conceptId2;
	}

	@Column(name = "ODDS_RATIO")
	public double getOddsRatio() {
		return oddsRatio;
	}

	public void setOddsRatio(double oddsRatio) {
		this.oddsRatio = oddsRatio;
	}

	@Column(name = "P_VALUE")
	public double getpValue() {
		return pValue;
	}

	public void setpValue(double pValue) {
		this.pValue = pValue;
	}

	@Column(name = "FDR")
	public double getFdr() {
		return fdr;
	}

	public void setFdr(double fdr) {
		this.fdr = fdr;
	}

}
