package com.campiotto.med.api.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Table(name="Users")
@Entity(name="User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
}
