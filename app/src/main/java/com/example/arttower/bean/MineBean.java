package com.example.arttower.bean;

public class MineBean {


    /**
     * code : 200000
     * msg : 成功
     * data : {"userId":"c45b478a57f2f1275f241f1256c7e240","nickName":"昵称","headUrl":"http://19.img","prestige":null,"focusCount":0,"fansCount":0,"videoCount":0,"danceMoney":0,"isFocus":null,"content":null,"collectNum":null,"courseNum":null,"vide":null,"praiseNum":null,"smallchange":0}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userId : c45b478a57f2f1275f241f1256c7e240
         * nickName : 昵称
         * headUrl : http://19.img
         * prestige : null
         * focusCount : 0
         * fansCount : 0
         * videoCount : 0
         * danceMoney : 0
         * isFocus : null
         * content : null
         * collectNum : null
         * courseNum : null
         * vide : null
         * praiseNum : null
         * smallchange : 0
         */

        private String userId;
        private String nickName;
        private String headUrl;
        private Object prestige;
        private int focusCount;
        private int fansCount;
        private int videoCount;
        private int danceMoney;
        private Object isFocus;
        private Object content;
        private Object collectNum;
        private Object courseNum;
        private Object vide;
        private Object praiseNum;
        private int smallchange;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public Object getPrestige() {
            return prestige;
        }

        public void setPrestige(Object prestige) {
            this.prestige = prestige;
        }

        public int getFocusCount() {
            return focusCount;
        }

        public void setFocusCount(int focusCount) {
            this.focusCount = focusCount;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getDanceMoney() {
            return danceMoney;
        }

        public void setDanceMoney(int danceMoney) {
            this.danceMoney = danceMoney;
        }

        public Object getIsFocus() {
            return isFocus;
        }

        public void setIsFocus(Object isFocus) {
            this.isFocus = isFocus;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Object getCollectNum() {
            return collectNum;
        }

        public void setCollectNum(Object collectNum) {
            this.collectNum = collectNum;
        }

        public Object getCourseNum() {
            return courseNum;
        }

        public void setCourseNum(Object courseNum) {
            this.courseNum = courseNum;
        }

        public Object getVide() {
            return vide;
        }

        public void setVide(Object vide) {
            this.vide = vide;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getSmallchange() {
            return smallchange;
        }

        public void setSmallchange(int smallchange) {
            this.smallchange = smallchange;
        }
    }
}
