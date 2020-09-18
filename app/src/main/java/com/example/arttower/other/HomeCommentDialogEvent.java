package com.example.arttower.other;

public class HomeCommentDialogEvent {

    private int apiConfig;
    private String id;
    private String uid;
    private String videoContent;
    private boolean isClickPinglu;

    public HomeCommentDialogEvent(int apiConfig,String id, String uid,String videoContent) {
        this.id = id;
        this.uid = uid;
        this.videoContent = videoContent;
        this.apiConfig = apiConfig;
    }

    public HomeCommentDialogEvent(int apiConfig,String id, String uid,String videoContent,boolean isClickPinglu) {
        this.id = id;
        this.uid = uid;
        this.videoContent = videoContent;
        this.apiConfig = apiConfig;
        this.isClickPinglu = isClickPinglu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(String videoContent) {
        this.videoContent = videoContent;
    }

    public int getApiConfig() {
        return apiConfig;
    }

    public void setApiConfig(int apiConfig) {
        this.apiConfig = apiConfig;
    }

    public boolean isClickPinglu() {
        return isClickPinglu;
    }

    public void setClickPinglu(boolean clickPinglu) {
        isClickPinglu = clickPinglu;
    }
}
