/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicinfoapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author MINHNHAT
 */
public class TruncateJson {

    public static String truncateJsonSearch(String json) {
        JsonObject rootJson = JsonParser.parseString(json).getAsJsonObject();
        JsonObject response = rootJson.getAsJsonObject("response");
        JsonArray hits = response.getAsJsonArray("hits");

        for (JsonElement hit : hits) {
            JsonObject hitObject = hit.getAsJsonObject();

            // Remove fields in the 'hit' object
            if (hitObject.has("index")) {
                hitObject.remove("index");
            }
            if (hitObject.has("highlights")) {
                hitObject.remove("highlights");
            }
            if (hitObject.has("type")) {
                hitObject.remove("type");
            }

            JsonObject result = hitObject.getAsJsonObject("result");

            // Remove fields in the 'result' object
            if (result.has("api_path")) {
                result.remove("api_path");
            }
            if (result.has("stats")) {
                result.remove("stats");
            }
            if (result.has("annotation_count")) {
                result.remove("annotation_count");
            }
        }
//        System.out.println(gson.toJson(rootJson));
        return rootJson.toString();
    }

    public static String truncateLyricsJson(String json) {
        JsonObject rootJson = JsonParser.parseString(json).getAsJsonObject();
        rootJson.getAsJsonObject("lyrics").remove("api_path");
        rootJson.getAsJsonObject("lyrics").remove("_type");
        rootJson.getAsJsonObject("lyrics").remove("path");
        rootJson.getAsJsonObject("lyrics").remove("song_id");
        rootJson.getAsJsonObject("lyrics").remove("tracking_data");
        return rootJson.toString();
    }

    public static String truncateArtistJson(String json) {
        JsonObject rootJson = JsonParser.parseString(json).getAsJsonObject();
        JsonObject artistJson = rootJson.getAsJsonObject("response").getAsJsonObject("artist");
        artistJson.remove("api_path");
        artistJson.remove("followers_count");
        artistJson.remove("header_image_url");
        artistJson.remove("is_meme_verified");
        artistJson.remove("is_verified");
        artistJson.remove("translation_artist");
        artistJson.remove("url");
        artistJson.remove("current_user_metadata");
        artistJson.remove("iq");
        artistJson.remove("description_annotation");
        artistJson.remove("user");
        return artistJson.toString();
    }

    public static String truncateMediaJson(String json) {
        JsonObject rootJson = JsonParser.parseString(json).getAsJsonObject();

        JsonObject songObject = rootJson.getAsJsonObject("response").getAsJsonObject("song");

        // Remove unwanted properties from the "song" object
        //  Cắt những trường không dùng.
        songObject.remove("annotation_count");
        songObject.remove("api_path");
        songObject.remove("apple_music_id");
        songObject.remove("apple_music_player_url");
        songObject.remove("artist_names");
        songObject.remove("description");
        songObject.remove("embed_content");
        songObject.remove("featured_video");
        songObject.remove("full_title");
        songObject.remove("header_image_thumbnail_url");
        songObject.remove("header_image_url");
        songObject.remove("id");
        songObject.remove("language");
        songObject.remove("lyrics_owner_id");
        songObject.remove("lyrics_placeholder_reason");
        songObject.remove("lyrics_state");
        songObject.remove("path");
        songObject.remove("pyongs_count");
        songObject.remove("recording_location");
        songObject.remove("relationships_index_url");
        songObject.remove("release_date");
        songObject.remove("release_date_for_display");
        songObject.remove("release_date_with_abbreviated_month_for_display");
        songObject.remove("song_art_image_thumbnail_url");
        songObject.remove("song_art_image_url");
        songObject.remove("stats");
        songObject.remove("title");
        songObject.remove("title_with_featured");
        songObject.remove("url");
        songObject.remove("current_user_metadata");
        songObject.remove("album");
        songObject.remove("custom_performances");
        songObject.remove("description_annotation");
        songObject.remove("featured_artists");
        songObject.remove("lyrics_marked_complete_by");
        songObject.remove("lyrics_marked_staff_approved_by");
        songObject.remove("primary_artist");
        songObject.remove("producer_artists");
        songObject.remove("song_relationships");
        songObject.remove("translation_songs");
        songObject.remove("verified_annotations_by");
        songObject.remove("verified_contributors");
        songObject.remove("verified_lyrics_by");
        songObject.remove("writer_artists");
        System.out.println("Ket qua cat JSON::::" + rootJson.toString());
        // Convert the modified JSON back to a string
        return rootJson.toString();
    }
}
