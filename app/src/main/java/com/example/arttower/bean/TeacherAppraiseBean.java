package com.example.arttower.bean;

import java.util.List;

public class TeacherAppraiseBean {
    /**
     * code : 200000
     * msg : null
     * data : [{"headUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg","userName":"用户","yptCommonTagDOList":[{"id":"1","createTime":"2020-08-19 17:53:07","updateTime":"2020-08-19 17:53:08","createUser":"1","updateUser":"1","tagName":"1","type":"1","tagImgurl":"1"},{"id":"2","createTime":"2020-08-19 17:53:30","updateTime":"2020-08-19 17:53:36","createUser":"2","updateUser":"2","tagName":"2","type":"1","tagImgurl":"2"},{"id":"3","createTime":"2020-08-19 17:53:31","updateTime":"2020-08-19 17:53:38","createUser":"3","updateUser":"3","tagName":"3","type":"1","tagImgurl":"3"}],"content":"北京的舞蹈教的不错","dateTime":"8月25日","yptCourseQuestionsImgDOList":[{"id":"15983348929451734155110034591130","createTime":"2020-08-25 13:54:53","updateTime":"2020-08-25 13:54:53","createUser":"1","updateUser":"1","questionReplyId":"15983348928751734155110034503033","imgUrl":"zzzzz.jpg","status":"1"},{"id":"15983348929611734155110069920334","createTime":"2020-08-25 13:54:53","updateTime":"2020-08-25 13:54:53","createUser":"1","updateUser":"1","questionReplyId":"15983348928751734155110034503033","imgUrl":"zzzzz.jpg","status":"1"}],"courseName":"测试课程10"}]
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
         * headUrl : http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg
         * userName : 用户
         * yptCommonTagDOList : [{"id":"1","createTime":"2020-08-19 17:53:07","updateTime":"2020-08-19 17:53:08","createUser":"1","updateUser":"1","tagName":"1","type":"1","tagImgurl":"1"},{"id":"2","createTime":"2020-08-19 17:53:30","updateTime":"2020-08-19 17:53:36","createUser":"2","updateUser":"2","tagName":"2","type":"1","tagImgurl":"2"},{"id":"3","createTime":"2020-08-19 17:53:31","updateTime":"2020-08-19 17:53:38","createUser":"3","updateUser":"3","tagName":"3","type":"1","tagImgurl":"3"}]
         * content : 北京的舞蹈教的不错
         * dateTime : 8月25日
         * yptCourseQuestionsImgDOList : [{"id":"15983348929451734155110034591130","createTime":"2020-08-25 13:54:53","updateTime":"2020-08-25 13:54:53","createUser":"1","updateUser":"1","questionReplyId":"15983348928751734155110034503033","imgUrl":"zzzzz.jpg","status":"1"},{"id":"15983348929611734155110069920334","createTime":"2020-08-25 13:54:53","updateTime":"2020-08-25 13:54:53","createUser":"1","updateUser":"1","questionReplyId":"15983348928751734155110034503033","imgUrl":"zzzzz.jpg","status":"1"}]
         * courseName : 测试课程10
         */

        private String headUrl;
        private String userName;
        private String content;
        private String dateTime;
        private String courseName;
        private List<YptCommonTagDOListBean> yptCommonTagDOList;
        private List<YptCourseQuestionsImgDOListBean> yptCourseQuestionsImgDOList;

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public List<YptCommonTagDOListBean> getYptCommonTagDOList() {
            return yptCommonTagDOList;
        }

        public void setYptCommonTagDOList(List<YptCommonTagDOListBean> yptCommonTagDOList) {
            this.yptCommonTagDOList = yptCommonTagDOList;
        }

        public List<YptCourseQuestionsImgDOListBean> getYptCourseQuestionsImgDOList() {
            return yptCourseQuestionsImgDOList;
        }

        public void setYptCourseQuestionsImgDOList(List<YptCourseQuestionsImgDOListBean> yptCourseQuestionsImgDOList) {
            this.yptCourseQuestionsImgDOList = yptCourseQuestionsImgDOList;
        }

        public static class YptCommonTagDOListBean {
            /**
             * id : 1
             * createTime : 2020-08-19 17:53:07
             * updateTime : 2020-08-19 17:53:08
             * createUser : 1
             * updateUser : 1
             * tagName : 1
             * type : 1
             * tagImgurl : 1
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private String updateUser;
            private String tagName;
            private String type;
            private String tagImgurl;

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

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTagImgurl() {
                return tagImgurl;
            }

            public void setTagImgurl(String tagImgurl) {
                this.tagImgurl = tagImgurl;
            }
        }

        public static class YptCourseQuestionsImgDOListBean {
            /**
             * id : 15983348929451734155110034591130
             * createTime : 2020-08-25 13:54:53
             * updateTime : 2020-08-25 13:54:53
             * createUser : 1
             * updateUser : 1
             * questionReplyId : 15983348928751734155110034503033
             * imgUrl : zzzzz.jpg
             * status : 1
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private String updateUser;
            private String questionReplyId;
            private String imgUrl;
            private String status;

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

            public String getQuestionReplyId() {
                return questionReplyId;
            }

            public void setQuestionReplyId(String questionReplyId) {
                this.questionReplyId = questionReplyId;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
