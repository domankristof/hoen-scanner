package com.skyscanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import java.util.List;
import java.util.ArrayList;


public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {

    }

    @Override
    public void run(final HoenScannerConfiguration configuration, final Environment environment) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Load rental_cars.json
        InputStream carInputStream = getClass().getClassLoader().getResourceAsStream("rental_cars.json");
        if (carInputStream == null) {
            throw new IOException("File rental_cars.json not found!");
        }
        List<SearchResult> carResults = Arrays.asList(mapper.readValue(carInputStream, SearchResult[].class));

        // Load hotels.json
        InputStream hotelInputStream = getClass().getClassLoader().getResourceAsStream("hotels.json");
        if (hotelInputStream == null) {
            throw new IOException("File hotels.json not found!");
        }
        List<SearchResult> hotelResults = Arrays.asList(mapper.readValue(hotelInputStream, SearchResult[].class));

        // Combine search results
        List<SearchResult> searchResults = new ArrayList<>();
        searchResults.addAll(carResults);
        searchResults.addAll(hotelResults);

        // Register SearchResource as an API endpoint
        final SearchResource resource = new SearchResource(searchResults);
        environment.jersey().register(resource);

        System.out.println("HoenScanner Application is running! 🚀");
    }



}
