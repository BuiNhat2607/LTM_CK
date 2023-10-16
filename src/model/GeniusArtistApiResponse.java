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
public class GeniusArtistApiResponse {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("response")
    private ArtistResponse response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArtistResponse getResponse() {
        return response;
    }

    public void setResponse(ArtistResponse response) {
        this.response = response;
    }

}
