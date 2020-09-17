package com.example.arttower.fragment.LocalPage.bean;

import java.util.List;

public class TeacherCouserBean {

    /**
     * code : 200000
     * msg : null
     * data : [{"id":"1006","createTime":"2020-07-08 15:51:37","updateTime":"2020-08-24 18:08:50","createUser":"1","updateUser":null,"courseName":"测试课程1006","courseRemark":"这是一个超高质量的课程，价格实惠。","price":98888,"originalPrice":null,"beginTime":"2020-07-24","endTime":null,"amount":10000,"sellAmount":"5","chargeType":null,"courseType":"3","weight":"3","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","isVisible":"2","playCount":null,"evaluateCount":null,"courseLevel":null,"yptAuthenticationDO":null,"evaluateDOList":null,"yptCourseVideoDOList":null,"studyNum":null,"courseTeacherName":"姚老师","courseTeacherHeadUrl":"http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg","isOverStudy":null,"courseTag":"民族舞","createTime1":null,"itemId":null,"isLookCourseVideo":null,"praiseCourse":false,"collectCourse":false}]
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
         * id : 1006
         * createTime : 2020-07-08 15:51:37
         * updateTime : 2020-08-24 18:08:50
         * createUser : 1
         * updateUser : null
         * courseName : 测试课程1006
         * courseRemark : 这是一个超高质量的课程，价格实惠。
         * price : 98888
         * originalPrice : null
         * beginTime : 2020-07-24
         * endTime : null
         * amount : 10000
         * sellAmount : 5
         * chargeType : null
         * courseType : 3
         * weight : 3
         * coverImg : http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png
         * isVisible : 2
         * playCount : null
         * evaluateCount : null
         * courseLevel : null
         * yptAuthenticationDO : null
         * evaluateDOList : null
         * yptCourseVideoDOList : null
         * studyNum : null
         * courseTeacherName : 姚老师
         * courseTeacherHeadUrl : http://vod.tingwu365.com/7906c981f06d41c9952fde1b1ca6722b/snapshots/3445b5f78b0f45afb603a90a1c568727-00001.jpg
         * isOverStudy : null
         * courseTag : 民族舞
         * createTime1 : null
         * itemId : null
         * isLookCourseVideo : null
         * praiseCourse : false
         * collectCourse : false
         */

        private String id;
        private String createTime;
        private String updateTime;
        private String createUser;
        private Object updateUser;
        private String courseName;
        private String courseRemark;
        private int price;
        private Object originalPrice;
        private String beginTime;
        private Object endTime;
        private int amount;
        private String sellAmount;
        private Object chargeType;
        private String courseType;
        private String weight;
        private String coverImg;
        private String isVisible;
        private Object playCount;
        private Object evaluateCount;
        private Object courseLevel;
        private Object yptAuthenticationDO;
        private Object evaluateDOList;
        private Object yptCourseVideoDOList;
        private Object studyNum;
        private String courseTeacherName;
        private String courseTeacherHeadUrl;
        private Object isOverStudy;
        private String courseTag;
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

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseRemark() {
            return courseRemark;
        }

        public void setCourseRemark(String courseRemark) {
            this.courseRemark = courseRemark;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Object getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(Object originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getSellAmount() {
            return sellAmount;
        }

        public void setSellAmount(String sellAmount) {
            this.sellAmount = sellAmount;
        }

        public Object getChargeType() {
            return chargeType;
        }

        public void setChargeType(Object chargeType) {
            this.chargeType = chargeType;
        }

        public String getCourseType() {
            return courseType;
        }

        public void setCourseType(String courseType) {
            this.courseType = courseType;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public String getIsVisible() {
            return isVisible;
        }

        public void setIsVisible(String isVisible) {
            this.isVisible = isVisible;
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

        public String getCourseTeacherName() {
            return courseTeacherName;
        }

        public void setCourseTeacherName(String courseTeacherName) {
            this.courseTeacherName = courseTeacherName;
        }

        public String getCourseTeacherHeadUrl() {
            return courseTeacherHeadUrl;
        }

        public void setCourseTeacherHeadUrl(String courseTeacherHeadUrl) {
            this.courseTeacherHeadUrl = courseTeacherHeadUrl;
        }

        public Object getIsOverStudy() {
            return isOverStudy;
        }

        public void setIsOverStudy(Object isOverStudy) {
            this.isOverStudy = isOverStudy;
        }

        public String getCourseTag() {
            return courseTag;
        }

        public void setCourseTag(String courseTag) {
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
