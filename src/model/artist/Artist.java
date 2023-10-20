/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.artist;

import java.util.List;




/**
 *
 * @author MINHNHAT
 */
public class Artist {
    private Description description;
    private String facebook_name;
    private int id;
    private String image_url;
    private String instagram_name;
    private String name;
    private String twitter_name;
    private String[] alternate_names;

    public String[] getAlternate_names() {
        return alternate_names;
    }
    


    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }



    public int getId() {
        return id;
    }


    public String getImageUrl() {
        return image_url;
    }


    public String getName() {
        return name;
    }



    public String getFacebook_name() {
        return facebook_name;
    }

    public String getInstagram_name() {
        return instagram_name;
    }

    public String getTwitter_name() {
        return twitter_name;
    }
    
}
