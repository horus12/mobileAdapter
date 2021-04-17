package com.tcc.mobileAdapter.mobileAdapter.domain;

import com.mongodb.lang.Nullable;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private String type;

    private String defaultImage;

    @Nullable
    private List<String> images;

    private Boolean enabled;
}
