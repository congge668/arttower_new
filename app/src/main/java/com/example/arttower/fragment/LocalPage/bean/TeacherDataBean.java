package com.example.arttower.fragment.LocalPage.bean;

public class TeacherDataBean {
    /**
     * code : 200000
     * msg : null
     * data : {"bigHeadUrl":"1234456","isFocus":"0","idCardName":"姚老师","diploma":"麻省理工学院","degree":"博士","introduction":"这个老师教的很好","tqcNo":"12306","yptTeachingExperienceDOList":null,"yptTeachingAchievementsDOList":null,"personalFeatures":"特色是教小孩","evaluateGrade":null}
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
         * bigHeadUrl : 1234456
         * isFocus : 0
         * idCardName : 姚老师
         * diploma : 麻省理工学院
         * degree : 博士
         * introduction : 这个老师教的很好
         * tqcNo : 12306
         * yptTeachingExperienceDOList : null
         * yptTeachingAchievementsDOList : null
         * personalFeatures : 特色是教小孩
         * evaluateGrade : null
         */

        private String bigHeadUrl;
        private String isFocus;
        private String idCardName;
        private String diploma;
        private String degree;
        private String introduction;
        private String tqcNo;
        private Object yptTeachingExperienceDOList;
        private Object yptTeachingAchievementsDOList;
        private String personalFeatures;
        private Object evaluateGrade;

        public String getBigHeadUrl() {
            return bigHeadUrl;
        }

        public void setBigHeadUrl(String bigHeadUrl) {
            this.bigHeadUrl = bigHeadUrl;
        }

        public String getIsFocus() {
            return isFocus;
        }

        public void setIsFocus(String isFocus) {
            this.isFocus = isFocus;
        }

        public String getIdCardName() {
            return idCardName;
        }

        public void setIdCardName(String idCardName) {
            this.idCardName = idCardName;
        }

        public String getDiploma() {
            return diploma;
        }

        public void setDiploma(String diploma) {
            this.diploma = diploma;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getTqcNo() {
            return tqcNo;
        }

        public void setTqcNo(String tqcNo) {
            this.tqcNo = tqcNo;
        }

        public Object getYptTeachingExperienceDOList() {
            return yptTeachingExperienceDOList;
        }

        public void setYptTeachingExperienceDOList(Object yptTeachingExperienceDOList) {
            this.yptTeachingExperienceDOList = yptTeachingExperienceDOList;
        }

        public Object getYptTeachingAchievementsDOList() {
            return yptTeachingAchievementsDOList;
        }

        public void setYptTeachingAchievementsDOList(Object yptTeachingAchievementsDOList) {
            this.yptTeachingAchievementsDOList = yptTeachingAchievementsDOList;
        }

        public String getPersonalFeatures() {
            return personalFeatures;
        }

        public void setPersonalFeatures(String personalFeatures) {
            this.personalFeatures = personalFeatures;
        }

        public Object getEvaluateGrade() {
            return evaluateGrade;
        }

        public void setEvaluateGrade(Object evaluateGrade) {
            this.evaluateGrade = evaluateGrade;
        }
    }
}
