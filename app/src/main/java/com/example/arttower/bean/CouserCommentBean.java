package com.example.arttower.bean;

import java.util.List;

//课程评价实体类
public class CouserCommentBean {

    /**
     * code : 200000
     * msg :
     * data : [{"id":"20200910153719550000000000000073","createTime":"2020-09-10 15:37:19","updateTime":null,"createUser":"c0d43c290092a0d52af4c9bc7ea15d0c","updateUser":null,"courseId":"1080","parentId":null,"content":"你好","status":"AVAILABLE","replyCourseComments":null,"headUrl":"http://19.img","nickName":"15188708317","byReplyName":null,"byReplyHeadUrl":null,"byReplyUserId":null,"replyCount":0,"reply":false,"replyMake":false}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 20200910153719550000000000000073
         * createTime : 2020-09-10 15:37:19
         * updateTime : null
         * createUser : c0d43c290092a0d52af4c9bc7ea15d0c
         * updateUser : null
         * courseId : 1080
         * parentId : null
         * content : 你好
         * status : AVAILABLE
         * replyCourseComments : null
         * headUrl : http://19.img
         * nickName : 15188708317
         * byReplyName : null
         * byReplyHeadUrl : null
         * byReplyUserId : null
         * replyCount : 0
         * reply : false
         * replyMake : false
         */

        private String id;
        private String createTime;
        private Object updateTime;
        private String createUser;
        private Object updateUser;
        private String courseId;
        private Object parentId;
        private String content;
        private String status;
        private Object replyCourseComments;
        private String headUrl;
        private String nickName;
        private Object byReplyName;
        private Object byReplyHeadUrl;
        private Object byReplyUserId;
        private int replyCount;
        private boolean reply;
        private boolean replyMake;

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

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
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

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getReplyCourseComments() {
            return replyCourseComments;
        }

        public void setReplyCourseComments(Object replyCourseComments) {
            this.replyCourseComments = replyCourseComments;
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

        public Object getByReplyName() {
            return byReplyName;
        }

        public void setByReplyName(Object byReplyName) {
            this.byReplyName = byReplyName;
        }

        public Object getByReplyHeadUrl() {
            return byReplyHeadUrl;
        }

        public void setByReplyHeadUrl(Object byReplyHeadUrl) {
            this.byReplyHeadUrl = byReplyHeadUrl;
        }

        public Object getByReplyUserId() {
            return byReplyUserId;
        }

        public void setByReplyUserId(Object byReplyUserId) {
            this.byReplyUserId = byReplyUserId;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public boolean isReply() {
            return reply;
        }

        public void setReply(boolean reply) {
            this.reply = reply;
        }

        public boolean isReplyMake() {
            return replyMake;
        }

        public void setReplyMake(boolean replyMake) {
            this.replyMake = replyMake;
        }
    }
}
