package com.asianwallets.restApiDemo.dto;

import java.math.BigDecimal;

/**
 * 线上收单DTO
 */
public class AcquireOnlineDTO {

    //Merchant ID
    private String merchantId;

    //Merchant order number
    private String orderNo;

    //Order currency
    private String orderCurrency;

    //Order amount
    private BigDecimal orderAmount;

    //Order time, format is yyyy-MM-dd HH: mm: ss
    private String orderTime;

    //Server callback address
    private String serverUrl;

    //Signature
    private String sign;

    //Signature type. 1 is RSA. 2 is MD5
    private String signType;

    //Required when directing to a specific payment institution (required for direct connection)
    private String issuerId;

    //Required when directing to a specific payment institution (required for direct connection)
    private Integer productCode;

    //Product name
    private String productName;

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

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
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

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "AcquireOnlineDTO{" +
                "merchantId='" + merchantId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderTime='" + orderTime + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
//                ", issuerId='" + issuerId + '\'' +
//                ", productCode=" + productCode +
                ", productName='" + productName + '\'' +
                '}';
    }
}
