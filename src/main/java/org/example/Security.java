package org.example;

import java.util.List;

public class Security {
    public String name;
    public List<String> currency;
    public String code;
    public String date;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCurrency() {
        return currency;
    }

    public void setCurrency(List<String> currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Security{" +
                "name='" + name + '\'' +
                ", currency=" + currency +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
