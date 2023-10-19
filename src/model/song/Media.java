/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.song;

/**
 *
 * @author MINHNHAT
 */
public class Media {
    private String provider;
    private int start;
    private String type;
    private String url;
    private String native_uri;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNativeUri() {
        return native_uri;
    }

    public void setNativeUri(String native_uri) {
        this.native_uri = native_uri;
    }
}
