package com.example.arttower.bean;

import java.util.List;

/*
* 视频搜索bean
* */
public class VideoRetrievalBean {

    /**
     * code : 200000
     * msg : null
     * data : {"total":1,"rows":[{"id":"4b25c18a05324589b0bc29d222aaf5c0","uid":"10012","name":"凄凄切切倩倩#芭蕾舞","imgUrl":"http://vod.tingwu365.com/image/default/0371FD22FA174A02B1856EBE9056AC4C-6-2.png","videoUrl":"http://vod.tingwu365.com/sv/4c106b3c-174686df71a/4c106b3c-174686df71a.mp4","nickName":"熊猫","videoRemark":null,"createTime":"2020-09-07 19:57:51.0","updateTime":"2020-09-08 17:44:17.0","praiseCounts":"6","about":null}]}
     */

    private int code;
    private Object msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 1
         * rows : [{"id":"4b25c18a05324589b0bc29d222aaf5c0","uid":"10012","name":"凄凄切切倩倩#芭蕾舞","imgUrl":"http://vod.tingwu365.com/image/default/0371FD22FA174A02B1856EBE9056AC4C-6-2.png","videoUrl":"http://vod.tingwu365.com/sv/4c106b3c-174686df71a/4c106b3c-174686df71a.mp4","nickName":"熊猫","videoRemark":null,"createTime":"2020-09-07 19:57:51.0","updateTime":"2020-09-08 17:44:17.0","praiseCounts":"6","about":null}]
         */

        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * id : 4b25c18a05324589b0bc29d222aaf5c0
             * uid : 10012
             * name : 凄凄切切倩倩#芭蕾舞
             * imgUrl : http://vod.tingwu365.com/image/default/0371FD22FA174A02B1856EBE9056AC4C-6-2.png
             * videoUrl : http://vod.tingwu365.com/sv/4c106b3c-174686df71a/4c106b3c-174686df71a.mp4
             * nickName : 熊猫
             * videoRemark : null
             * createTime : 2020-09-07 19:57:51.0
             * updateTime : 2020-09-08 17:44:17.0
             * praiseCounts : 6
             * about : null
             */

            private String id;
            private String uid;
            private String name;
            private String imgUrl;
            private String videoUrl;
            private String nickName;
            private Object videoRemark;
            private String createTime;
            private String updateTime;
            private String praiseCounts;
            private Object about;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public Object getVideoRemark() {
                return videoRemark;
            }

            public void setVideoRemark(Object videoRemark) {
                this.videoRemark = videoRemark;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getPraiseCounts() {
                return praiseCounts;
            }

            public void setPraiseCounts(String praiseCounts) {
                this.praiseCounts = praiseCounts;
            }

            public Object getAbout() {
                return about;
            }

            public void setAbout(Object about) {
                this.about = about;
            }
        }
    }
}
