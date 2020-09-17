package com.example.arttower.bean;

import java.util.List;

public class ToUpWuBiBean {
    /**
     * code : 200000
     * msg : null
     * data : {"accountStatus":"0","money":5544,"moneyList":[{"money":100,"moneyId":"xfz.com.ListenToDances7","id":"1111","danceCoin":"10"},{"money":600,"moneyId":"xfz.com.ListenToDances42","id":"2222","danceCoin":"60"},{"money":3000,"moneyId":"xfz.com.ListenToDances210","id":"3333","danceCoin":"300"},{"money":9800,"moneyId":"xfz.com.ListenToDances98","id":"4444","danceCoin":"980"},{"money":19800,"moneyId":"xfz.com.ListenToDances1386","id":"5555","danceCoin":"1980"}]}
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
         * accountStatus : 0
         * money : 5544
         * moneyList : [{"money":100,"moneyId":"xfz.com.ListenToDances7","id":"1111","danceCoin":"10"},{"money":600,"moneyId":"xfz.com.ListenToDances42","id":"2222","danceCoin":"60"},{"money":3000,"moneyId":"xfz.com.ListenToDances210","id":"3333","danceCoin":"300"},{"money":9800,"moneyId":"xfz.com.ListenToDances98","id":"4444","danceCoin":"980"},{"money":19800,"moneyId":"xfz.com.ListenToDances1386","id":"5555","danceCoin":"1980"}]
         */

        private String accountStatus;
        private int money;
        private List<MoneyListBean> moneyList;

        public String getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(String accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public List<MoneyListBean> getMoneyList() {
            return moneyList;
        }

        public void setMoneyList(List<MoneyListBean> moneyList) {
            this.moneyList = moneyList;
        }

        public static class MoneyListBean {
            /**
             * money : 100
             * moneyId : xfz.com.ListenToDances7
             * id : 1111
             * danceCoin : 10
             */

            private int money;
            private String moneyId;
            private String id;
            private String danceCoin;
            private boolean isSelect ; //本地添加

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public String getMoneyId() {
                return moneyId;
            }

            public void setMoneyId(String moneyId) {
                this.moneyId = moneyId;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDanceCoin() {
                return danceCoin;
            }

            public void setDanceCoin(String danceCoin) {
                this.danceCoin = danceCoin;
            }

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }
        }
    }
}
