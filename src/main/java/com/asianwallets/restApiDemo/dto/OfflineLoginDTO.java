package com.asianwallets.restApiDemo.dto;

/**
 * 线下设备登录
 */
public class OfflineLoginDTO {

    //Merchant ID
    private String merchantId;

    //Device ID
    private String imei;

    //Operator ID
    private String operatorId;

    //Login password
    private String password;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "OfflineLoginDTO{" +
                "merchantId='" + merchantId + '\'' +
                ", imei='" + imei + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
