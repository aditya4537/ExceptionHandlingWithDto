package com.example.intern.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="buddy")
public class Buddy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long buddyId;
	
	private String buddyName;
	
	private String buddyRole;

	public long getBuddyId() {
		return buddyId;
	}

	public void setBuddyId(long buddyId) {
		this.buddyId = buddyId;
	}

	public String getBuddyName() {
		return buddyName;
	}

	public void setBuddyName(String buddyName) {
		this.buddyName = buddyName;
	}

	public String getBuddyRole() {
		return buddyRole;
	}

	public void setBuddyRole(String buddyRole) {
		this.buddyRole = buddyRole;
	}

	@Override
	public String toString() {
		return "Buddy [buddyId=" + buddyId + ", buddyName=" + buddyName + ", buddyRole=" + buddyRole + "]";
	}
	
	
}
