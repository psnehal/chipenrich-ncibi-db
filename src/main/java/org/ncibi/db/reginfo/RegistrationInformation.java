package org.ncibi.db.reginfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "dbo.RegistrationInformation")
@Table (name = "RegistrationInformation", schema = "dbo")
public class RegistrationInformation {
	private int id;
	private int applicationNameId;
	private String firstName;
	private String lastName;
	private String email;
	private String institution;
	
	@Id
    @Column (name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    @Column (name = "applicationNameId", nullable = false)
	public int getApplicationNameId() {
		return applicationNameId;
	}
	public void setApplicationNameId(int applicationNameId) {
		this.applicationNameId = applicationNameId;
	}
	
	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "institution")
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
}
