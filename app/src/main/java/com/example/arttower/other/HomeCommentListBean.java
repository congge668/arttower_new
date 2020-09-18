package com.example.arttower.other;

import java.util.List;

public class HomeCommentListBean {


    /**
     * code : 200000
     * msg : null
     * data : {"total":6,"rows":[{"id":"16001507520571092100192356970535","createTime":"2020-09-15 14:19:12","updateTime":"2020-09-15 14:19:12","createUser":"79c1f84ae03512e4d8f38124cdab9ba0","updateUser":"79c1f84ae03512e4d8f38124cdab9ba0","videoId":"feaaf2d8b180479892e5b507574d3adc","rootId":"233","message":"mmmn","dataStatus":"AVAILABLE","replyNum":"0","commentThumbs":"0","isThumbs":"0","nickName":"18311034173","headUrl":"http://19.img"}]}
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
         * total : 6
         * rows : [{"id":"16001507520571092100192356970535","createTime":"2020-09-15 14:19:12","updateTime":"2020-09-15 14:19:12","createUser":"79c1f84ae03512e4d8f38124cdab9ba0","updateUser":"79c1f84ae03512e4d8f38124cdab9ba0","videoId":"feaaf2d8b180479892e5b507574d3adc","rootId":"233","message":"mmmn","dataStatus":"AVAILABLE","replyNum":"0","commentThumbs":"0","isThumbs":"0","nickName":"18311034173","headUrl":"http://19.img"}]
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
             * id : 16001507520571092100192356970535
             * createTime : 2020-09-15 14:19:12
             * updateTime : 2020-09-15 14:19:12
             * createUser : 79c1f84ae03512e4d8f38124cdab9ba0
             * updateUser : 79c1f84ae03512e4d8f38124cdab9ba0
             * videoId : feaaf2d8b180479892e5b507574d3adc
             * rootId : 233
             * message : mmmn
             * dataStatus : AVAILABLE
             * replyNum : 0
             * commentThumbs : 0
             * isThumbs : 0
             * nickName : 18311034173
             * headUrl : http://19.img
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private String updateUser;
            private String videoId;
            private String rootId;
            private String message;
            private String dataStatus;
            private String replyNum;
            private String commentThumbs;
            private String isThumbs;
            private String nickName;
            private String headUrl;

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

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }

            public String getRootId() {
                return rootId;
            }

            public void setRootId(String rootId) {
                this.rootId = rootId;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getDataStatus() {
                return dataStatus;
            }

            public void setDataStatus(String dataStatus) {
                this.dataStatus = dataStatus;
            }

            public String getReplyNum() {
                return replyNum;
            }

            public void setReplyNum(String replyNum) {
                this.replyNum = replyNum;
            }

            public String getCommentThumbs() {
                return commentThumbs;
            }

            public void setCommentThumbs(String commentThumbs) {
                this.commentThumbs = commentThumbs;
            }

            public String getIsThumbs() {
                return isThumbs;
            }

            public void setIsThumbs(String isThumbs) {
                this.isThumbs = isThumbs;
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
        }
    }
}
