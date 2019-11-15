package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERINFO", schema = "public")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	@JoinColumn(unique = true)
	private User user;
	@NotNull(message = "A descrição não pode ser vazia!")
	@Size(min = 32, message = "A descrição deve ter no minimo 32 caracteres!")
	private String description;
	@NotNull(message = "A habilidade principal não pode ser vazia!")
	private String mainSkill;

	private String picture;
	@NotNull(message = "O país não pode ser vazio!")
	private String country;
	@NotNull(message = "A cidade não pode ser vazia!")
	private String city;
	@NotNull(message = "O estado não pode ser vazio!")
	private String state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMainSkill() {
		return mainSkill;
	}

	public void setMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}

}
