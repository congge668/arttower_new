package com.example.arttower.fragment.HomePage.bean;

import java.util.List;

/*
*
* 首页评论
* */
public  class CommentBean {

    /**
     * code : 200000
     * msg : null
     * data : {"total":14,"rows":[{"id":"1","createTime":"2020-07-27 13:55:30","updateTime":"2020-07-27 18:22:31","createUser":"1","updateUser":"1","videoId":"2326fd4579584c58b53e1984fcd36b96","rootId":null,"message":"这是评论的回复东方14616范德萨6付费而3微软史蒂夫速度vs/n/t/r这是评论的回复东这是评论的回复东这是评论的回复东sdsqadwqefadfsad","dataStatus":"AVAILABLE","replyNum":"2","commentThumbs":"1","isThumbs":"0","nickName":"用户","headUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg"}]}
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
         * total : 14
         * rows : [{"id":"1","createTime":"2020-07-27 13:55:30","updateTime":"2020-07-27 18:22:31","createUser":"1","updateUser":"1","videoId":"2326fd4579584c58b53e1984fcd36b96","rootId":null,"message":"这是评论的回复东方14616范德萨6付费而3微软史蒂夫速度vs/n/t/r这是评论的回复东这是评论的回复东这是评论的回复东sdsqadwqefadfsad","dataStatus":"AVAILABLE","replyNum":"2","commentThumbs":"1","isThumbs":"0","nickName":"用户","headUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg"}]
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
             * id : 1
             * createTime : 2020-07-27 13:55:30
             * updateTime : 2020-07-27 18:22:31
             * createUser : 1
             * updateUser : 1
             * videoId : 2326fd4579584c58b53e1984fcd36b96
             * rootId : null
             * message : 这是评论的回复东方14616范德萨6付费而3微软史蒂夫速度vs/n/t/r这是评论的回复东这是评论的回复东这是评论的回复东sdsqadwqefadfsad
             * dataStatus : AVAILABLE
             * replyNum : 2
             * commentThumbs : 1
             * isThumbs : 0
             * nickName : 用户
             * headUrl : http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private String updateUser;
            private String videoId;
            private Object rootId;
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

            public Object getRootId() {
                return rootId;
            }

            public void setRootId(Object rootId) {
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
