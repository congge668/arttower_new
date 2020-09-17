package com.example.arttower.other;

public class AliPayOrderInfoBean {


    /**
     * code : 200000
     * msg : null
     * data : alipay_sdk=alipay-sdk-java-3.0.52.ALL&app_id=2021001193600531&biz_content=%7B%22body%22%3A%221%E5%85%83%22%2C%22goods_type%22%3A%220%22%2C%22out_trade_no%22%3A%22AP202009171500040141%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E8%88%9E%E5%B8%81%E5%85%85%E5%80%BC%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%22100.0%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fwww.tingwu365.com%2Fypt%2Falipay%2Fpay_return&sign=d5gln%2Bq1TORIchCU6hfMwK9V3XiYdcSFMOZn3C8uHlfWq%2BNLq7ZuB9qQMYZt09uH6sUmW7WU%2Fte7RzbB0S6j7rn8t7qVlOfi9d2U%2FGfF%2BmK9BDsMaxFZb%2Fh2M1xEoluwa9L3BygSLfvAHlgSazoqLb9ATE7zqKJ1ieCMJkJxdMfcExMVWTBfpMHTTD%2Bl8O6ubyaOWpdsvrgyXt1XwC%2BH%2BUyN5ZpTjJK5K4AxbLuh%2FAxxomzXzIRdcTVDkTLF0gofFNUa%2BVz%2BFPojhH6OEqmbqWwjrMq4ySlpS%2FkehG5ARzstfk7i4p8HKXK9BN8E%2Fh5orcxRBCFF5mwAF%2BQQwDmzBg%3D%3D&sign_type=RSA2&timestamp=2020-09-17+15%3A00%3A04&version=1.0
     */

    private int code;
    private String msg;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
