package com.jee.cabinetSpring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Search {
    private String specialite;
    private List<Doctor> doctors;
    private  String pseudo;
}
