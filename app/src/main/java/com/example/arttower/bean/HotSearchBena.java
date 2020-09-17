package com.example.arttower.bean;

import java.util.List;

public class HotSearchBena {

    /**
     * code : 200000
     * msg : null
     * data : [{"id":"111","createTime":"2020-07-31 14:55:32","updateTime":"2020-07-31 14:51:58","createUser":"1","updateUser":null,"keywords":"国际标","isHot":"1","isPraise":"0"},{"id":"222","createTime":"2020-07-31 14:54:32","updateTime":"2020-07-31 14:52:01","createUser":"1","updateUser":null,"keywords":"现代舞","isHot":"0","isPraise":"1"},{"id":"333","createTime":"2020-07-31 14:53:32","updateTime":"2020-07-31 14:52:06","createUser":"1","updateUser":null,"keywords":"桃李芬芳","isHot":"0","isPraise":"0"},{"id":"444","createTime":"2020-07-31 14:52:24","updateTime":"2020-07-31 14:52:08","createUser":"1","updateUser":null,"keywords":"中国舞","isHot":"0","isPraise":"0"},{"id":"555","createTime":"2020-07-31 14:51:32","updateTime":"2020-07-31 14:55:27","createUser":"1","updateUser":null,"keywords":"夏日高光时刻","isHot":"0","isPraise":"0"},{"id":"666","createTime":"2020-07-31 14:50:32","updateTime":"2020-07-31 14:55:31","createUser":"1","updateUser":null,"keywords":"夏日居家舞蹈","isHot":"0","isPraise":"0"},{"id":"777","createTime":"2020-07-31 14:49:39","updateTime":"2020-07-31 14:55:34","createUser":"1","updateUser":null,"keywords":"舞蹈圈的夏天","isHot":"0","isPraise":"0"}]
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
         * id : 111
         * createTime : 2020-07-31 14:55:32
         * updateTime : 2020-07-31 14:51:58
         * createUser : 1
         * updateUser : null
         * keywords : 国际标
         * isHot : 1
         * isPraise : 0
         */

        private String id;
        private String createTime;
        private String updateTime;
        private String createUser;
        private Object updateUser;
        private String keywords;
        private String isHot;
        private String isPraise;

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

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getIsHot() {
            return isHot;
        }

        public void setIsHot(String isHot) {
            this.isHot = isHot;
        }

        public String getIsPraise() {
            return isPraise;
        }

        public void setIsPraise(String isPraise) {
            this.isPraise = isPraise;
        }
    }
}
