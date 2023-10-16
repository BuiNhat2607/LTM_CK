/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicinfoapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author MINHNHAT
 */
public class GeniusServerUtils {

    private final String GENIUS_API_BASE_URL = "https://api.genius.com";
    private final String ACCESS_TOKEN = "PkOTUDvUNziyG5XFWEYdSAgtY91KaIVG4b3VYHvHCZW3kMyP6a_pyd19L7-MX-ho";
    
    private String extractLyricsFromHtml(String html) {
        Document doc = Jsoup.parse(html);
        Elements lyricsElements = doc.select("div.lyrics"); // Assume lyrics are in a <div> with class 'lyrics'

        StringBuilder lyrics = new StringBuilder();

        for (Element element : lyricsElements) {
            lyrics.append(element.text()).append("\n");
        }

        return lyrics.toString();
    }

    String getHtmlContent(String url) throws IOException {
        URL website = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) website.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
