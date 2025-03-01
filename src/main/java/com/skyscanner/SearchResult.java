package com.skyscanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty("city") // Maps "city" JSON key to Java variable
    private String city;

    @JsonProperty("kind") // Maps "kind" JSON key to Java variable
    private String kind;

    @JsonProperty("title") // Maps "title" JSON key to Java variable
    private String title;

    // Default constructor (needed for Jackson)
    public SearchResult() {}

    // Constructor for manual object creation
    public SearchResult(String city, String kind, String title) {
        this.city = city;
        this.kind = kind;
        this.title = title;
    }

    // Getter methods for accessing data
    public String getCity() {
        return city;
    }

    public String getKind() {
        return kind;
    }

    public String getTitle() {
        return title;
    }
}
