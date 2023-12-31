/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicinfoapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

import java.net.Socket;
import java.net.URL;

/**
 *
 * @author MINHNHAT
 */
public class TCPThread extends Thread {

    private final Socket clientSocket;

    private final Gson gson;
    private final String GENIUS_API_BASE_URL = "https://api.genius.com/search";
    private final String GENIUS_LYRICS_URL = "https://genius-song-lyrics1.p.rapidapi.com/song/lyrics/?id=";
    private final String GENIUS_SONG_URL = "https://api.genius.com/songs/";
    private final String GENIUS_API_ARTIST = "https://api.genius.com/artists/";
    private final String ACCESS_TOKEN = "gSYQOufTfO1oLNbcxEqmENGxjo87g9cSpproy3hDToubqpJJvNMOSHeohu_I6RIb";

    public TCPThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);) {
            //Nhận dữ liệu từ client
            String[] fromClient = in.readLine().split("@");
            if (fromClient.length == 2) {
                if (fromClient[0].equals("search")) {
                    String result = searchGeniusAPI(fromClient[1]);
                    String response = TruncateJson.truncateJsonSearch(result);
                    out.println(response);
                } else if (fromClient[0].equals("artist")) {
                    String kq = getArtistAPI(fromClient[1]);
                    String response=TruncateJson.truncateArtistJson(kq);
//                    System.out.println("Ket qua ::::::::::::::::::::::::::::::::::::::::::::::::" + kq);
                    out.println(response);
//                    System.out.println("Ket qua ::::::::::::::::::::::::::::::::::::::::::::::::" + kq);
                } else if ((fromClient[0].equals("lyrics"))) {
                    String kq = fetchLyrics(fromClient[1]);

                    out.println(kq);
                } else if ((fromClient[0].equals("song"))) {
                    String kq = getSongAPI(fromClient[1]);
                    String response = TruncateJson.truncateMediaJson(kq);
                    System.out.println("Ket qua bai hat::::::" + response);
                    out.println(response);
                }
            }
            out.println("Sai request");
            //Gửi kết quả về client
//            out.println(searchGeniusAPI(fromClient));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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

    public String getArtistAPI(String artistId) {
        try {
            // Construct the API URL for artists
            String encodedQuery = artistId.replace(" ", "%20");
            String apiUrl = GENIUS_API_ARTIST + encodedQuery + "?text_format=plain";

            URL url = new URL(apiUrl);

            // Open a connection to the API URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);

            // Get the response from the API
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();

            } else {
                System.err.println("Failed to fetch data. Response code: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            return null;
        }
    }

    public String fetchLyrics(String id) {
        String result = getLyricsAPI(id);

        String truncatedJson = TruncateJson.truncateLyricsJson(result);

//        System.out.println("Ket qua lyrics"+truncatedJson);
        if (!truncatedJson.isEmpty()) {
            return truncatedJson;
        } else {
            return "Fail";
        }
    }

    public String getLyricsAPI(String id) {
        // API URL
        String apiUrl = GENIUS_LYRICS_URL + id;

        // API headers
        String host = "genius-song-lyrics1.p.rapidapi.com";
        String apiKey = "abf487375cmshebd4e9b2f4fd37ap159ac7jsn0277f3d264fe";

        try {
            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set the required headers
            connection.setRequestProperty("X-RapidAPI-Host", host);
            connection.setRequestProperty("X-RapidAPI-Key", apiKey);

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                // Request was successful, read and return the lyrics
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                return response.toString();
            } else {
                // Handle the error, e.g., by logging or returning an error message
                return "Error:" + responseCode;
            }
        } catch (IOException e) {
            // Handle exceptions, e.g., network errors
            return "Error:" + e.toString();
        }
    }

    public String getSongAPI(String songId) {
        try {
            // Construct the API URL for artists
            String encodedQuery = songId.replace(" ", "%20");
            String apiUrl = GENIUS_SONG_URL + encodedQuery + "?text_format=plain";

            URL url = new URL(apiUrl);

            // Open a connection to the API URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);

            // Get the response from the API
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();

            } else {
                System.err.println("Failed to fetch data. Response code: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            return null;
        }
    }
}
