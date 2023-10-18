/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author WitherDragon
 */
public class FeaturedArtists {
    private String api_path;
    private String header_image_url;
    private int id;
    private String image_url;
    private boolean is_meme_verified;
    private boolean is_verified;
    private String name;
    private String url;

    public String getApi_path() {
        return api_path;
    }

    public String getHeader_image_url() {
        return header_image_url;
    }

    public int getId() {
        return id;
    }

    public String getImage_url() {
        return image_url;
    }

    public boolean isIs_meme_verified() {
        return is_meme_verified;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    
}
