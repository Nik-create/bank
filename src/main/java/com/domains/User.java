package com.domains;

import com.domains.enums.Role;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "trader")
    private List<Order> orders;
    @OneToMany(mappedBy = "seller")
    private List<Agreement> selled;
    @OneToMany(mappedBy = "buyer")
    private List<Agreement> buyed;
}
