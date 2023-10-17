/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songs;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author WitherDragon
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
