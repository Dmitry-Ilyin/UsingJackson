package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Company {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("address")
    public String address;
    @JsonProperty("phoneNumber")
    public String phoneNumber;
    @JsonProperty("INN")
    public String INN;
    @JsonProperty("founded")
    public String founded;
    @JsonProperty("securities")
    public List<Security> securities;
}
