package com.example.arttower.bean;

import java.util.List;

public class CollectBean {
    /**
     * code : 200000
     * msg : null
     * data : [{"id":"2","createTime":null,"updateTime":null,"createUser":null,"updateUser":null,"courseName":null,"courseRemark":null,"price":null,"beginTime":null,"endTime":null,"amount":null,"sellAmount":null,"chargeType":null,"weight":null,"coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","playCount":null,"evaluateCount":null,"courseLevel":null,"yptAuthenticationDO":null,"evaluateDOList":null,"yptCourseVideoDOList":null,"studyNum":null,"courseTeacherName":null,"courseTeacherHeadUrl":null,"isOverStudy":null,"courseTag":null,"createTime1":null,"itemId":null,"isLookCourseVideo":null,"praiseCourse":false,"collectCourse":false},{"id":"1","createTime":null,"updateTime":null,"createUser":null,"updateUser":null,"courseName":null,"courseRemark":null,"price":null,"beginTime":null,"endTime":null,"amount":null,"sellAmount":null,"chargeType":null,"weight":null,"coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","playCount":null,"evaluateCount":null,"courseLevel":null,"yptAuthenticationDO":null,"evaluateDOList":null,"yptCourseVideoDOList":null,"studyNum":null,"courseTeacherName":null,"courseTeacherHeadUrl":null,"isOverStudy":null,"courseTag":null,"createTime1":null,"itemId":null,"isLookCourseVideo":null,"praiseCourse":false,"collectCourse":false}]
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
         * id : 2
         * createTime : null
         * updateTime : null
         * createUser : null
         * updateUser : null
         * courseName : null
         * courseRemark : null
         * price : null
         * beginTime : null
         * endTime : null
         * amount : null
         * sellAmount : null
         * chargeType : null
         * weight : null
         * coverImg : http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png
         * playCount : null
         * evaluateCount : null
         * courseLevel : null
         * yptAuthenticationDO : null
         * evaluateDOList : null
         * yptCourseVideoDOList : null
         * studyNum : null
         * courseTeacherName : null
         * courseTeacherHeadUrl : null
         * isOverStudy : null
         * courseTag : null
         * createTime1 : null
         * itemId : null
         * isLookCourseVideo : null
         * praiseCourse : false
         * collectCourse : false
         */

        private String id;
        private Object createTime;
        private Object updateTime;
        private Object createUser;
        private Object updateUser;
        private Object courseName;
        private Object courseRemark;
        private Object price;
        private Object beginTime;
        private Object endTime;
        private Object amount;
        private Object sellAmount;
        private Object chargeType;
        private Object weight;
        private String coverImg;
        private Object playCount;
        private Object evaluateCount;
        private Object courseLevel;
        private Object yptAuthenticationDO;
        private Object evaluateDOList;
        private Object yptCourseVideoDOList;
        private Object studyNum;
        private Object courseTeacherName;
        private Object courseTeacherHeadUrl;
        private Object isOverStudy;
        private Object courseTag;
        private Object createTime1;
        private Object itemId;
        private Object isLookCourseVideo;
        private boolean praiseCourse;
        private boolean collectCourse;

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

        public Object getCourseName() {
            return courseName;
        }

        public void setCourseName(Object courseName) {
            this.courseName = courseName;
        }

        public Object getCourseRemark() {
            return courseRemark;
        }

        public void setCourseRemark(Object courseRemark) {
            this.courseRemark = courseRemark;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public Object getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(Object beginTime) {
            this.beginTime = beginTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

        public Object getSellAmount() {
            return sellAmount;
        }

        public void setSellAmount(Object sellAmount) {
            this.sellAmount = sellAmount;
        }

        public Object getChargeType() {
            return chargeType;
        }

        public void setChargeType(Object chargeType) {
            this.chargeType = chargeType;
        }

        public Object getWeight() {
            return weight;
        }

        public void setWeight(Object weight) {
            this.weight = weight;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public Object getPlayCount() {
            return playCount;
        }

        public void setPlayCount(Object playCount) {
            this.playCount = playCount;
        }

        public Object getEvaluateCount() {
            return evaluateCount;
        }

        public void setEvaluateCount(Object evaluateCount) {
            this.evaluateCount = evaluateCount;
        }

        public Object getCourseLevel() {
            return courseLevel;
        }

        public void setCourseLevel(Object courseLevel) {
            this.courseLevel = courseLevel;
        }

        public Object getYptAuthenticationDO() {
            return yptAuthenticationDO;
        }

        public void setYptAuthenticationDO(Object yptAuthenticationDO) {
            this.yptAuthenticationDO = yptAuthenticationDO;
        }

        public Object getEvaluateDOList() {
            return evaluateDOList;
        }

        public void setEvaluateDOList(Object evaluateDOList) {
            this.evaluateDOList = evaluateDOList;
        }

        public Object getYptCourseVideoDOList() {
            return yptCourseVideoDOList;
        }

        public void setYptCourseVideoDOList(Object yptCourseVideoDOList) {
            this.yptCourseVideoDOList = yptCourseVideoDOList;
        }

        public Object getStudyNum() {
            return studyNum;
        }

        public void setStudyNum(Object studyNum) {
            this.studyNum = studyNum;
        }

        public Object getCourseTeacherName() {
            return courseTeacherName;
        }

        public void setCourseTeacherName(Object courseTeacherName) {
            this.courseTeacherName = courseTeacherName;
        }

        public Object getCourseTeacherHeadUrl() {
            return courseTeacherHeadUrl;
        }

        public void setCourseTeacherHeadUrl(Object courseTeacherHeadUrl) {
            this.courseTeacherHeadUrl = courseTeacherHeadUrl;
        }

        public Object getIsOverStudy() {
            return isOverStudy;
        }

        public void setIsOverStudy(Object isOverStudy) {
            this.isOverStudy = isOverStudy;
        }

        public Object getCourseTag() {
            return courseTag;
        }

        public void setCourseTag(Object courseTag) {
            this.courseTag = courseTag;
        }

        public Object getCreateTime1() {
            return createTime1;
        }

        public void setCreateTime1(Object createTime1) {
            this.createTime1 = createTime1;
        }

        public Object getItemId() {
            return itemId;
        }

        public void setItemId(Object itemId) {
            this.itemId = itemId;
        }

        public Object getIsLookCourseVideo() {
            return isLookCourseVideo;
        }

        public void setIsLookCourseVideo(Object isLookCourseVideo) {
            this.isLookCourseVideo = isLookCourseVideo;
        }

        public boolean isPraiseCourse() {
            return praiseCourse;
        }

        public void setPraiseCourse(boolean praiseCourse) {
            this.praiseCourse = praiseCourse;
        }

        public boolean isCollectCourse() {
            return collectCourse;
        }

        public void setCollectCourse(boolean collectCourse) {
            this.collectCourse = collectCourse;
        }
    }
}
