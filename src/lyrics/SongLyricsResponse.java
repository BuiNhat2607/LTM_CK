/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lyrics;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author MINHNHAT
 */
public class SongLyricsResponse {
    @SerializedName("lyrics")
    private Lyrics lyrics;

    public Lyrics getLyrics() {
        return lyrics;
    }

    public void setLyrics(Lyrics lyrics) {
        this.lyrics = lyrics;
    }
}
