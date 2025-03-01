package com.skyscanner;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/search") // API Endpoint
@Consumes(MediaType.APPLICATION_JSON) // Accepts JSON input
@Produces(MediaType.APPLICATION_JSON) // Returns JSON output
public class SearchResource {

    private final List<SearchResult> searchResults;

    // Constructor to initialize the search results
    public SearchResource(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    @POST // Handles POST requests to /search
    public List<SearchResult> search(@NotNull @Valid Search search) {
        List<SearchResult> response = new ArrayList<>();

        for (SearchResult result : searchResults) {
            if (result.getCity().equalsIgnoreCase(search.getCity())) { // Case-insensitive match
                response.add(result);
            }
        }

        return response;
    }
}
