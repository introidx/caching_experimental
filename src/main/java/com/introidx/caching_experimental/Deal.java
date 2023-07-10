package com.introidx.caching_experimental;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Document
@AllArgsConstructor
public class Deal {

    @Id
    Long id;
    String name;
    String dealType;
}
