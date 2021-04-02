package com.tcc.mobileAdapter.mobileAdapter.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "InternalUser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InternalUser {

    @Id
    private String id;

    private String email;

    private String password;
}
