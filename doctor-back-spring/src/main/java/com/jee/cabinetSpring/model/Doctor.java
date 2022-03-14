package com.jee.cabinetSpring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //le champ dans le formulaire ne doit pas etre vide ni espace
    @NotEmpty
    //la taille de champs dans le formulaire
    @Size(min = 3,max = 10,message = "la taille doit etre entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+",message = "le nom doit contenir que des alphabets")
    private String firstname;

    //le champ dans le formulaire ne doit pas etre vide ni espace
    @NotEmpty
    //la taille de champs dans le formulaire
    @Size(min = 3,max = 10,message = "la taille doit etre entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+",message = "le nom doit contenir que des alphabets")
    private String lastname;

    //oblige les standars de l'adresse mail
    @Email(message = "Donner une adresse mail valide")
    private String emailAddress;

    //le champ dans le formulaire ne doit pas etre vide ni espace
    @NotEmpty
    //la taille de champs dans le formulaire
    //@Size(min = 8,max = 13,message = "la taille doit etre entre 3 et 13")
    private String phone;

    //le champ dans le formulaire ne doit pas etre vide ni avec espace
    @NotEmpty
    private String specialite;

//    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Rdv> rdvs;

}
