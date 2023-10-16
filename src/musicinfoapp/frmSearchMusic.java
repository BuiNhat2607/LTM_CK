/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package musicinfoapp;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import model.Artist;
import model.Children;
import model.Dom;
import model.GeniusApiResponse;
import model.GeniusArtistApiResponse;
import model.Hit;
import model.Meta;
import model.P;
import model.PrimaryArtist;
import model.Response;
import model.Result;
import model.Tag;

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
        txtArtist = new javax.swing.JTextField();

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
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(txtArtist))
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
                            .addComponent(txtArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        System.out.println(result);
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
        System.out.println("Ket qua lay nghe si ::" + apiArtistResponse);

        // Parse the API response to get artist information
        GeniusArtistApiResponse artistApiResponse = gson.fromJson(apiArtistResponse, GeniusArtistApiResponse.class);
        Artist artist = artistApiResponse.getResponse().getArtist();

        // Display the artist information in the text area
        if (artist != null && artist.getDescription() != null && artist.getDescription().getDom() != null) {
            Dom dom = artist.getDescription().getDom();
            Tag tag = dom.getTag();

            List<Children> resultChildren = tag.getChildren();
            if (!resultChildren.isEmpty()) {
                StringBuilder artistDescription = new StringBuilder();

                for (Children child : resultChildren) {
                    artistDescription.append(child.getTag()).append(": ");
                    List<P> pList = child.getChildren();
                    for (P p : pList) {
                        artistDescription.append(p.getTag()).append(": ");
                        artistDescription.append(String.join(" ", p.getChildren())).append("\n");
                    }
                }

                txtArtistsInfo.setText(artistDescription.toString());
            }
        }
        txtResult.setText("Tên của bài hát đầu tiên tìm thấy: " + songTitle + "\n" + "Danh sách các nghệ sĩ :" + "\n" + artists);
        loadImageFromUrl(firstResult.getHeader_image_thumbnail_url());


    }//GEN-LAST:event_btnSearchActionPerformed

//    private GeniusApiResponse convertToGeniusRespone(String json){
    //        return gson.fromJson(json, GeniusApiResponse.class);
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
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbImage;
    private javax.swing.JTextField txtArtist;
    private javax.swing.JTextArea txtArtistsInfo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtResult;
    // End of variables declaration//GEN-END:variables
}
