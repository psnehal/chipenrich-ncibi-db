package org.ncibi.db.reginfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "dbo.RegistrationApplicationName")
@Table (name = "RegistrationApplicationName", schema = "dbo")
public class RegistrationApplicationName {
	
	private int id;
	private String applicationName;
	
	@Id
    @Column (name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "applicationName", nullable = false)
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
}
