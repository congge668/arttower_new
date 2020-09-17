package com.example.arttower.bean;

import java.util.List;

public class TeacherAnswerBean {

    /**
     * code : 200000
     * msg : null
     * data : [{"yptCourseQuestionsDO":{"id":"15983216257451734146237632679820","createTime":"2020-08-25 10:13:46","updateTime":"2020-08-25 10:13:46","createUser":"1","updateUser":"1","uid":"10","content":"迈克尔杰克逊跳舞很棒5~！","isAnonymity":"0","status":"1","userHeadUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg","userName":"用户"},"courseQuestionImgDO":[{"id":"15983216257641734146237685749257","createTime":"2020-08-25 10:13:46","updateTime":"2020-08-25 10:13:46","createUser":"1","updateUser":"1","questionReplyId":"15983216257451734146237632679820","imgUrl":"111111.jpg","status":"1"}],"yptCourseQuestionsReplyDO":{"id":"15983225274321734146214752056634","createTime":"2020-08-25 10:28:47","updateTime":"2020-08-25 10:28:47","createUser":"10","updateUser":"10","questionsId":"15983216257451734146237632679820","replyContent":"迈克尔确实厉害","status":"1","teacherHeadUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg","teacherName":"姚老师"},"courseQuestionReplyImgDO":null,"dateTime":"8月25日"}]
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
         * yptCourseQuestionsDO : {"id":"15983216257451734146237632679820","createTime":"2020-08-25 10:13:46","updateTime":"2020-08-25 10:13:46","createUser":"1","updateUser":"1","uid":"10","content":"迈克尔杰克逊跳舞很棒5~！","isAnonymity":"0","status":"1","userHeadUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg","userName":"用户"}
         * courseQuestionImgDO : [{"id":"15983216257641734146237685749257","createTime":"2020-08-25 10:13:46","updateTime":"2020-08-25 10:13:46","createUser":"1","updateUser":"1","questionReplyId":"15983216257451734146237632679820","imgUrl":"111111.jpg","status":"1"}]
         * yptCourseQuestionsReplyDO : {"id":"15983225274321734146214752056634","createTime":"2020-08-25 10:28:47","updateTime":"2020-08-25 10:28:47","createUser":"10","updateUser":"10","questionsId":"15983216257451734146237632679820","replyContent":"迈克尔确实厉害","status":"1","teacherHeadUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg","teacherName":"姚老师"}
         * courseQuestionReplyImgDO : null
         * dateTime : 8月25日
         */

        private YptCourseQuestionsDOBean yptCourseQuestionsDO;
        private YptCourseQuestionsReplyDOBean yptCourseQuestionsReplyDO;
        private Object courseQuestionReplyImgDO;
        private String dateTime;
        private List<CourseQuestionImgDOBean> courseQuestionImgDO;

        public YptCourseQuestionsDOBean getYptCourseQuestionsDO() {
            return yptCourseQuestionsDO;
        }

        public void setYptCourseQuestionsDO(YptCourseQuestionsDOBean yptCourseQuestionsDO) {
            this.yptCourseQuestionsDO = yptCourseQuestionsDO;
        }

        public YptCourseQuestionsReplyDOBean getYptCourseQuestionsReplyDO() {
            return yptCourseQuestionsReplyDO;
        }

        public void setYptCourseQuestionsReplyDO(YptCourseQuestionsReplyDOBean yptCourseQuestionsReplyDO) {
            this.yptCourseQuestionsReplyDO = yptCourseQuestionsReplyDO;
        }

        public Object getCourseQuestionReplyImgDO() {
            return courseQuestionReplyImgDO;
        }

        public void setCourseQuestionReplyImgDO(Object courseQuestionReplyImgDO) {
            this.courseQuestionReplyImgDO = courseQuestionReplyImgDO;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public List<CourseQuestionImgDOBean> getCourseQuestionImgDO() {
            return courseQuestionImgDO;
        }

        public void setCourseQuestionImgDO(List<CourseQuestionImgDOBean> courseQuestionImgDO) {
            this.courseQuestionImgDO = courseQuestionImgDO;
        }

        public static class YptCourseQuestionsDOBean {
            /**
             * id : 15983216257451734146237632679820
             * createTime : 2020-08-25 10:13:46
             * updateTime : 2020-08-25 10:13:46
             * createUser : 1
             * updateUser : 1
             * uid : 10
             * content : 迈克尔杰克逊跳舞很棒5~！
             * isAnonymity : 0
             * status : 1
             * userHeadUrl : http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg
             * userName : 用户
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private String updateUser;
            private String uid;
            private String content;
            private String isAnonymity;
            private String status;
            private String userHeadUrl;
            private String userName;

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

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getIsAnonymity() {
                return isAnonymity;
            }

            public void setIsAnonymity(String isAnonymity) {
                this.isAnonymity = isAnonymity;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUserHeadUrl() {
                return userHeadUrl;
            }

            public void setUserHeadUrl(String userHeadUrl) {
                this.userHeadUrl = userHeadUrl;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }
        }

        public static class YptCourseQuestionsReplyDOBean {
            /**
             * id : 15983225274321734146214752056634
             * createTime : 2020-08-25 10:28:47
             * updateTime : 2020-08-25 10:28:47
             * createUser : 10
             * updateUser : 10
             * questionsId : 15983216257451734146237632679820
             * replyContent : 迈克尔确实厉害
             * status : 1
             * teacherHeadUrl : http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg
             * teacherName : 姚老师
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private String updateUser;
            private String questionsId;
            private String replyContent;
            private String status;
            private String teacherHeadUrl;
            private String teacherName;

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

            public String getQuestionsId() {
                return questionsId;
            }

            public void setQuestionsId(String questionsId) {
                this.questionsId = questionsId;
            }

            public String getReplyContent() {
                return replyContent;
            }

            public void setReplyContent(String replyContent) {
                this.replyContent = replyContent;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTeacherHeadUrl() {
                return teacherHeadUrl;
            }

            public void setTeacherHeadUrl(String teacherHeadUrl) {
                this.teacherHeadUrl = teacherHeadUrl;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }
        }

        public static class CourseQuestionImgDOBean {
            /**
             * id : 15983216257641734146237685749257
             * createTime : 2020-08-25 10:13:46
             * updateTime : 2020-08-25 10:13:46
             * createUser : 1
             * updateUser : 1
             * questionReplyId : 15983216257451734146237632679820
             * imgUrl : 111111.jpg
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
