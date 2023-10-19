/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import model.Hit;

/**
 *
 * @author MINHNHAT
 */
public class HitsCell extends JButton{
    private Hit hit;

    public HitsCell(Hit hit) {
        try {
            this.hit = hit;
            setLayout(new BorderLayout());
            URL url = new URL(hit.getResult().getSong_art_image_url());
            // Create an ImageIcon from the image URL
            ImageIcon imageIcon = new ImageIcon(url);

            Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            // Create a JLabel to display the image
            JLabel imageLabel = new JLabel(scaledImageIcon);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(imageLabel, BorderLayout.NORTH);
            
            JLabel nameLabel = new JLabel(hit.getResult().getFull_title());
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(nameLabel, BorderLayout.CENTER);
            
//            int space = 50; // Adjust the space between HitsCell components as needed
//            setBorder(BorderFactory.createEmptyBorder(space, space, space, space));
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Clicked user ID: " + hit.getResult().getId());
                    frmSong frm=new frmSong(hit);
                    frm.setVisible(true);
                }
            });
        } catch (MalformedURLException ex) {
            System.out.println("Loi dinh dang khong the load hinh");
        }
    }
}
