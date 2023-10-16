/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author MINHNHAT
 */
public class ArtistResponse {
    @SerializedName("artist")
    private Artist artist;

    public Artist getArtist() {
        return artist;
    }
}