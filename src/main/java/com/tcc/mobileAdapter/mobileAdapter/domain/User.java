package com.tcc.mobileAdapter.mobileAdapter.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    private String cpf;

    private String email;

    private String password;

    private String userName;

    private LocalDate CreatedDate;

    private String contact;

}
