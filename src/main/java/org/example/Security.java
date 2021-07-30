package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Security {
    @JsonProperty("name")
    public String name;
    @JsonProperty("currency")
    public List<String> currency;
    @JsonProperty("code")
    public String code;
    @JsonProperty("date")
    public String date;
}
