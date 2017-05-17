package org.ncibi.db.mimi2;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "mimi.GeneGeneInteraction")
@Table(name = "GeneGeneInteraction", schema = "denorm")
public class GeneGeneInteraction {
	
	private int ggIntID;
	private int geneid1;
	private String symbol1;
	private int taxid1;
	private int geneid2;
	private String symbol2;
	private int taxid2;
	private String molType1;
	private String molType2;
	private Set<GeneGeneInteractionAttribute> attributes;
	
	@Id
	@Column(name = "ggIntID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getGgIntID() {
		return ggIntID;
	}
	public void setGgIntID(int ggIntID) {
		this.ggIntID = ggIntID;
	}
	
	@Column(name = "geneid1")
	public int getGeneid1() {
		return geneid1;
	}
	public void setGeneid1(int geneid1) {
		this.geneid1 = geneid1;
	}
	
	@Column(name = "symbol1")
	public String getSymbol1() {
		return symbol1;
	}
	public void setSymbol1(String symbol1) {
		this.symbol1 = symbol1;
	}
	
	@Column(name = "taxid1")
	public int getTaxid1() {
		return taxid1;
	}
	public void setTaxid1(int taxid1) {
		this.taxid1 = taxid1;
	}
	
	@Column(name = "geneid2")
	public int getGeneid2() {
		return geneid2;
	}
	public void setGeneid2(int geneid2) {
		this.geneid2 = geneid2;
	}
	
	@Column(name = "symbol2")
	public String getSymbol2() {
		return symbol2;
	}
	public void setSymbol2(String symbol2) {
		this.symbol2 = symbol2;
	}
	
	@Column(name = "taxid2")
	public int getTaxid2() {
		return taxid2;
	}
	public void setTaxid2(int taxid2) {
		this.taxid2 = taxid2;
	}
	
	@Column(name = "molType1")
	public String getMolType1() {
		return molType1;
	}
	public void setMolType1(String molType1) {
		this.molType1 = molType1;
	}
	
	@Column(name = "molType2")
	public String getMolType2() {
		return molType2;
	}
	public void setMolType2(String molType2) {
		this.molType2 = molType2;
	}
	
	@OneToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
            fetch = FetchType.LAZY, mappedBy = "ggIntID")
	public Set<GeneGeneInteractionAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(Set<GeneGeneInteractionAttribute> attributes) {
		this.attributes = attributes;
	}
}
