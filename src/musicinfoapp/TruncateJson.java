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
 * @author WitherDragon
 */
public class TruncateJson {
    public static String truncateJsonSearch(String json){
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
    public static String truncateLyricsJson(String json){
        JsonObject rootJson = JsonParser.parseString(json).getAsJsonObject();
        rootJson.getAsJsonObject("lyrics").remove("api_path");
        rootJson.getAsJsonObject("lyrics").remove("_type");
        rootJson.getAsJsonObject("lyrics").remove("path");
        rootJson.getAsJsonObject("lyrics").remove("song_id");
        rootJson.getAsJsonObject("lyrics").remove("tracking_data");
        return rootJson.toString();
    }
}
