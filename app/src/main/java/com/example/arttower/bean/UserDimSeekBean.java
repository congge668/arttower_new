package com.example.arttower.bean;

import java.util.List;

public class UserDimSeekBean {

    /**
     * code : 200000
     * msg : null
     * data : {"total":1,"rows":[{"id":"10012","firstName":null,"mobile":"13235913936","nickName":"熊猫","content":"为什么怀孕后会有衣原体？衣原体是怎么产生的，拥有衣原体的","createTime":"2020-07-08 11:49:38.0","isfocus":"0","headUrl":"https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020090815995554881529485.png","updateTime":"2020-09-08 16:58:42.0","about":null}]}
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
         * total : 1
         * rows : [{"id":"10012","firstName":null,"mobile":"13235913936","nickName":"熊猫","content":"为什么怀孕后会有衣原体？衣原体是怎么产生的，拥有衣原体的","createTime":"2020-07-08 11:49:38.0","isfocus":"0","headUrl":"https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020090815995554881529485.png","updateTime":"2020-09-08 16:58:42.0","about":null}]
         */

        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * id : 10012
             * firstName : null
             * mobile : 13235913936
             * nickName : 熊猫
             * content : 为什么怀孕后会有衣原体？衣原体是怎么产生的，拥有衣原体的
             * createTime : 2020-07-08 11:49:38.0
             * isfocus : 0
             * headUrl : https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020090815995554881529485.png
             * updateTime : 2020-09-08 16:58:42.0
             * about : null
             */

            private String id;
            private Object firstName;
            private String mobile;
            private String nickName;
            private String content;
            private String createTime;
            private String isfocus;
            private String headUrl;
            private String updateTime;
            private Object about;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Object getFirstName() {
                return firstName;
            }

            public void setFirstName(Object firstName) {
                this.firstName = firstName;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getIsfocus() {
                return isfocus;
            }

            public void setIsfocus(String isfocus) {
                this.isfocus = isfocus;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public Object getAbout() {
                return about;
            }

            public void setAbout(Object about) {
                this.about = about;
            }
        }
    }
}
