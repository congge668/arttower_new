package com.example.arttower.bean;

import java.util.List;

public class CouserDetailsBean {

    /**
     * code : 200000
     * msg : null
     * data : {"id":"1080","createTime":"2020-07-08 15:51:38","updateTime":"2020-09-08 15:07:17","createUser":"1080","updateUser":null,"courseName":"测试课程1080","courseRemark":"这是一个超高质量的课程，价格实惠。","price":98,"originalPrice":null,"beginTime":"2020-07-24","endTime":null,"amount":10000,"sellAmount":"51","chargeType":null,"courseType":null,"weight":"10","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","isVisible":null,"playCount":88,"evaluateCount":null,"commentCount":2,"courseLevel":null,"yptAuthenticationDO":{"id":"1080","createTime":"2020-07-08 15:10:45","updateTime":"2020-08-17 10:55:50","createUser":"1","updateUser":null,"uid":"1080","idCardName":"yaoshuli1080","englishName":null,"sex":null,"age":null,"teachingTime":null,"teachingOnline":null,"personalIp":null,"salary":null,"courseRelease":null,"introduction":null,"tqcNo":null,"tqcImg":null,"authenticationMobile":null,"authenticationEmail":null,"tqcInstitutions":null,"tqcLevel":null,"personalFeatures":null,"inviter":null,"idCard":"123456789123456789","diploma":"麻省理工学院","degree":"博士","diplomaNo":"10000000000","diplomaImgUrl":"http://vod.tingwu365.com/image/default/EDD4C0EE93944515B9D323319FB33090-6-2.png","authenticationType":"TEACHER","remark":"ahahahahah","isGreatMaster":null,"isAuthenticationEnum":"AUTHENTICATION","authenticationResultDetails":null,"companyName":null,"companyNo":null,"distance":null,"score":"5"},"courseEvaluations":[],"yptCourseVideoDOList":[{"id":"5396","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5396","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":true},{"id":"5397","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5397","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":false},{"id":"5398","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5398","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":false},{"id":"5399","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5399","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":false},{"id":"5400","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5400","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":false}],"studyNum":null,"courseTeacherName":null,"courseTeacherHeadUrl":null,"isOverStudy":null,"courseTag":null,"createTime1":null,"itemId":null,"isLookCourseVideo":false,"gradeLevelId":null,"isFocus":"0","praiseCourse":false}
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
         * id : 1080
         * createTime : 2020-07-08 15:51:38
         * updateTime : 2020-09-08 15:07:17
         * createUser : 1080
         * updateUser : null
         * courseName : 测试课程1080
         * courseRemark : 这是一个超高质量的课程，价格实惠。
         * price : 98
         * originalPrice : null
         * beginTime : 2020-07-24
         * endTime : null
         * amount : 10000
         * sellAmount : 51
         * chargeType : null
         * courseType : null
         * weight : 10
         * coverImg : http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png
         * isVisible : null
         * playCount : 88
         * evaluateCount : null
         * commentCount : 2
         * courseLevel : null
         * yptAuthenticationDO : {"id":"1080","createTime":"2020-07-08 15:10:45","updateTime":"2020-08-17 10:55:50","createUser":"1","updateUser":null,"uid":"1080","idCardName":"yaoshuli1080","englishName":null,"sex":null,"age":null,"teachingTime":null,"teachingOnline":null,"personalIp":null,"salary":null,"courseRelease":null,"introduction":null,"tqcNo":null,"tqcImg":null,"authenticationMobile":null,"authenticationEmail":null,"tqcInstitutions":null,"tqcLevel":null,"personalFeatures":null,"inviter":null,"idCard":"123456789123456789","diploma":"麻省理工学院","degree":"博士","diplomaNo":"10000000000","diplomaImgUrl":"http://vod.tingwu365.com/image/default/EDD4C0EE93944515B9D323319FB33090-6-2.png","authenticationType":"TEACHER","remark":"ahahahahah","isGreatMaster":null,"isAuthenticationEnum":"AUTHENTICATION","authenticationResultDetails":null,"companyName":null,"companyNo":null,"distance":null,"score":"5"}
         * courseEvaluations : []
         * yptCourseVideoDOList : [{"id":"5396","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5396","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":true},{"id":"5397","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5397","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":false},{"id":"5398","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5398","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":false},{"id":"5399","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5399","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":false},{"id":"5400","createTime":"2020-07-08 15:51:38","updateTime":"2020-07-31 15:38:31","createUser":"1080","updateUser":null,"videoName":"课程视频5400","videoUrl":"http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","courseId":"1080","videoTime":"00:18","collectCourseVideo":false}]
         * studyNum : null
         * courseTeacherName : null
         * courseTeacherHeadUrl : null
         * isOverStudy : null
         * courseTag : null
         * createTime1 : null
         * itemId : null
         * isLookCourseVideo : false
         * gradeLevelId : null
         * isFocus : 0
         * praiseCourse : false
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
        private Object courseType;
        private String weight;
        private String coverImg;
        private Object isVisible;
        private int playCount;
        private Object evaluateCount;
        private int commentCount;
        private Object courseLevel;
        private YptAuthenticationDOBean yptAuthenticationDO;
        private Object studyNum;
        private Object courseTeacherName;
        private Object courseTeacherHeadUrl;
        private Object isOverStudy;
        private Object courseTag;
        private Object createTime1;
        private Object itemId;
        private boolean isLookCourseVideo;
        private Object gradeLevelId;
        private String isFocus;
        private boolean praiseCourse;
        private List<?> courseEvaluations;
        private List<YptCourseVideoDOListBean> yptCourseVideoDOList;

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

        public Object getCourseType() {
            return courseType;
        }

        public void setCourseType(Object courseType) {
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

        public Object getIsVisible() {
            return isVisible;
        }

        public void setIsVisible(Object isVisible) {
            this.isVisible = isVisible;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public Object getEvaluateCount() {
            return evaluateCount;
        }

        public void setEvaluateCount(Object evaluateCount) {
            this.evaluateCount = evaluateCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public Object getCourseLevel() {
            return courseLevel;
        }

        public void setCourseLevel(Object courseLevel) {
            this.courseLevel = courseLevel;
        }

        public YptAuthenticationDOBean getYptAuthenticationDO() {
            return yptAuthenticationDO;
        }

        public void setYptAuthenticationDO(YptAuthenticationDOBean yptAuthenticationDO) {
            this.yptAuthenticationDO = yptAuthenticationDO;
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

        public boolean isIsLookCourseVideo() {
            return isLookCourseVideo;
        }

        public void setIsLookCourseVideo(boolean isLookCourseVideo) {
            this.isLookCourseVideo = isLookCourseVideo;
        }

        public Object getGradeLevelId() {
            return gradeLevelId;
        }

        public void setGradeLevelId(Object gradeLevelId) {
            this.gradeLevelId = gradeLevelId;
        }

        public String getIsFocus() {
            return isFocus;
        }

        public void setIsFocus(String isFocus) {
            this.isFocus = isFocus;
        }

        public boolean isPraiseCourse() {
            return praiseCourse;
        }

        public void setPraiseCourse(boolean praiseCourse) {
            this.praiseCourse = praiseCourse;
        }

        public Object getPraiseCourse() {
            return praiseCourse;
        }

        public List<?> getCourseEvaluations() {
            return courseEvaluations;
        }

        public void setCourseEvaluations(List<?> courseEvaluations) {
            this.courseEvaluations = courseEvaluations;
        }

        public List<YptCourseVideoDOListBean> getYptCourseVideoDOList() {
            return yptCourseVideoDOList;
        }

        public void setYptCourseVideoDOList(List<YptCourseVideoDOListBean> yptCourseVideoDOList) {
            this.yptCourseVideoDOList = yptCourseVideoDOList;
        }

        public static class YptAuthenticationDOBean {
            /**
             * id : 1080
             * createTime : 2020-07-08 15:10:45
             * updateTime : 2020-08-17 10:55:50
             * createUser : 1
             * updateUser : null
             * uid : 1080
             * idCardName : yaoshuli1080
             * englishName : null
             * sex : null
             * age : null
             * teachingTime : null
             * teachingOnline : null
             * personalIp : null
             * salary : null
             * courseRelease : null
             * introduction : null
             * tqcNo : null
             * tqcImg : null
             * authenticationMobile : null
             * authenticationEmail : null
             * tqcInstitutions : null
             * tqcLevel : null
             * personalFeatures : null
             * inviter : null
             * idCard : 123456789123456789
             * diploma : 麻省理工学院
             * degree : 博士
             * diplomaNo : 10000000000
             * diplomaImgUrl : http://vod.tingwu365.com/image/default/EDD4C0EE93944515B9D323319FB33090-6-2.png
             * authenticationType : TEACHER
             * remark : ahahahahah
             * isGreatMaster : null
             * isAuthenticationEnum : AUTHENTICATION
             * authenticationResultDetails : null
             * companyName : null
             * companyNo : null
             * distance : null
             * score : 5
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private Object updateUser;
            private String uid;
            private String idCardName;
            private Object englishName;
            private Object sex;
            private Object age;
            private Object teachingTime;
            private Object teachingOnline;
            private Object personalIp;
            private Object salary;
            private Object courseRelease;
            private Object introduction;
            private Object tqcNo;
            private Object tqcImg;
            private Object authenticationMobile;
            private Object authenticationEmail;
            private Object tqcInstitutions;
            private Object tqcLevel;
            private Object personalFeatures;
            private Object inviter;
            private String idCard;
            private String diploma;
            private String degree;
            private String diplomaNo;
            private String diplomaImgUrl;
            private String authenticationType;
            private String remark;
            private Object isGreatMaster;
            private String isAuthenticationEnum;
            private Object authenticationResultDetails;
            private Object companyName;
            private Object companyNo;
            private Object distance;
            private String score;

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

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getIdCardName() {
                return idCardName;
            }

            public void setIdCardName(String idCardName) {
                this.idCardName = idCardName;
            }

            public Object getEnglishName() {
                return englishName;
            }

            public void setEnglishName(Object englishName) {
                this.englishName = englishName;
            }

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public Object getTeachingTime() {
                return teachingTime;
            }

            public void setTeachingTime(Object teachingTime) {
                this.teachingTime = teachingTime;
            }

            public Object getTeachingOnline() {
                return teachingOnline;
            }

            public void setTeachingOnline(Object teachingOnline) {
                this.teachingOnline = teachingOnline;
            }

            public Object getPersonalIp() {
                return personalIp;
            }

            public void setPersonalIp(Object personalIp) {
                this.personalIp = personalIp;
            }

            public Object getSalary() {
                return salary;
            }

            public void setSalary(Object salary) {
                this.salary = salary;
            }

            public Object getCourseRelease() {
                return courseRelease;
            }

            public void setCourseRelease(Object courseRelease) {
                this.courseRelease = courseRelease;
            }

            public Object getIntroduction() {
                return introduction;
            }

            public void setIntroduction(Object introduction) {
                this.introduction = introduction;
            }

            public Object getTqcNo() {
                return tqcNo;
            }

            public void setTqcNo(Object tqcNo) {
                this.tqcNo = tqcNo;
            }

            public Object getTqcImg() {
                return tqcImg;
            }

            public void setTqcImg(Object tqcImg) {
                this.tqcImg = tqcImg;
            }

            public Object getAuthenticationMobile() {
                return authenticationMobile;
            }

            public void setAuthenticationMobile(Object authenticationMobile) {
                this.authenticationMobile = authenticationMobile;
            }

            public Object getAuthenticationEmail() {
                return authenticationEmail;
            }

            public void setAuthenticationEmail(Object authenticationEmail) {
                this.authenticationEmail = authenticationEmail;
            }

            public Object getTqcInstitutions() {
                return tqcInstitutions;
            }

            public void setTqcInstitutions(Object tqcInstitutions) {
                this.tqcInstitutions = tqcInstitutions;
            }

            public Object getTqcLevel() {
                return tqcLevel;
            }

            public void setTqcLevel(Object tqcLevel) {
                this.tqcLevel = tqcLevel;
            }

            public Object getPersonalFeatures() {
                return personalFeatures;
            }

            public void setPersonalFeatures(Object personalFeatures) {
                this.personalFeatures = personalFeatures;
            }

            public Object getInviter() {
                return inviter;
            }

            public void setInviter(Object inviter) {
                this.inviter = inviter;
            }

            public String getIdCard() {
                return idCard;
            }

            public void setIdCard(String idCard) {
                this.idCard = idCard;
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

            public String getDiplomaNo() {
                return diplomaNo;
            }

            public void setDiplomaNo(String diplomaNo) {
                this.diplomaNo = diplomaNo;
            }

            public String getDiplomaImgUrl() {
                return diplomaImgUrl;
            }

            public void setDiplomaImgUrl(String diplomaImgUrl) {
                this.diplomaImgUrl = diplomaImgUrl;
            }

            public String getAuthenticationType() {
                return authenticationType;
            }

            public void setAuthenticationType(String authenticationType) {
                this.authenticationType = authenticationType;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public Object getIsGreatMaster() {
                return isGreatMaster;
            }

            public void setIsGreatMaster(Object isGreatMaster) {
                this.isGreatMaster = isGreatMaster;
            }

            public String getIsAuthenticationEnum() {
                return isAuthenticationEnum;
            }

            public void setIsAuthenticationEnum(String isAuthenticationEnum) {
                this.isAuthenticationEnum = isAuthenticationEnum;
            }

            public Object getAuthenticationResultDetails() {
                return authenticationResultDetails;
            }

            public void setAuthenticationResultDetails(Object authenticationResultDetails) {
                this.authenticationResultDetails = authenticationResultDetails;
            }

            public Object getCompanyName() {
                return companyName;
            }

            public void setCompanyName(Object companyName) {
                this.companyName = companyName;
            }

            public Object getCompanyNo() {
                return companyNo;
            }

            public void setCompanyNo(Object companyNo) {
                this.companyNo = companyNo;
            }

            public Object getDistance() {
                return distance;
            }

            public void setDistance(Object distance) {
                this.distance = distance;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }
        }

        public static class YptCourseVideoDOListBean {
            /**
             * id : 5396
             * createTime : 2020-07-08 15:51:38
             * updateTime : 2020-07-31 15:38:31
             * createUser : 1080
             * updateUser : null
             * videoName : 课程视频5396
             * videoUrl : http://vod.tingwu365.com/sv/515e6907-1735215d2f9/515e6907-1735215d2f9.mp4
             * coverImg : http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png
             * courseId : 1080
             * videoTime : 00:18
             * collectCourseVideo : true
             */

            private String id;
            private String createTime;
            private String updateTime;
            private String createUser;
            private Object updateUser;
            private String videoName;
            private String videoUrl;
            private String coverImg;
            private String courseId;
            private String videoTime;
            private boolean collectCourseVideo;

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

            public String getVideoName() {
                return videoName;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
            }

            public String getCourseId() {
                return courseId;
            }

            public void setCourseId(String courseId) {
                this.courseId = courseId;
            }

            public String getVideoTime() {
                return videoTime;
            }

            public void setVideoTime(String videoTime) {
                this.videoTime = videoTime;
            }

            public boolean isCollectCourseVideo() {
                return collectCourseVideo;
            }

            public void setCollectCourseVideo(boolean collectCourseVideo) {
                this.collectCourseVideo = collectCourseVideo;
            }

            public Object getCollectCourseVideo() {
                return collectCourseVideo;
            }
        }
    }
}
