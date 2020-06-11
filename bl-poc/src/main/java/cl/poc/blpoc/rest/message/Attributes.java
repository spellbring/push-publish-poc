package cl.poc.blpoc.rest.message;

import lombok.ToString;

@ToString
public class Attributes {
    private String key;


    // Getter Methods

    public String getKey() {
        return key;
    }

    // Setter Methods

    public void setKey(String key) {
        this.key = key;
    }
}