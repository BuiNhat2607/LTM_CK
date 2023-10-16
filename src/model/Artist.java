/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author MINHNHAT
 */
public class Artist {

//    public List<String> getAlternateNames() {
//        return alternateNames;
//    }
//
//    public void setAlternateNames(List<String> alternateNames) {
//        this.alternateNames = alternateNames;
//    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public void setHeaderImageUrl(String headerImageUrl) {
        this.headerImageUrl = headerImageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInstagramName() {
        return instagramName;
    }

    public void setInstagramName(String instagramName) {
        this.instagramName = instagramName;
    }

    public boolean isIsMemeVerified() {
        return isMemeVerified;
    }

    public void setIsMemeVerified(boolean isMemeVerified) {
        this.isMemeVerified = isMemeVerified;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTranslationArtist() {
        return translationArtist;
    }

    public void setTranslationArtist(boolean translationArtist) {
        this.translationArtist = translationArtist;
    }

    public String getTwitterName() {
        return twitterName;
    }

    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CurrentUserMetadata getCurrentUserMetadata() {
        return currentUserMetadata;
    }

    public void setCurrentUserMetadata(CurrentUserMetadata currentUserMetadata) {
        this.currentUserMetadata = currentUserMetadata;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public DescriptionAnnotation getDescriptionAnnotation() {
        return descriptionAnnotation;
    }

    public void setDescriptionAnnotation(DescriptionAnnotation descriptionAnnotation) {
        this.descriptionAnnotation = descriptionAnnotation;
    }

//    @SerializedName("alternate_names")
//    List<String> alternateNames;
    @SerializedName("api_path")
    String apiPath;
    Description description;
    @SerializedName("facebook_name")
    String facebookName;
    @SerializedName("followers_count")
    int followersCount;
    @SerializedName("header_image_url")
    String headerImageUrl;
    int id;
    @SerializedName("image_url")
    String imageUrl;
    @SerializedName("instagram_name")
    String instagramName;
    @SerializedName("is_meme_verified")
    boolean isMemeVerified;
    @SerializedName("is_verified")
    boolean isVerified;
    String name;
    @SerializedName("translation_artist")
    boolean translationArtist;
    @SerializedName("twitter_name")
    String twitterName;
    String url;
    @SerializedName("current_user_metadata")
    CurrentUserMetadata currentUserMetadata;
    int iq;
    @SerializedName("description_annotation")
    DescriptionAnnotation descriptionAnnotation;
}
