package com.eniad.sihatrack_v_1.ui.userActivities.articles;

public class Articl {

    private String title;
    private String image;
    private String paraghraph;
    private String contenu;
    private String url;

    public Articl(String title, String image, String paraghraph, String contenu, String url) {
        this.title = title;
        this.image = image;
        this.paraghraph = paraghraph;
        this.contenu = contenu;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getParaghraph() {
        return paraghraph;
    }

    public void setParaghraph(String paraghraph) {
        this.paraghraph = paraghraph;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
