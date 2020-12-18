package com.asianwallets.restApiDemo.Online;

import com.alibaba.fastjson.JSONObject;
import com.asianwallets.restApiDemo.dto.AcquireOnlineDTO;
import com.asianwallets.restApiDemo.utils.HttpClientUtils;
import com.asianwallets.restApiDemo.utils.HttpResponse;
import com.asianwallets.restApiDemo.utils.SignUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线上收单demo
 */
public class OnlineDemo {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //Here is the private key that needs to be the merchant
    private static final String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDxRmn2smlghwDRiR0AW2DKNqRpbIfAFAA99HjWG9oCj1sws8m7Et9+GijNAquoo7CZydfUZSFy6UJVr3USRWYYR1Te0KDP3RDQmX9e1k0095cJCvkRbQlFyC10jDbGBExxtxZphzoK7pUkuLWM6BW1pN85vCOAD6P5ZWYMfHvI2DTa8GMyMX4qFyfLmA/cVI6/iN6LDH/WHyvgM7wK2dTmlMUOYbDnPNSMsGTFtJ+fTvxdyj709+vQTcB+ozd0tcBUCU06e5OSg9PKmvY8LPq8Kbrxmdvr+NMKG9kNYFV9mO9vCHDVgP/+Bh9DbqYe6ZZxs59KD2HasqBOhyy2p6pAgMBAAECggEAUE/pey0WihHrEPPHdA0Kuk5EKVFcZxjBqlVhT7eu7zKOjaOOrqKGwJiO7inh+N6LNGG61ZXbeFDOngqIWMLSrrVCMoeF2ojqS7REhWKQ1GnttSs2tULmsVSPU0JxFJhuonAaDWn5ZGiCgNml9/gvWb4e1pnLNEFh4EKGEuUeGCoOh9IkU5pJPp+T+G5iFfHwwMaLoWshVDZ4MDhRhEKxB9OBxY47Q72NbyEEXipbqSoV7mHOAj6nYDvPNmHEnDrImOjYzpRbgPTxBjosMiGj4/9EDGgIlGKA/UXYKBXlpvSSmdOdKxNG8CMT8ax9/MbdB/h81R7csbeJy+pPB5uoAQKBgQDOZwL7iJ5pDtN0JUysMXR6wdQ8kD5ooTj1Qceqc6X6HPaj4yY1XB3ghmL/jReoSCfz+i9HRNz7Cz34BSbcAXpZB0bmP9bKog4QgHJ8gg9SAGmcTVr/Vw/tlN520Hte1f4HrfQieKyYmvJPvWvwVZ4gPKxxb0ykC8/DqHeq36nGoQKBgQCjbwUTF5s7enbOyfP9wXbges8SSjmmtk/ZoCvgrP9RJtGP9dtFzeGB+YEv53JpgqPV1PtOBqmDfN80nd2ED+Cwtkv9pAhBofomUVaoJYUA37BdwhQcL4YIe5223CKkIpcJKln5dH8onevdoxIg9CHOahPsegSAtwCf+TAy2dbDCQKBgQCpTJ2JrJojGmIflqi5ZSdhubNYqghG0ldh9L7N9WZjLXaxHxSsGA75p8F0VErfYbBD0ycMklOgJ6yAz9j8BMpSVEG3gw2v0BUxO+qsbhIa9POrnVfSsZsDCWUgmAlZ1LU1n13tGIaZ9h5jgcATtmapkprvwJdgx793gawGoMclgQKBgQCZG2SRokfWzL+IskFVtGx9mA9tfwPLXngn1JnGfcsiZ09jolutZVahwPB5xEW2+qAprsFPM4aSm+UvEcV39rf0VJOUJptlgS0rwH+CPsP/MY+0BiF41jymrcfuiwQY6B6+g2KPA8gscOWKWT6eiJczHMVVgGm/e7GmLHgu60z6oQKBgC749yxkJKmCcCGFLXeUh5XAPEV4mvEMJOz6pOgAEJcWUwV+7EgN0WIYI2QExDD4ul+vipZ6sgOUMKn0t92BbPOIQYS77KmwKq7lf2Mlf/PPqMSXpzNd7BglGbDmrSScOxG5/LmMc80yQ7rNpcyG/K6oQcesy7TCcI+1OqhynGVv";

    public static void main(String[] args) {
        //You can then invoke the online trading interface
        AcquireOnlineDTO acquireOnlineDTO = new AcquireOnlineDTO();
        //Merchant ID
        acquireOnlineDTO.setMerchantId("M202006043328");
        //Merchant order number 商户订单号
        acquireOnlineDTO.setOrderNo("1000020201211155530384067");
        //Order currency
        acquireOnlineDTO.setOrderCurrency("HKD");
        //Order amount
        acquireOnlineDTO.setOrderAmount(new BigDecimal("0.1"));
        //Order time, format is yyyy-MM-dd HH: mm: ss 商户订单时间
        acquireOnlineDTO.setOrderTime(sdf.format(new Date()));
        //Server callback address
        acquireOnlineDTO.setServerUrl("https://www.baidu.com/");
        //Signature type. 1 is RSA. 2 is MD5
        acquireOnlineDTO.setSignType("1");
        //以下的产品编号和银行机构代码会随着生产环境和测试不同需要调整
        acquireOnlineDTO.setProductCode(101);
        acquireOnlineDTO.setIssuerId("alipay");
        //Product name
        acquireOnlineDTO.setProductName("Alipay-H5-HKD");
        String sign = SignUtils.createOnelineSign(acquireOnlineDTO, RSA_PRIVATE_KEY);
        //Signature
        acquireOnlineDTO.setSign(sign);
        String s = onlineTrade(acquireOnlineDTO);
        System.out.println("s:"+s);
    }

    /**
     * online transactions
     *
     * @return form
     */
    public static String onlineTrade(AcquireOnlineDTO acquireOnlineDTO) {
        //Post requests are sent using HTTP,and the request header sets the content-type to application/json
        HttpResponse httpResponse = HttpClientUtils.reqPost(" https://testsaas.asianwallets.com/tra/online/gateway", acquireOnlineDTO, null);
        JSONObject response = httpResponse.getJsonObject();
        System.out.println("online trade response:" + response.toJSONString());
        return response.toJSONString();
    }
}
