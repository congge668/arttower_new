package com.example.arttower.bean;

import java.util.List;

public class TestDimSeekInfo {

    /**
     * code : 200000
     * msg : null
     * data : {"total":2,"rows":[{"id":"7933","uid":"7933","courseName":"打卡舞蹈活动2","courseRemark":"这是一个超高质量的课程，价格实惠。","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","nickName":"用户7932","createTime":"2020-07-08 15:53:10.0","praiseCounts":"0","updateTime":"2020-09-11 14:56:06.0","about":null},{"id":"7932","uid":"7932","courseName":"打卡舞蹈活动","courseRemark":"这是一个超高质量的课程，价格实惠。","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","nickName":"用户7931","createTime":"2020-07-08 15:53:10.0","praiseCounts":"0","updateTime":"2020-09-13 10:32:06.0","about":null}]}
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
         * total : 2
         * rows :  [{"id":"7933","uid":"7933","courseName":"打卡舞蹈活动2","courseRemark":"这是一个超高质量的课程，价格实惠。","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","nickName":"用户7932","createTime":"2020-07-08 15:53:10.0","praiseCounts":"0","updateTime":"2020-09-11 14:56:06.0","about":null},{"id":"7932","uid":"7932","courseName":"打卡舞蹈活动","courseRemark":"这是一个超高质量的课程，价格实惠。","coverImg":"http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png","nickName":"用户7931","createTime":"2020-07-08 15:53:10.0","praiseCounts":"0","updateTime":"2020-09-13 10:32:06.0","about":null}]
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
             * id : 7933
             * uid : 7933
             * courseName : 打卡舞蹈活动2
             * courseRemark : 这是一个超高质量的课程，价格实惠。
             * coverImg : http://vod.tingwu365.com/image/default/7377FF7CBC5B4ECBA9050DCE560D34F7-6-2.png
             * nickName : 用户7932
             * createTime : 2020-07-08 15:53:10.0
             * praiseCounts : 0
             * updateTime : 2020-09-11 14:56:06.0
             * about : null
             */

            private String id;
            private String uid;
            private String courseName;
            private String courseRemark;
            private String coverImg;
            private String nickName;
            private String createTime;
            private String praiseCounts;
            private String updateTime;
            private Object about;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
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

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getPraiseCounts() {
                return praiseCounts;
            }

            public void setPraiseCounts(String praiseCounts) {
                this.praiseCounts = praiseCounts;
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
