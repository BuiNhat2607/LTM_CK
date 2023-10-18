/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author MINHNHAT
 */
public class Result {

    private String artist_names;
    private String full_title;
    private String header_image_thumbnail_url;
    private String header_image_url;
    private int id;
    private int lyrics_owner_id;
    private String lyrics_state;
    private String path;
    private int pyongs_count;
    private String relationships_index_url;
    private ReleaseDateComponents release_date_components;
    private String release_date_for_display;
    private String release_date_with_abbreviated_month_for_display;
    private String song_art_image_thumbnail_url;
    private String song_art_image_url;
    private String title;
    private String title_with_featured;
    private String url;
    private List<FeaturedArtists> featured_artists;
    private PrimaryArtist primary_artist;

    public List<FeaturedArtists> getFeatured_artists() {
        return featured_artists;
    }
    

    public String getArtist_names() {
        return artist_names;
    }

    public void setArtist_names(String artist_names) {
        this.artist_names = artist_names;
    }

    public String getFull_title() {
        return full_title;
    }

    public void setFull_title(String full_title) {
        this.full_title = full_title;
    }

    public String getHeader_image_thumbnail_url() {
        return header_image_thumbnail_url;
    }

    public void setHeader_image_thumbnail_url(String header_image_thumbnail_url) {
        this.header_image_thumbnail_url = header_image_thumbnail_url;
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

    public int getLyrics_owner_id() {
        return lyrics_owner_id;
    }

    public void setLyrics_owner_id(int lyrics_owner_id) {
        this.lyrics_owner_id = lyrics_owner_id;
    }

    public String getLyrics_state() {
        return lyrics_state;
    }

    public void setLyrics_state(String lyrics_state) {
        this.lyrics_state = lyrics_state;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPyongs_count() {
        return pyongs_count;
    }

    public void setPyongs_count(int pyongs_count) {
        this.pyongs_count = pyongs_count;
    }

    public String getRelationships_index_url() {
        return relationships_index_url;
    }

    public void setRelationships_index_url(String relationships_index_url) {
        this.relationships_index_url = relationships_index_url;
    }

    public ReleaseDateComponents getRelease_date_components() {
        return release_date_components;
    }

    public void setRelease_date_components(ReleaseDateComponents release_date_components) {
        this.release_date_components = release_date_components;
    }

    public String getRelease_date_for_display() {
        return release_date_for_display;
    }

    public void setRelease_date_for_display(String release_date_for_display) {
        this.release_date_for_display = release_date_for_display;
    }

    public String getRelease_date_with_abbreviated_month_for_display() {
        return release_date_with_abbreviated_month_for_display;
    }

    public void setRelease_date_with_abbreviated_month_for_display(String release_date_with_abbreviated_month_for_display) {
        this.release_date_with_abbreviated_month_for_display = release_date_with_abbreviated_month_for_display;
    }

    public String getSong_art_image_thumbnail_url() {
        return song_art_image_thumbnail_url;
    }

    public void setSong_art_image_thumbnail_url(String song_art_image_thumbnail_url) {
        this.song_art_image_thumbnail_url = song_art_image_thumbnail_url;
    }

    public String getSong_art_image_url() {
        return song_art_image_url;
    }

    public void setSong_art_image_url(String song_art_image_url) {
        this.song_art_image_url = song_art_image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_with_featured() {
        return title_with_featured;
    }

    public void setTitle_with_featured(String title_with_featured) {
        this.title_with_featured = title_with_featured;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public List<String> getFeatured_artists() {
//        return featured_artists;
//    }
//
//    public void setFeatured_artists(List<String> featured_artists) {
//        this.featured_artists = featured_artists;
//    }

    public PrimaryArtist getPrimary_artist() {
        return primary_artist;
    }

    public void setPrimary_artist(PrimaryArtist primary_artist) {
        this.primary_artist = primary_artist;
    }
    
}
