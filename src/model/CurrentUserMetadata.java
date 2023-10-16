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
public class CurrentUserMetadata {

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getExcludedPermissions() {
        return excludedPermissions;
    }

    public void setExcludedPermissions(List<String> excludedPermissions) {
        this.excludedPermissions = excludedPermissions;
    }

    public Interactions getInteractions() {
        return interactions;
    }

    public void setInteractions(Interactions interactions) {
        this.interactions = interactions;
    }

    List<String> permissions;
    @SerializedName("excluded_permissions")
    List<String> excludedPermissions;
    Interactions interactions;
}
