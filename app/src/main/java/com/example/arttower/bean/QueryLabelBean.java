package com.example.arttower.bean;

import java.util.List;

public class QueryLabelBean {
    /**
     * code : 200000
     * msg : null
     * data : [{"id":"1","createTime":"2020-07-08 12:07:35","updateTime":"2020-08-10 16:20:42","createUser":"1","updateUser":null,"tagName":"民族舞","tagRemark":"民族舞简介......","tagImgUrl":"http://vod.tingwu365.com/image/default/4DA0631EF38B45FFA3D2189459055E9F-6-2.png","tagVideoNum":null,"studyNum":null,"coverImg":null,"higherId":"1","defHotTag":null},{"id":"2","createTime":"2020-07-08 12:07:45","updateTime":"2020-08-10 16:20:42","createUser":"1","updateUser":null,"tagName":"爵士舞","tagRemark":"爵士舞简介......","tagImgUrl":"http://vod.tingwu365.com/image/default/17CE97DB5EFE4A3DBC563F732E93F903-6-2.png","tagVideoNum":null,"studyNum":null,"coverImg":null,"higherId":"2","defHotTag":null},{"id":"3","createTime":"2020-07-08 12:07:51","updateTime":"2020-08-10 16:20:43","createUser":"1","updateUser":null,"tagName":"街舞","tagRemark":"街舞简介......","tagImgUrl":"http://vod.tingwu365.com/image/default/BD814E629AAB4D8C932B3DA540203DA3-6-2.png","tagVideoNum":null,"studyNum":null,"coverImg":null,"higherId":"1","defHotTag":null},{"id":"4","createTime":"2020-07-08 12:07:59","updateTime":"2020-08-10 16:20:45","createUser":"1","updateUser":null,"tagName":"芭蕾舞","tagRemark":"芭蕾舞简介......","tagImgUrl":"http://vod.tingwu365.com/image/default/4DA0631EF38B45FFA3D2189459055E9F-6-2.png","tagVideoNum":null,"studyNum":null,"coverImg":null,"higherId":"2","defHotTag":null},{"id":"5","createTime":"2020-07-08 12:08:33","updateTime":"2020-08-10 16:20:45","createUser":"1","updateUser":null,"tagName":"拉丁舞","tagRemark":"拉丁舞简介......","tagImgUrl":"http://vod.tingwu365.com/image/default/17CE97DB5EFE4A3DBC563F732E93F903-6-2.png","tagVideoNum":null,"studyNum":null,"coverImg":null,"higherId":"2","defHotTag":null}]
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
         * id : 1
         * createTime : 2020-07-08 12:07:35
         * updateTime : 2020-08-10 16:20:42
         * createUser : 1
         * updateUser : null
         * tagName : 民族舞
         * tagRemark : 民族舞简介......
         * tagImgUrl : http://vod.tingwu365.com/image/default/4DA0631EF38B45FFA3D2189459055E9F-6-2.png
         * tagVideoNum : null
         * studyNum : null
         * coverImg : null
         * higherId : 1
         * defHotTag : null
         */

        private String id;
        private String createTime;
        private String updateTime;
        private String createUser;
        private Object updateUser;
        private String tagName;
        private String tagRemark;
        private String tagImgUrl;
        private Object tagVideoNum;
        private Object studyNum;
        private Object coverImg;
        private String higherId;
        private Object defHotTag;

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

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public String getTagRemark() {
            return tagRemark;
        }

        public void setTagRemark(String tagRemark) {
            this.tagRemark = tagRemark;
        }

        public String getTagImgUrl() {
            return tagImgUrl;
        }

        public void setTagImgUrl(String tagImgUrl) {
            this.tagImgUrl = tagImgUrl;
        }

        public Object getTagVideoNum() {
            return tagVideoNum;
        }

        public void setTagVideoNum(Object tagVideoNum) {
            this.tagVideoNum = tagVideoNum;
        }

        public Object getStudyNum() {
            return studyNum;
        }

        public void setStudyNum(Object studyNum) {
            this.studyNum = studyNum;
        }

        public Object getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(Object coverImg) {
            this.coverImg = coverImg;
        }

        public String getHigherId() {
            return higherId;
        }

        public void setHigherId(String higherId) {
            this.higherId = higherId;
        }

        public Object getDefHotTag() {
            return defHotTag;
        }

        public void setDefHotTag(Object defHotTag) {
            this.defHotTag = defHotTag;
        }
    }
}
