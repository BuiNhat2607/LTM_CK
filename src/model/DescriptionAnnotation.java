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
public class DescriptionAnnotation {

    String _type;
    int annotatorId;
    String annotatorLogin;
    @SerializedName("api_path")
    String apiPath;
    String classification;
    String fragment;
    int id;
    @SerializedName("is_description")
    boolean isDescription;
    Range range;
    String url;
    List<Object> verifiedAnnotatorIds;
    Annotatable annotatable;
    List<Annotations> annotations;

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public int getAnnotatorId() {
        return annotatorId;
    }

    public void setAnnotatorId(int annotatorId) {
        this.annotatorId = annotatorId;
    }

    public String getAnnotatorLogin() {
        return annotatorLogin;
    }

    public void setAnnotatorLogin(String annotatorLogin) {
        this.annotatorLogin = annotatorLogin;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsDescription() {
        return isDescription;
    }

    public void setIsDescription(boolean isDescription) {
        this.isDescription = isDescription;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Object> getVerifiedAnnotatorIds() {
        return verifiedAnnotatorIds;
    }

    public void setVerifiedAnnotatorIds(List<Object> verifiedAnnotatorIds) {
        this.verifiedAnnotatorIds = verifiedAnnotatorIds;
    }

    public Annotatable getAnnotatable() {
        return annotatable;
    }

    public void setAnnotatable(Annotatable annotatable) {
        this.annotatable = annotatable;
    }

    public List<Annotations> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotations> annotations) {
        this.annotations = annotations;
    }
}
