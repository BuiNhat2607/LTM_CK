/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.song;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author MINHNHAT
 */
public class SongRespone {
    @SerializedName("song")
    private Song song;

    public Song getSong () {
        return song;
    }
}
