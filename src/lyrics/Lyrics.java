/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lyrics;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author WitherDragon
 */
 public class Lyrics {
    @SerializedName("lyrics")
    private LyricsContent lyricsContent;

    public LyricsContent getLyricsContent() {
        return lyricsContent;
    }

    public void setLyricsContent(LyricsContent lyricsContent) {
        this.lyricsContent = lyricsContent;
    }
}
