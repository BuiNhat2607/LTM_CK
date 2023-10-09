/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MINHNHAT
 */
public class PrimaryArtist {
    private String api_path;
    private String header_image_url;
    private int id;
    private String image_url;
    private boolean is_meme_verified;
    private boolean is_verified;
    private String name;
    private String url;
    private int iq;

    public String getApi_path() {
        return api_path;
    }

    public void setApi_path(String api_path) {
        this.api_path = api_path;
    }

    public String getHeader_image_url() {
        return header_image_url;
    }

    public void setHeader_image_url(String header_image_url) {
        this.header_image_url = header_image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isIs_meme_verified() {
        return is_meme_verified;
    }

    public void setIs_meme_verified(boolean is_meme_verified) {
        this.is_meme_verified = is_meme_verified;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
    
}
