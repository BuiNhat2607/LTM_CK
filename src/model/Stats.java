/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MINHNHAT
 */
public class Stats {
    private int unreviewed_annotations;
    private int concurrents;
    private boolean hot;
    private int pageviews;

    public int getUnreviewed_annotations() {
        return unreviewed_annotations;
    }

    public void setUnreviewed_annotations(int unreviewed_annotations) {
        this.unreviewed_annotations = unreviewed_annotations;
    }

    public int getConcurrents() {
        return concurrents;
    }

    public void setConcurrents(int concurrents) {
        this.concurrents = concurrents;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public int getPageviews() {
        return pageviews;
    }

    public void setPageviews(int pageviews) {
        this.pageviews = pageviews;
    }
    
}
