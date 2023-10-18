/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author WitherDragon
 */
public class ListBoxExample {
  public static void main(String[] args) {
        // Create the JFrame
      
        JFrame frame = new JFrame("User Grid View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a list of users
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Ronaldo","src\\userImages\\Cristiano_Ronaldo.jpg"));
        users.add(new User(2, "Messi","src\\userImages\\LionelMessi.jpg"));
        users.add(new User(3, "Harry Kane","src\\userImages\\Harry_Kane.jpg"));
        users.add(new User(4, "Lewy","src\\userImages\\lewy.jpg"));
        users.add(new User(5, "Neymar JR","src\\userImages\\Neymar.jpg"));
        users.add(new User(6, "Virgil Vandijk","src\\userImages\\Vandjik.jpg"));

        // Calculate the number of rows and columns for the grid
        int numColumns = 3;
        int numRows = (int) Math.ceil((double) users.size() / numColumns);

        // Create a JPanel with a GridLayout to hold the user cells
        JPanel gridPanel = new JPanel(new GridLayout(numRows, numColumns));

        // Create and add user cells to the grid panel
        for (User user : users) {
            UserCell userCell = new UserCell(user);
            gridPanel.add(userCell);
        }

        // Add the grid panel to the JFrame
        frame.getContentPane().add(gridPanel);

        // Display the JFrame
        frame.setVisible(true);
    }

    // User cell class
    static class UserCell extends JButton {
    private User user;

    public UserCell(User user) {
        this.user = user;
        setLayout(new BorderLayout());

        // Create an ImageIcon from the image URL
        ImageIcon imageIcon = new ImageIcon(user.getImage());
        // Scale the image to fit within a 50x50 pixel box
        Image scaledImage = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        // Create a JLabel to display the image
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        JLabel nameLabel = new JLabel(user.getName());
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(nameLabel, BorderLayout.CENTER);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked user ID: " + user.getId());
                // Perform your desired action here
            }
        });
    }
}

    // User class
    static class User {
        private int id;
        private String name;
        private String image;

        public User(int id, String name,String image) {
            this.id = id;
            this.name = name;
            this.image=image;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getImage() {
            return image;
        }
        
    }
}







