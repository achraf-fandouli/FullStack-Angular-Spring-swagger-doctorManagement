package com.jee.cabinetSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Size(min = 2, max = 25, message = "la taille doit etre entre 2 et 25")
	@Pattern(regexp = "[a-zA-Z]+", message = "le nom doit contenir que des alphabets")
	@JsonProperty(value = "nom")
	private String firstname;

	@NotEmpty
	@Size(min = 2, max = 25, message = "la taille doit etre entre 2 et 25")
	@Pattern(regexp = "[a-zA-Z]+", message = "le nom doit contenir que des alphabets")
	private String lastname;

	@Email(message = "Donner une adresse mail valide")
	private String emailAddress;

	@NotEmpty
	private String phone;

	@NotEmpty
	private String specialite;
}
