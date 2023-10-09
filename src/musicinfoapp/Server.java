/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicinfoapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author MINHNHAT
 */
public class Server {

    private final String GENIUS_API_BASE_URL = "https://api.genius.com/search";
    private final String GENIUS_LYRICS_URL = "https://api.genius.com/songs/";
    private final String ACCESS_TOKEN = "NK0nsKdS47sznZB8VYq7pIvAdf0eEWlY--8M0dAMiao3sjIwVhBxkkBh9ngXQf6Q";

    public String searchGeniusAPI(String query) throws Exception {
        String encodedQuery = query.replace(" ", "%20");
        String apiUrl = GENIUS_API_BASE_URL + "?q=" + encodedQuery;

        // Create URL object
        URL url = new URL(apiUrl);

        // Create HTTP connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Set the Authorization header with the access token
        connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);

        // Get the response code
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Reading response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            throw new Exception("Failed to retrieve data from Genius API. Response code: " + responseCode);
        }
    }

    public String findLyrics(String songID) throws Exception {
        String apiUrl = GENIUS_LYRICS_URL + songID;

        // Create URL object
        URL url = new URL(apiUrl);

        // Create HTTP connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Set the Authorization header with the access token
        connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);

        // Get the response code
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Reading response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            throw new Exception("Failed to retrieve data from Genius API. Response code: " + responseCode);
        }
    }

}
