package com.example.arttower.fragment.LocalPage.bean;

import java.util.List;

public class InlandTeacherBean {


    /**
     * code : 200000
     * msg :
     * data : [{"idCardName":"姚老师","englishName":null,"sex":null,"age":null,"teachingTime":null,"teachingOnline":null,"personalIp":null,"salary":null,"courseRelease":null,"introduction":null,"tqcNo":null,"tqcImg":null,"mobile":null,"mobileCode":null,"email":null,"tqcInstitutions":null,"tqcLevel":null,"personalFeatures":null,"idCard":null,"diploma":"麻省理工学院","diplomaNo":null,"diplomaImgUrl":"http://vod.tingwu365.com/image/default/4A5FE410E795400F9C399D87D313D3CE-6-2.png","degree":"硕士","remark":"姚老师是麻省理工学院著名艺术教师，拥有多线教学经验，培养了无数的优秀学生。","score":"5","distance":"0.0000","beginDate":null,"endDate":null,"experienceContent":null,"achievementsContent":null,"uid":"1"},{"idCardName":"张老师","englishName":null,"sex":null,"age":null,"teachingTime":null,"teachingOnline":null,"personalIp":null,"salary":null,"courseRelease":null,"introduction":null,"tqcNo":null,"tqcImg":null,"mobile":null,"mobileCode":null,"email":null,"tqcInstitutions":null,"tqcLevel":null,"personalFeatures":null,"idCard":null,"diploma":"北京电影学院","diplomaNo":null,"diplomaImgUrl":"http://vod.tingwu365.com/image/default/3F1728014D3C474C9124950AADB22840-6-2.png","degree":"硕士","remark":"张老师是麻省理工学院著名艺术教师，拥有多线教学经验，培养了无数的优秀学生。","score":"5","distance":"0.0000","beginDate":null,"endDate":null,"experienceContent":null,"achievementsContent":null,"uid":"10"},{"idCardName":"王老师","englishName":null,"sex":null,"age":null,"teachingTime":null,"teachingOnline":null,"personalIp":null,"salary":null,"courseRelease":null,"introduction":null,"tqcNo":null,"tqcImg":null,"mobile":null,"mobileCode":null,"email":null,"tqcInstitutions":null,"tqcLevel":null,"personalFeatures":null,"idCard":null,"diploma":"中央戏剧学院","diplomaNo":null,"diplomaImgUrl":"http://vod.tingwu365.com/image/default/CA26576E7B22423DA1DE386E2A18A6A4-6-2.png","degree":"硕士","remark":"王老师是麻省理工学院著名艺术教师，拥有多线教学经验，培养了无数的优秀学生。","score":"5","distance":"0.0000","beginDate":null,"endDate":null,"experienceContent":null,"achievementsContent":null,"uid":"100"},{"idCardName":"郑老师","englishName":null,"sex":null,"age":null,"teachingTime":null,"teachingOnline":null,"personalIp":null,"salary":null,"courseRelease":null,"introduction":null,"tqcNo":null,"tqcImg":null,"mobile":null,"mobileCode":null,"email":null,"tqcInstitutions":null,"tqcLevel":null,"personalFeatures":null,"idCard":null,"diploma":"北京电影学院","diplomaNo":null,"diplomaImgUrl":"http://vod.tingwu365.com/image/default/64C76783062C4822B4F028F05141F95F-6-2.png","degree":"硕士","remark":"郑老师是麻省理工学院著名艺术教师，拥有多线教学经验，培养了无数的优秀学生。","score":"5","distance":"0.0000","beginDate":null,"endDate":null,"experienceContent":null,"achievementsContent":null,"uid":"1000"},{"idCardName":"黄老师","englishName":null,"sex":null,"age":null,"teachingTime":null,"teachingOnline":null,"personalIp":null,"salary":null,"courseRelease":null,"introduction":null,"tqcNo":null,"tqcImg":null,"mobile":null,"mobileCode":null,"email":null,"tqcInstitutions":null,"tqcLevel":null,"personalFeatures":null,"idCard":null,"diploma":"上海戏剧学院","diplomaNo":null,"diplomaImgUrl":"http://vod.tingwu365.com/image/default/5D04E420A8BB499EAC3625BF2767C728-6-2.png","degree":"硕士","remark":"黄老师是麻省理工学院著名艺术教师，拥有多线教学经验，培养了无数的优秀学生。","score":"5","distance":"0.0000","beginDate":null,"endDate":null,"experienceContent":null,"achievementsContent":null,"uid":"1001"}]
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
         * idCardName : 姚老师
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
         * mobile : null
         * mobileCode : null
         * email : null
         * tqcInstitutions : null
         * tqcLevel : null
         * personalFeatures : null
         * idCard : null
         * diploma : 麻省理工学院
         * diplomaNo : null
         * diplomaImgUrl : http://vod.tingwu365.com/image/default/4A5FE410E795400F9C399D87D313D3CE-6-2.png
         * degree : 硕士
         * remark : 姚老师是麻省理工学院著名艺术教师，拥有多线教学经验，培养了无数的优秀学生。
         * score : 5
         * distance : 0.0000
         * beginDate : null
         * endDate : null
         * experienceContent : null
         * achievementsContent : null
         * uid : 1
         */

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
        private Object mobile;
        private Object mobileCode;
        private Object email;
        private Object tqcInstitutions;
        private Object tqcLevel;
        private Object personalFeatures;
        private Object idCard;
        private String diploma;
        private Object diplomaNo;
        private String diplomaImgUrl;
        private String degree;
        private String remark;
        private String score;
        private String distance;
        private Object beginDate;
        private Object endDate;
        private Object experienceContent;
        private Object achievementsContent;
        private String uid;

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

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getMobileCode() {
            return mobileCode;
        }

        public void setMobileCode(Object mobileCode) {
            this.mobileCode = mobileCode;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
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

        public Object getIdCard() {
            return idCard;
        }

        public void setIdCard(Object idCard) {
            this.idCard = idCard;
        }

        public String getDiploma() {
            return diploma;
        }

        public void setDiploma(String diploma) {
            this.diploma = diploma;
        }

        public Object getDiplomaNo() {
            return diplomaNo;
        }

        public void setDiplomaNo(Object diplomaNo) {
            this.diplomaNo = diplomaNo;
        }

        public String getDiplomaImgUrl() {
            return diplomaImgUrl;
        }

        public void setDiplomaImgUrl(String diplomaImgUrl) {
            this.diplomaImgUrl = diplomaImgUrl;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public Object getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Object beginDate) {
            this.beginDate = beginDate;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public Object getExperienceContent() {
            return experienceContent;
        }

        public void setExperienceContent(Object experienceContent) {
            this.experienceContent = experienceContent;
        }

        public Object getAchievementsContent() {
            return achievementsContent;
        }

        public void setAchievementsContent(Object achievementsContent) {
            this.achievementsContent = achievementsContent;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}


