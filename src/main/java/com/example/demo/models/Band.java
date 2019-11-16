package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "BAND", schema = "public")
public class Band implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long userId;
	@Column(unique = true)
	@NotNull(message = "O nome da banda não pode ser vazio!")
	private String name;
	@NotNull(message = "O gênero da banda não pode ser vazio!")
	private String genre;
	@NotNull(message = "A cidade não pode ser vazia!")
	private String city;
	@NotNull(message = "A quantidade de membros não pode ser vazia!")
	private int qttyMembers;
	@NotNull(message = "A descrição não pode ser vazia!")
	@Size(min = 32, message = "A descrição deve ter no mínimo 32 caracteres!")
	private String description;
	@Column(name = "IMAGE", length = 9999999)
	private String image;
	@Column(name = "BIGIMAGE", length = 9999999)
	private String bigImage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getQttyMembers() {
		return qttyMembers;
	}

	public void setQttyMembers(int qttyMembers) {
		this.qttyMembers = qttyMembers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBigImage() {
		return bigImage;
	}

	public void setBigImage(String bigImage) {
		this.bigImage = bigImage;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
