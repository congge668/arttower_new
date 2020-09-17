package com.example.arttower.bean;

public class OthersNewsBean {

    /**
     * code : 200000
     * msg :
     * data : {"userId":"51fde5a3def8754d1d7a2716862293f0","nickName":"困","headUrl":"https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020081915978027639996159.png","prestige":null,"focusCount":6,"fansCount":0,"videoCount":null,"danceMoney":null,"isFocus":"0","content":"金钱美酒与狗","collectNum":6,"courseNum":0,"vide":null,"praiseNum":null,"smallchange":null}
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
         * userId : 51fde5a3def8754d1d7a2716862293f0
         * nickName : 困
         * headUrl : https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020081915978027639996159.png
         * prestige : null
         * focusCount : 6
         * fansCount : 0
         * videoCount : null
         * danceMoney : null
         * isFocus : 0
         * content : 金钱美酒与狗
         * collectNum : 6
         * courseNum : 0
         * vide : null
         * praiseNum : null
         * smallchange : null
         */

        private String userId;
        private String nickName;
        private String headUrl;
        private Object prestige;
        private int focusCount;
        private int fansCount;
        private Object videoCount;
        private Object danceMoney;
        private String isFocus;
        private String content;
        private int collectNum;
        private int courseNum;
        private Object vide;
        private Object praiseNum;
        private Object smallchange;

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

        public Object getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(Object videoCount) {
            this.videoCount = videoCount;
        }

        public Object getDanceMoney() {
            return danceMoney;
        }

        public void setDanceMoney(Object danceMoney) {
            this.danceMoney = danceMoney;
        }

        public String getIsFocus() {
            return isFocus;
        }

        public void setIsFocus(String isFocus) {
            this.isFocus = isFocus;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getCollectNum() {
            return collectNum;
        }

        public void setCollectNum(int collectNum) {
            this.collectNum = collectNum;
        }

        public int getCourseNum() {
            return courseNum;
        }

        public void setCourseNum(int courseNum) {
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

        public Object getSmallchange() {
            return smallchange;
        }

        public void setSmallchange(Object smallchange) {
            this.smallchange = smallchange;
        }
    }
}
