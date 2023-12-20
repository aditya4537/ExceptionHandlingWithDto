package com.example.intern.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="intern")
public class Intern {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long internId;
	
	private String internName;
	
	private String internRole;
	
	private int internStippend;
	
	@OneToOne
	private Buddy buddyOfIntern;

	public long getInternId() {
		return internId;
	}

	public void setInternId(long internId) {
		this.internId = internId;
	}

	public String getinternName() {
		return internName;
	}

	public void setinternName(String internName) {
		this.internName = internName;
	}

	public String getInternRole() {
		return internRole;
	}

	public void setInternRole(String internRole) {
		this.internRole = internRole;
	}

	public int getInternStippend() {
		return internStippend;
	}

	public void setInternStippend(int internStippend) {
		this.internStippend = internStippend;
	}

	@Override
	public String toString() {
		return "Intern [internId=" + internId + ", internName=" + internName + ", internRole=" + internRole
				+ ", internStippend=" + internStippend + ", buddyOfIntern=" + buddyOfIntern + "]";
	}

	public Buddy getBuddyOfIntern() {
		return buddyOfIntern;
	}

	public void setBuddyOfIntern(Buddy buddyOfIntern) {
		this.buddyOfIntern = buddyOfIntern;
	}
	
	
}
