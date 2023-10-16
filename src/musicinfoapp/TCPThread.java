/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicinfoapp;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author MINHNHAT
 */
public class TCPThread extends Thread {

    private final Socket clientSocket;

    private final Gson gson;
    private final String GENIUS_API_BASE_URL = "https://api.genius.com/search";
    private final String GENIUS_LYRICS_URL = "https://api.genius.com/songs/";
    private final String GENIUS_API_ARTIST = "https://api.genius.com/artists/";
    private final String ACCESS_TOKEN = "gSYQOufTfO1oLNbcxEqmENGxjo87g9cSpproy3hDToubqpJJvNMOSHeohu_I6RIb";

    public TCPThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        gson = new Gson();
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);) {
            //Nhận dữ liệu từ client
            String[] fromClient = in.readLine().split("@");
            if (fromClient.length == 2) {
                if (fromClient[0].equals("search")) {
                    out.println(searchGeniusAPI(fromClient[1]));
                } else if (fromClient[0].equals("artist")) {
                    String kq = getArtistAPI(fromClient[1]);
                    System.out.println("Ket qua :::::" + kq);
                    out.println(gson.toJson(kq));
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
            URL url = new URL(GENIUS_API_ARTIST + artistId);

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
