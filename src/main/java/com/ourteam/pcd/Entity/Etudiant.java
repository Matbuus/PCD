package com.ourteam.pcd.Entity;

import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Etudiant")
public class Etudiant extends Utilisateur {
	
	public Etudiant() {}
	
	@Id
	@Column(name="numinscription", nullable=false,length=8)
	private String numInscription;

	public String getNumInscription() {
		return numInscription;
	}

	public void setNumInscription(String numInscription) {
		this.numInscription = numInscription;
	}
	
}
