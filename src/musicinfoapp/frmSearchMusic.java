/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package musicinfoapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import model.Artist;
//import model.Children;
//import model.Dom;
import model.GeniusApiResponse;
import model.GeniusArtistApiResponse;
import model.Hit;
import model.Meta;

//import model.P;

import model.Response;
import model.Result;
import songs.SongLyricsResponse;

import org.jsoup.Connection;
//import model.Tag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author MINHNHAT
 */
public class frmSearchMusic extends javax.swing.JFrame {

    private Gson gson;

    /**
     * Creates new form fmrTest
     */
    public frmSearchMusic() {
        initComponents();
        gson = new Gson();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArtistsInfo = new javax.swing.JTextArea();
        txtName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        lbImage = new javax.swing.JLabel();
        txtSongID = new javax.swing.JTextField();
        btnLyrics = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArtistsInfo.setColumns(20);
        txtArtistsInfo.setLineWrap(true);
        txtArtistsInfo.setRows(5);
        jScrollPane1.setViewportView(txtArtistsInfo);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên bài hát");

        txtResult.setColumns(20);
        txtResult.setLineWrap(true);
        txtResult.setRows(5);
        jScrollPane2.setViewportView(txtResult);

        btnLyrics.setText("Lyrics");
        btnLyrics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLyricsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnLyrics, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(txtSongID))
                        .addGap(28, 28, 28)
                        .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSongID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLyrics, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadImageFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            ImageIcon imageIcon = new ImageIcon(url);

            // Set the ImageIcon to the JLabel
            lbImage.setIcon(imageIcon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private String sendRequestToServer(String request) {
        try {
            Socket socket = new Socket("localhost", 12346);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(request);
            String respone = in.readLine();
            socket.close();
            return respone;
        } catch (IOException ex) {
            return "SocketError" + ex.toString();
        }
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String result = sendRequestToServer("search" + "@" + txtName.getText());
        JsonParser jsonParser = new JsonParser();
        JsonObject rootJson = jsonParser.parse(result).getAsJsonObject();
        Gson gsonSong = new GsonBuilder().setPrettyPrinting().create();
        String truncatedJson = gsonSong.toJson(rootJson);
        System.out.println("KEt qua bai hat :"+truncatedJson);
        GeniusApiResponse geniusApiResponse = gson.fromJson(result, GeniusApiResponse.class);

        // Access the parsed data
        Meta meta = geniusApiResponse.getMeta();
        Response response = geniusApiResponse.getResponse();
        List<Hit> hits = response.getHits();

        StringBuilder artists = new StringBuilder();
        for (Hit h : hits) {
            artists.append(h.getResult().getArtist_names()).append("\n");
        }
        Result firstResult = hits.get(0).getResult();
        String songTitle = firstResult.getTitle();
        int artistID = firstResult.getPrimary_artist().getId();

        String apiArtistResponse = sendRequestToServer("artist" + "@" + artistID);
        
//        String unescappedJson=apiArtistResponse.replaceAll("\\\\", "");
//        System.out.println("Ket qua lay nghe si ::********************" + unescappedJson);
        JsonParser jsonParser2 = new JsonParser();
        JsonObject rootObject = jsonParser2.parse(apiArtistResponse).getAsJsonObject();

        // Remove the "user" field from the JSON
        rootObject.getAsJsonObject("response").getAsJsonObject("artist").remove("user");
        rootObject.getAsJsonObject("response").getAsJsonObject("artist").remove("description_annotation");
        rootObject.getAsJsonObject("response").getAsJsonObject("artist").remove("current_user_metadata");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String truncatedJsonArtist = gson.toJson(rootObject);
//        if (jsonObject.getAsJsonObject("response").getAsJsonObject("artist").has("current_user_metadata")) {
//            
//        }
        System.out.println("Ket qua ::********************" + truncatedJsonArtist.toString());
        // Parse the API response to get artist information
        GeniusArtistApiResponse artistApiResponse = gson.fromJson(truncatedJsonArtist.toString(), GeniusArtistApiResponse.class);
//        System.out.println("Ket qua lay nghe si ::********************" + gson.toJson(artistApiResponse));
//        System.out.println();
        Artist artist = artistApiResponse.getResponse().getArtist();
        txtArtistsInfo.setText(artist.getDescription().getPlain());
        txtResult.setText("Tên của bài hát đầu tiên tìm thấy: " + songTitle + "\n" + "Danh sách các nghệ sĩ :" + "\n" + artists);
        loadImageFromUrl(firstResult.getHeader_image_thumbnail_url());
        


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLyricsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLyricsActionPerformed
        String result=fetchLyrics(txtSongID.getText());
//        System.out.println("Ket qua lyrics"+result);
//        JsonParser jsonParser = new JsonParser();
        JsonObject rootJson = JsonParser.parseString(result).getAsJsonObject();
//        JsonObject rootJson = jsonParser.parse(result).getAsJsonObject();
        
        rootJson.getAsJsonObject("lyrics").remove("api_path");
        rootJson.getAsJsonObject("lyrics").remove("_type");
        rootJson.getAsJsonObject("lyrics").remove("path");
        rootJson.getAsJsonObject("lyrics").remove("song_id");
        rootJson.getAsJsonObject("lyrics").remove("tracking_data");
        
        Gson gsonSong = new GsonBuilder().setPrettyPrinting().create();
        String truncatedJson = gsonSong.toJson(rootJson);
        
        SongLyricsResponse responeLyrics=gson.fromJson(truncatedJson, SongLyricsResponse.class);
//        System.out.println("Ket qua lyrics"+truncatedJson);
        if (responeLyrics != null) {
            String lyrics = responeLyrics.getLyrics().getLyricsContent().getBody().getHtml();
            String cleanedLyrics = lyrics.replaceAll("<[^>]*>", "");
            txtArtistsInfo.setText(cleanedLyrics);
            System.out.println("Lyrics: " + cleanedLyrics);
        } else {
            System.out.println("Failed to parse lyrics.");
        }
    }//GEN-LAST:event_btnLyricsActionPerformed

    public String fetchLyrics(String id) {
        // API URL
        String apiUrl = "https://genius-song-lyrics1.p.rapidapi.com/song/lyrics/?id=" + id;

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
                System.err.println("Failed to fetch lyrics. Status Code: " + responseCode);
            }
        } catch (IOException e) {
            // Handle exceptions, e.g., network errors
            e.printStackTrace();
        }

        return null; // Return null in case of an error
    }
    
    
//    public void lyricsScraper(String url){
//
//        try {
//            Connection.Response response = Jsoup.connect(url)
//            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
//            .method(Connection.Method.GET)
//            .execute();
//
//            Document document = Jsoup.connect(url)
//                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
//                .cookies(response.cookies())
//                .get();
//            Element lyricsElement = document.select("div.lyrics").first();
//            
//            if (lyricsElement != null) {
//                String lyrics = lyricsElement.text();
//                System.out.println("Lyrics:\n" + lyrics);
//            } else {
//                System.out.println("Lyrics not found on the page.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSearchMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSearchMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSearchMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSearchMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSearchMusic().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLyrics;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbImage;
    private javax.swing.JTextArea txtArtistsInfo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtResult;
    private javax.swing.JTextField txtSongID;
    // End of variables declaration//GEN-END:variables
}
