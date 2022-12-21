package com.exampl.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
//
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    private String email;

    private String mobileNumber;

    private String password;


    @OneToMany( cascade = ALL )
    private List<Products> products;

    @ManyToOne( fetch = EAGER )
    private Role role;

}
