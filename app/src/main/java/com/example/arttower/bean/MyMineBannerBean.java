package com.example.arttower.bean;

import java.util.List;

public class MyMineBannerBean {

    /**
     * code : 200000
     * msg : null
     * data : [{"imgUrl":"https://tingwu0.oss-cn-beijing.aliyuncs.com/image/other/5d0a0e4e7e03e.png","id":"33","forwardUrl":"https://www.baidu.com/"}]
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
         * imgUrl : https://tingwu0.oss-cn-beijing.aliyuncs.com/image/other/5d0a0e4e7e03e.png
         * id : 33
         * forwardUrl : https://www.baidu.com/
         */

        private String imgUrl;
        private String id;
        private String forwardUrl;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getForwardUrl() {
            return forwardUrl;
        }

        public void setForwardUrl(String forwardUrl) {
            this.forwardUrl = forwardUrl;
        }
    }
}
