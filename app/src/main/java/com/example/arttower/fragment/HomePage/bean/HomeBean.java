package com.example.arttower.fragment.HomePage.bean;

import java.util.List;

public class HomeBean {
    /**
     * code : 200000
     * msg : null
     * data : [{"commentNum":"0","imgUrl":"http://vod.tingwu365.com/image/default/FE7285F307FB47209545A57B797E7953-6-2.png","uid":"ad3e750bb7f1dcbd0bd42adc5ed6c715","forwardNum":"0","videoUrl":[{"videoUrl":"http://vod.tingwu365.com/sv/13f30d60-1749787855e/13f30d60-1749787855e.mp4","id":"e5c7ba61d742fa2d3d13db28ed81a463"}],"nickName":"侯老师","headUrl":"https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020091616002713408238286.png","praiseNum":"1","isPraise":"0","label":[{"labelId":"1","labelName":"芭蕾舞"}],"id":"fa4cb389a8e5436892adb24e18d065f9","videoContent":"真的很多#芭蕾舞"}]
     */

    private int code;
    private Object msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 0
         * imgUrl : http://vod.tingwu365.com/image/default/FE7285F307FB47209545A57B797E7953-6-2.png
         * uid : ad3e750bb7f1dcbd0bd42adc5ed6c715
         * forwardNum : 0
         * videoUrl : [{"videoUrl":"http://vod.tingwu365.com/sv/13f30d60-1749787855e/13f30d60-1749787855e.mp4","id":"e5c7ba61d742fa2d3d13db28ed81a463"}]
         * nickName : 侯老师
         * headUrl : https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020091616002713408238286.png
         * praiseNum : 1
         * isPraise : 0
         * label : [{"labelId":"1","labelName":"芭蕾舞"}]
         * id : fa4cb389a8e5436892adb24e18d065f9
         * videoContent : 真的很多#芭蕾舞
         */

        private String commentNum;
        private String imgUrl;
        private String uid;
        private String forwardNum;
        private String nickName;
        private String headUrl;
        private String praiseNum;
        private String isPraise;
        private String id;
        private String videoContent;
        private List<VideoUrlBean> videoUrl;
        private List<LabelBean> label;

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
            this.commentNum = commentNum;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getForwardNum() {
            return forwardNum;
        }

        public void setForwardNum(String forwardNum) {
            this.forwardNum = forwardNum;
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

        public String getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(String praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getIsPraise() {
            return isPraise;
        }

        public void setIsPraise(String isPraise) {
            this.isPraise = isPraise;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVideoContent() {
            return videoContent;
        }

        public void setVideoContent(String videoContent) {
            this.videoContent = videoContent;
        }

        public List<VideoUrlBean> getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(List<VideoUrlBean> videoUrl) {
            this.videoUrl = videoUrl;
        }

        public List<LabelBean> getLabel() {
            return label;
        }

        public void setLabel(List<LabelBean> label) {
            this.label = label;
        }

        public static class VideoUrlBean {
            /**
             * videoUrl : http://vod.tingwu365.com/sv/13f30d60-1749787855e/13f30d60-1749787855e.mp4
             * id : e5c7ba61d742fa2d3d13db28ed81a463
             */

            private String videoUrl;
            private String id;

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class LabelBean {
            /**
             * labelId : 1
             * labelName : 芭蕾舞
             */

            private String labelId;
            private String labelName;

            public String getLabelId() {
                return labelId;
            }

            public void setLabelId(String labelId) {
                this.labelId = labelId;
            }

            public String getLabelName() {
                return labelName;
            }

            public void setLabelName(String labelName) {
                this.labelName = labelName;
            }
        }
    }
}
