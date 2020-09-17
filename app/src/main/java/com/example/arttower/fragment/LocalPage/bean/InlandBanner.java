package com.example.arttower.fragment.LocalPage.bean;

import java.util.List;

public class InlandBanner {

    /**
     * code : 200000
     * msg : null
     * data : [{"id":"11","createTime":"2020-08-12 09:13:32","updateTime":"2020-08-12 09:18:50","createUser":"1","updateUser":null,"imgUrl":"https://tingwu0.oss-cn-beijing.aliyuncs.com/image/other/5eb50aa415ddf.png","forwardUrl":"https://www.baidu.com/","type":1,"sort":1,"bannerStatus":"ONE"}]
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
         * id : 11
         * createTime : 2020-08-12 09:13:32
         * updateTime : 2020-08-12 09:18:50
         * createUser : 1
         * updateUser : null
         * imgUrl : https://tingwu0.oss-cn-beijing.aliyuncs.com/image/other/5eb50aa415ddf.png
         * forwardUrl : https://www.baidu.com/
         * type : 1
         * sort : 1
         * bannerStatus : ONE
         */

        private String id;
        private String createTime;
        private String updateTime;
        private String createUser;
        private Object updateUser;
        private String imgUrl;
        private String forwardUrl;
        private int type;
        private int sort;
        private String bannerStatus;

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

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getForwardUrl() {
            return forwardUrl;
        }

        public void setForwardUrl(String forwardUrl) {
            this.forwardUrl = forwardUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getBannerStatus() {
            return bannerStatus;
        }

        public void setBannerStatus(String bannerStatus) {
            this.bannerStatus = bannerStatus;
        }
    }
}
