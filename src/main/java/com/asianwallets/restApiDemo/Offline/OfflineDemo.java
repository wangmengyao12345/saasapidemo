package com.asianwallets.restApiDemo.Offline;

import com.alibaba.fastjson.JSONObject;
import com.asianwallets.restApiDemo.dto.OfflineCSBCodeDTO;
import com.asianwallets.restApiDemo.dto.OfflineLoginDTO;
import com.asianwallets.restApiDemo.utils.HttpClientUtils;
import com.asianwallets.restApiDemo.utils.HttpResponse;
import com.asianwallets.restApiDemo.utils.SignUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线下Demo
 */
public class OfflineDemo {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String MD5KEY = "2ee4108294d44db794787b4592863a07";

    public static void main(String[] args) {

        //You can then invoke the offline login interface
        OfflineLoginDTO offlineLoginDTO = new OfflineLoginDTO();
        //Merchant ID
        offlineLoginDTO.setMerchantId("M202006043328");
        //Device ID
        offlineLoginDTO.setImei("867344040066775");
        //Operator ID
        offlineLoginDTO.setOperatorId("00");
        //Login password
        offlineLoginDTO.setPassword("123456");

        String token = login(offlineLoginDTO);
        System.out.println("token："+token);


        //You can then invoke the offline CSB Code Scanning And Receiving interface
        OfflineCSBCodeDTO offlineCSBCodeDTO = new OfflineCSBCodeDTO();
        //Merchant ID
        offlineCSBCodeDTO.setMerchantId("M202006043328");
        //Merchant Order Number 商户订单号
        offlineCSBCodeDTO.setOrderNo("1000020201211155538384863");
        //Order Currency
        offlineCSBCodeDTO.setOrderCurrency("HKD");
        //Order Amount
        offlineCSBCodeDTO.setOrderAmount(new BigDecimal("0.1"));
        //Merchant Order Time ,format is yyyy-MM-dd HH:mm:ss 商户订单时间
        offlineCSBCodeDTO.setOrderTime(sdf.format(new Date()));
        //Device id
        offlineCSBCodeDTO.setProductCode(78);
        //Product id
        offlineCSBCodeDTO.setImei("867344040066775");
        //Operator Id
        offlineCSBCodeDTO.setOperatorId("00");
        //Token
        offlineCSBCodeDTO.setToken(token);
        //Offline bsc payment code
        offlineCSBCodeDTO.setAuthCode("287533003250898988");
        //Signature
        offlineCSBCodeDTO.setSignType("2");
        //Signature Method. 1 is Rsa 2 is Md5
        String sign = SignUtils.createOfflineSign(offlineCSBCodeDTO, MD5KEY);
        offlineCSBCodeDTO.setSign(sign);
        String s = offlineCSB(offlineCSBCodeDTO);
        System.out.println("offlineCSB："+s);
    }

    /**
     * Offline Login Demo
     * @param offlineLoginDTO
     * @return
     */
    public static String login(OfflineLoginDTO offlineLoginDTO){
        //Post requests are sent using HTTP,and the request header sets the content-type to application/json
        HttpResponse httpResponse = HttpClientUtils.reqPost("https://testsaas.asianwallets.com/tra/offline/login", offlineLoginDTO, null);
        JSONObject response = httpResponse.getJsonObject();
        System.out.println("login response:" + response.toJSONString());
        JSONObject data = response.getJSONObject("data");
        return data.getString("token");
    }


    /**
     * Offline CSB Code Scanning And Receiving
     *
     * @return QrCode
     */
    public static String offlineCSB(OfflineCSBCodeDTO offlineCSBCodeDTO) {
        //Post requests are sent using HTTP,and the request header sets the content-type to application/json
        HttpResponse httpResponse = HttpClientUtils.reqPost("https://testsaas.asianwallets.com/tra/offline/csbDynamicScan", offlineCSBCodeDTO, null);
        JSONObject response = httpResponse.getJsonObject();
        System.out.println("csb response:" + response.toJSONString());
        return response.toJSONString();
    }
}
