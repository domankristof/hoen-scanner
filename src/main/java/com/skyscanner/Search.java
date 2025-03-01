package com.skyscanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {
    @JsonProperty("city") // Maps "city" key from JSON
    private String city;

    // Default constructor (needed for Jackson)
    public Search() {

    }

    // Constructor to manually create a Search object
    public Search(String city) { this.city = city; }

    // Getter method to access the city value
    public String getCity() { return city; }
}
