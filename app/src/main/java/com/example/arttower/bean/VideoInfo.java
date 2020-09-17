package com.example.arttower.bean;

import java.util.List;

public class VideoInfo {

    /**
     * code : 200000
     * msg : null
     * data : {"total":100031,"rows":[{"id":"2326fd4579584c58b53e1984fcd36b96","createTime":"2020-07-24 15:44:14","updateTime":"2020-07-24 16:02:48","createUser":"1","updateUser":null,"imgUrl":"http://vod.tingwu365.com/2326fd4579584c58b53e1984fcd36b96/snapshots/0ff1403d89644efebca0e6d82a90194f-00001.jpg","name":"安多里尼先生可以说是我这辈子有过的最好老师。你可以跟他一起开玩笑，却不致于失去对他的尊敬。","uid":"a50fe0b2303aaeef9815e9acee7cdf60","videoType":"VIDEO","recommend":"NO","videoStatus":"EVERYONESEE","videoTime":null,"videoSize":null,"headUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg","nickName":"逍遥豆子","praiseNum":"4","forwardNum":"0","commentNum":"6","isPraise":"0","videoUrl":[{"id":"cae3f0026c697197b7e335fb4a967c36","createTime":null,"updateTime":null,"createUser":null,"updateUser":null,"videoId":null,"videoUrl":"http://vod.tingwu365.com/15d4c68653bd49b49bbf1726b6f60a4d/2798a704e6324333b0be0f9c98528878-4228c6046d7b1339968d0e41137ff1bc-ld.mp4","transcodeType":null}],"videoTag":null,"checkStatus":"SUCCESS","label":[{"labelId":"1","labelName":"芭蕾舞"}],"jobId":"","transcodeStatus":"NOTRANSCODE"}]}
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
         * total : 100031
         * rows : [{"id":"2326fd4579584c58b53e1984fcd36b96","createTime":"2020-07-24 15:44:14","updateTime":"2020-07-24 16:02:48","createUser":"1","updateUser":null,"imgUrl":"http://vod.tingwu365.com/2326fd4579584c58b53e1984fcd36b96/snapshots/0ff1403d89644efebca0e6d82a90194f-00001.jpg","name":"安多里尼先生可以说是我这辈子有过的最好老师。你可以跟他一起开玩笑，却不致于失去对他的尊敬。","uid":"a50fe0b2303aaeef9815e9acee7cdf60","videoType":"VIDEO","recommend":"NO","videoStatus":"EVERYONESEE","videoTime":null,"videoSize":null,"headUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg","nickName":"逍遥豆子","praiseNum":"4","forwardNum":"0","commentNum":"6","isPraise":"0","videoUrl":[{"id":"cae3f0026c697197b7e335fb4a967c36","createTime":null,"updateTime":null,"createUser":null,"updateUser":null,"videoId":null,"videoUrl":"http://vod.tingwu365.com/15d4c68653bd49b49bbf1726b6f60a4d/2798a704e6324333b0be0f9c98528878-4228c6046d7b1339968d0e41137ff1bc-ld.mp4","transcodeType":null}],"videoTag":null,"checkStatus":"SUCCESS","label":[{"labelId":"1","labelName":"芭蕾舞"}],"jobId":"","transcodeStatus":"NOTRANSCODE"}]
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
             * id : 2326fd4579584c58b53e1984fcd36b96
             * createTime : 2020-07-24 15:44:14
             * updateTime : 2020-07-24 16:02:48
             * createUser : 1
             * updateUser : null
             * imgUrl : http://vod.tingwu365.com/2326fd4579584c58b53e1984fcd36b96/snapshots/0ff1403d89644efebca0e6d82a90194f-00001.jpg
             * name : 安多里尼先生可以说是我这辈子有过的最好老师。你可以跟他一起开玩笑，却不致于失去对他的尊敬。
             * uid : a50fe0b2303aaeef9815e9acee7cdf60
             * videoType : VIDEO
             * recommend : NO
             * videoStatus : EVERYONESEE
             * videoTime : null
             * videoSize : null
             * headUrl : http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg
             * nickName : 逍遥豆子
             * praiseNum : 4
             * forwardNum : 0
             * commentNum : 6
             * isPraise : 0
             * videoUrl : [{"id":"cae3f0026c697197b7e335fb4a967c36","createTime":null,"updateTime":null,"createUser":null,"updateUser":null,"videoId":null,"videoUrl":"http://vod.tingwu365.com/15d4c68653bd49b49bbf1726b6f60a4d/2798a704e6324333b0be0f9c98528878-4228c6046d7b1339968d0e41137ff1bc-ld.mp4","transcodeType":null}]
             * videoTag : null
             * checkStatus : SUCCESS
             * label : [{"labelId":"1","labelName":"芭蕾舞"}]
             * jobId :
             * transcodeStatus : NOTRANSCODE
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private Object updateUser;
            private String imgUrl;
            private String name;
            private String uid;
            private String videoType;
            private String recommend;
            private String videoStatus;
            private Object videoTime;
            private Object videoSize;
            private String headUrl;
            private String nickName;
            private String praiseNum;
            private String forwardNum;
            private String commentNum;
            private String isPraise;
            private Object videoTag;
            private String checkStatus;
            private String jobId;
            private String transcodeStatus;
            private List<VideoUrlBean> videoUrl;
            private List<LabelBean> label;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public Object getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(Object updateUser) {
                this.updateUser = updateUser;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getVideoType() {
                return videoType;
            }

            public void setVideoType(String videoType) {
                this.videoType = videoType;
            }

            public String getRecommend() {
                return recommend;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public String getVideoStatus() {
                return videoStatus;
            }

            public void setVideoStatus(String videoStatus) {
                this.videoStatus = videoStatus;
            }

            public Object getVideoTime() {
                return videoTime;
            }

            public void setVideoTime(Object videoTime) {
                this.videoTime = videoTime;
            }

            public Object getVideoSize() {
                return videoSize;
            }

            public void setVideoSize(Object videoSize) {
                this.videoSize = videoSize;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }

            public String getForwardNum() {
                return forwardNum;
            }

            public void setForwardNum(String forwardNum) {
                this.forwardNum = forwardNum;
            }

            public String getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(String commentNum) {
                this.commentNum = commentNum;
            }

            public String getIsPraise() {
                return isPraise;
            }

            public void setIsPraise(String isPraise) {
                this.isPraise = isPraise;
            }

            public Object getVideoTag() {
                return videoTag;
            }

            public void setVideoTag(Object videoTag) {
                this.videoTag = videoTag;
            }

            public String getCheckStatus() {
                return checkStatus;
            }

            public void setCheckStatus(String checkStatus) {
                this.checkStatus = checkStatus;
            }

            public String getJobId() {
                return jobId;
            }

            public void setJobId(String jobId) {
                this.jobId = jobId;
            }

            public String getTranscodeStatus() {
                return transcodeStatus;
            }

            public void setTranscodeStatus(String transcodeStatus) {
                this.transcodeStatus = transcodeStatus;
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
                 * id : cae3f0026c697197b7e335fb4a967c36
                 * createTime : null
                 * updateTime : null
                 * createUser : null
                 * updateUser : null
                 * videoId : null
                 * videoUrl : http://vod.tingwu365.com/15d4c68653bd49b49bbf1726b6f60a4d/2798a704e6324333b0be0f9c98528878-4228c6046d7b1339968d0e41137ff1bc-ld.mp4
                 * transcodeType : null
                 */

                private String id;
                private Object createTime;
                private Object updateTime;
                private Object createUser;
                private Object updateUser;
                private Object videoId;
                private String videoUrl;
                private Object transcodeType;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public Object getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(Object createTime) {
                    this.createTime = createTime;
                }

                public Object getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(Object updateTime) {
                    this.updateTime = updateTime;
                }

                public Object getCreateUser() {
                    return createUser;
                }

                public void setCreateUser(Object createUser) {
                    this.createUser = createUser;
                }

                public Object getUpdateUser() {
                    return updateUser;
                }

                public void setUpdateUser(Object updateUser) {
                    this.updateUser = updateUser;
                }

                public Object getVideoId() {
                    return videoId;
                }

                public void setVideoId(Object videoId) {
                    this.videoId = videoId;
                }

                public String getVideoUrl() {
                    return videoUrl;
                }

                public void setVideoUrl(String videoUrl) {
                    this.videoUrl = videoUrl;
                }

                public Object getTranscodeType() {
                    return transcodeType;
                }

                public void setTranscodeType(Object transcodeType) {
                    this.transcodeType = transcodeType;
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
}
