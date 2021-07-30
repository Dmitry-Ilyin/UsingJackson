package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Companies {
    @JsonProperty("companies")
    public List<Company> companies;

}
