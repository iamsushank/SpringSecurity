package com.exampl.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    private String role;


}
