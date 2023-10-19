/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.song;

import com.google.gson.annotations.SerializedName;
import model.ArtistResponse;
import model.Meta;

/**
 *
 * @author MINHNHAT
 */
public class SongAPIResponse {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("response")
    private SongRespone response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public SongRespone getResponse() {
        return response;
    }

    public void setResponse(SongRespone response) {
        this.response = response;
    }
}
