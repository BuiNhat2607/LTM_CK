/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import model.artist.Artist;
//import model.Children;
//import model.Dom;
import model.GeniusApiResponse;
import model.artist.GeniusArtistApiResponse;
import model.Hit;
import model.Meta;

//import model.P;
import model.Response;
import model.Result;

/**
 *
 * @author MINHNHAT
 */
public class frmArtist extends javax.swing.JFrame {

    private Gson gson;
    private static Artist artist;

    /**
     * Creates new form fmrTest
     * @param artist
     */
    public frmArtist(Artist artist) {
        initComponents();
        gson = new Gson();
        frmArtist.artist = artist;
        loadArtistInfo();
    }
    private void loadArtistInfo() {
        
        try {
            URL imageUrl = new URL(artist.getImageUrl());
            ImageIcon imageIcon = new ImageIcon(imageUrl);

            Image scaledImage = imageIcon.getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH);

            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            lbImage.setIcon(scaledImageIcon);
            String alternateName=createIterableArtistAlternateName(artist.getAlternate_names(),", ");
            lbAlternateName.setText(alternateName);
            lbFullName.setText(artist.getName());
            txtArtistInfo.setLineWrap(true);
            txtArtistInfo.setText(artist.getDescription().getPlain());
        } catch (MalformedURLException ex) {
            System.out.println("Load image fail"+ex);
        }
    }
    //Nối chuỗi
    public String createIterableArtistAlternateName(String[] array, String delimiter) {
        StringBuilder result = new StringBuilder();

        for (String element : array) {
            result.append(element);
            result.append(delimiter);
        }

        // Remove the trailing delimiter, if any
        if (result.length() > 0) {
            result.setLength(result.length() - delimiter.length());
        }

        return result.toString();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArtistInfo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbFullName = new javax.swing.JLabel();
        lbAlternateName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN NGHỆ SĨ");

        txtArtistInfo.setColumns(20);
        txtArtistInfo.setRows(5);
        jScrollPane1.setViewportView(txtArtistInfo);

        jLabel4.setText("Họ tên");

        jLabel2.setText("Nghệ danh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbAlternateName, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(497, 497, 497)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(452, 452, 452)
                                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lbAlternateName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadImageFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            ImageIcon imageIcon = new ImageIcon(url);

            // Set the ImageIcon to the JLabel
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

//    public void loadArtistInfo() {
//        // Lấy artistId từ frmSong (có thể truy cập thông qua một phương thức hoặc thuộc tính)
////           int artistID = firstResult.getPrimary_artist().getId();
//
//        // Gọi hàm sendRequestToServer để lấy thông tin nghệ sĩ từ API
//        String apiArtistResponse = sendRequestToServer("artist" + "@" + artistId);
//
//        // Xử lý parse data để lấy thông tin của nghệ sĩ
//        JsonParser jsonParser = new JsonParser();
//        JsonObject rootObject = jsonParser.parse(apiArtistResponse).getAsJsonObject();
//
//        // Loại bỏ các trường không cần thiết từ JSON
//        rootObject.getAsJsonObject("response").getAsJsonObject("artist").remove("user");
//        rootObject.getAsJsonObject("response").getAsJsonObject("artist").remove("description_annotation");
//        rootObject.getAsJsonObject("response").getAsJsonObject("artist").remove("current_user_metadata");
//
//        // Chuyển đổi JSON thành đối tượng GeniusArtistApiResponse
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String truncatedJsonArtist = gson.toJson(rootObject);
//        GeniusArtistApiResponse artistApiResponse = gson.fromJson(truncatedJsonArtist, GeniusArtistApiResponse.class);
//        Artist artist = artistApiResponse.getResponse().getArtist();
//
//        // Hiển thị thông tin của nghệ sĩ trong textArea
////        txtArtistsInfo.setText(artist.getDescription().getPlain());
//
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
            java.util.logging.Logger.getLogger(frmArtist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmArtist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmArtist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmArtist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmArtist(artist).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAlternateName;
    private javax.swing.JLabel lbFullName;
    private javax.swing.JLabel lbImage;
    private javax.swing.JTextArea txtArtistInfo;
    // End of variables declaration//GEN-END:variables

    
}
