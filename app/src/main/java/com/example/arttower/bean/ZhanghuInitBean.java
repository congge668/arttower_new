package com.example.arttower.bean;
/*
* 账户资料bean
* */
public class ZhanghuInitBean {

    /**
     * code : 200000
     * msg : 成功
     * data : {"id":"51fde5a3def8754d1d7a2716862293f0","createTime":"2020-08-10 15:06:26","updateTime":"2020-08-26 16:04:16","createUser":"1","updateUser":null,"wechatAccount":"","qqAccount":"","wbAccount":"","mobile":"15670774349","password":null,"deviceNumber":null,"deviceType":"IOS","nickName":"15670774349","sex":"MALE","birthday":"19990701","email":"2539844975@qq.com","messageStatus":"1","headUrl":"https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020081915978027639996159.png","bigHeadUrl":"https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020081915978027639233308.png","isAuthentication":null,"registerTime":"2020-08-26 16:04:16","lastLoginTime":"2020-08-10 15:06:26","lastLoginAddress":"","longitude":null,"latitude":null,"prestige":null,"content":"金钱美酒与狗","isFocus":null,"baiduChannelId":null,"yptAccountDO":{"id":"d69b0fe1a6590f43f60261ab73e645b6","createTime":"2020-08-10 15:06:26","updateTime":null,"createUser":"1","updateUser":null,"uid":"51fde5a3def8754d1d7a2716862293f0","money":0,"payPassword":null,"accountStates":"UNSTART","sumMoney":0}}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 51fde5a3def8754d1d7a2716862293f0
         * createTime : 2020-08-10 15:06:26
         * updateTime : 2020-08-26 16:04:16
         * createUser : 1
         * updateUser : null
         * wechatAccount :
         * qqAccount :
         * wbAccount :
         * mobile : 15670774349
         * password : null
         * deviceNumber : null
         * deviceType : IOS
         * nickName : 15670774349
         * sex : MALE
         * birthday : 19990701
         * email : 2539844975@qq.com
         * messageStatus : 1
         * headUrl : https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020081915978027639996159.png
         * bigHeadUrl : https://tingwu0.oss-cn-beijing.aliyuncs.com/image/head/2020081915978027639233308.png
         * isAuthentication : null
         * registerTime : 2020-08-26 16:04:16
         * lastLoginTime : 2020-08-10 15:06:26
         * lastLoginAddress :
         * longitude : null
         * latitude : null
         * prestige : null
         * content : 金钱美酒与狗
         * isFocus : null
         * baiduChannelId : null
         * yptAccountDO : {"id":"d69b0fe1a6590f43f60261ab73e645b6","createTime":"2020-08-10 15:06:26","updateTime":null,"createUser":"1","updateUser":null,"uid":"51fde5a3def8754d1d7a2716862293f0","money":0,"payPassword":null,"accountStates":"UNSTART","sumMoney":0}
         */

        private String id;
        private String createTime;
        private String updateTime;
        private String createUser;
        private Object updateUser;
        private String wechatAccount;
        private String qqAccount;
        private String wbAccount;
        private String mobile;
        private Object password;
        private Object deviceNumber;
        private String deviceType;
        private String nickName;
        private String sex;
        private String birthday;
        private String email;
        private String messageStatus;
        private String headUrl;
        private String bigHeadUrl;
        private Object isAuthentication;
        private String registerTime;
        private String lastLoginTime;
        private String lastLoginAddress;
        private Object longitude;
        private Object latitude;
        private Object prestige;
        private String content;
        private Object isFocus;
        private Object baiduChannelId;
        private YptAccountDOBean yptAccountDO;

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

        public String getWechatAccount() {
            return wechatAccount;
        }

        public void setWechatAccount(String wechatAccount) {
            this.wechatAccount = wechatAccount;
        }

        public String getQqAccount() {
            return qqAccount;
        }

        public void setQqAccount(String qqAccount) {
            this.qqAccount = qqAccount;
        }

        public String getWbAccount() {
            return wbAccount;
        }

        public void setWbAccount(String wbAccount) {
            this.wbAccount = wbAccount;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public Object getDeviceNumber() {
            return deviceNumber;
        }

        public void setDeviceNumber(Object deviceNumber) {
            this.deviceNumber = deviceNumber;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMessageStatus() {
            return messageStatus;
        }

        public void setMessageStatus(String messageStatus) {
            this.messageStatus = messageStatus;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public String getBigHeadUrl() {
            return bigHeadUrl;
        }

        public void setBigHeadUrl(String bigHeadUrl) {
            this.bigHeadUrl = bigHeadUrl;
        }

        public Object getIsAuthentication() {
            return isAuthentication;
        }

        public void setIsAuthentication(Object isAuthentication) {
            this.isAuthentication = isAuthentication;
        }

        public String getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(String registerTime) {
            this.registerTime = registerTime;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getLastLoginAddress() {
            return lastLoginAddress;
        }

        public void setLastLoginAddress(String lastLoginAddress) {
            this.lastLoginAddress = lastLoginAddress;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getPrestige() {
            return prestige;
        }

        public void setPrestige(Object prestige) {
            this.prestige = prestige;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getIsFocus() {
            return isFocus;
        }

        public void setIsFocus(Object isFocus) {
            this.isFocus = isFocus;
        }

        public Object getBaiduChannelId() {
            return baiduChannelId;
        }

        public void setBaiduChannelId(Object baiduChannelId) {
            this.baiduChannelId = baiduChannelId;
        }

        public YptAccountDOBean getYptAccountDO() {
            return yptAccountDO;
        }

        public void setYptAccountDO(YptAccountDOBean yptAccountDO) {
            this.yptAccountDO = yptAccountDO;
        }

        public static class YptAccountDOBean {
            /**
             * id : d69b0fe1a6590f43f60261ab73e645b6
             * createTime : 2020-08-10 15:06:26
             * updateTime : null
             * createUser : 1
             * updateUser : null
             * uid : 51fde5a3def8754d1d7a2716862293f0
             * money : 0
             * payPassword : null
             * accountStates : UNSTART
             * sumMoney : 0
             */

            private String id;
            private String createTime;
            private Object updateTime;
            private String createUser;
            private Object updateUser;
            private String uid;
            private int money;
            private Object payPassword;
            private String accountStates;
            private int sumMoney;

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

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
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

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public Object getPayPassword() {
                return payPassword;
            }

            public void setPayPassword(Object payPassword) {
                this.payPassword = payPassword;
            }

            public String getAccountStates() {
                return accountStates;
            }

            public void setAccountStates(String accountStates) {
                this.accountStates = accountStates;
            }

            public int getSumMoney() {
                return sumMoney;
            }

            public void setSumMoney(int sumMoney) {
                this.sumMoney = sumMoney;
            }
        }
    }
}
