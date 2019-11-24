package com.noisemakers.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BANDMEMBERS", schema = "public")
public class BandMembers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Band bandId;
	private User userId;
	
	public Band getBandId() {
		return bandId;
	}
	public void setBandId(Band bandId) {
		this.bandId = bandId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}




}
