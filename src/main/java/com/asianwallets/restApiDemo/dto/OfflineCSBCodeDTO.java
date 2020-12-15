package com.asianwallets.restApiDemo.dto;

import java.math.BigDecimal;

/**
 *线下同机构CSB动态扫码收单(Offline CSB Code Scanning And Receiving)
 */
public class OfflineCSBCodeDTO {

    //Merchant ID
    private String merchantId;

    //Merchant Order Number
    private String orderNo;

    //Order Currency
    private String orderCurrency;

    //Order Amount
    private BigDecimal orderAmount;

    //Merchant Order Time ,format is yyyy-MM-dd HH:mm:ss
    private String orderTime;

    //Device id
    private String imei;

    //Product id
    private Integer productCode;

    //Operator Id
    private String operatorId;

    //Token
    private String token;

    //Offline bsc payment code
    private String authCode;

    //Signature
    private String sign;

    //Signature Method. 1 is Rsa 2 is Md5
    private String signType;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    @Override
    public String toString() {
        return "OfflineCSBCodeDTO{" +
                "merchantId='" + merchantId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderTime='" + orderTime + '\'' +
                ", imei='" + imei + '\'' +
                ", productCode=" + productCode +
                ", operatorId='" + operatorId + '\'' +
                ", token='" + token + '\'' +
                ", authCode='" + authCode + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }
}
