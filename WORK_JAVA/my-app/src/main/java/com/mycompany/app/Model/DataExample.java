package com.mycompany.app.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DataExample {
    private final String name ="abc";
    private double score;

    private String[] tags;
}
