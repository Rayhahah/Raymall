package tecentcloud;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

public class HmacEncrypt {

    //各种参数的key
    private final String ACTION = "Action";
    private final String NONCE = "Nonce";
    private final String REGION = "Region";
    private final String SECRETID = "SecretId";
    private final String SIGNATUREMETHOD = "SignatureMethod";
    private final String TIMESTAMP = "Timestamp";
    private final String FILEID = "fileId";
    private final String PRIORITY = "priority";
    private final String SIGNATURE = null;
    HashMap<String, String> params = new HashMap<>();

    //初始化
    public HmacEncrypt(String action, String nonce, String region, String secretId, String signatureMethod,
                       String timeStamp, String fileId, String priority) {
        params.put(ACTION, action);
        params.put(NONCE, nonce);
        params.put(REGION, region);
        params.put(SECRETID, secretId);
        params.put(SIGNATUREMETHOD, signatureMethod);
        params.put(TIMESTAMP, timeStamp);
        params.put(FILEID, fileId);
        params.put(PRIORITY, priority);
    }

    //拼接参数获取拼接字符串
    private String jointParamenters(HashMap<String, String> params) {
        StringBuilder jointStr = new StringBuilder("POSTvod.api.qcloud.com/v2/index.php?");
        //排序
        Object[] array = params.keySet().toArray();
        Arrays.sort(array);
        for (Object key : array) {
            String value = params.get(key).toString();
            jointStr.append(key).append("=").append(value).append("&");
        }
        jointStr.deleteCharAt(jointStr.length() - 1);
        System.out.println(jointStr);
        return jointStr.toString();
    }


    //sha加密字符串
    public String encrypt(String secretKey) {
        String content = this.jointParamenters(this.params);
        Mac mac = null;
        try {
            SecretKeySpec signKey = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            mac = Mac.getInstance("HmacSHA256");
            mac.init(signKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        byte[] encryptBytes = mac.doFinal(content.getBytes());
        return Base64Utils.encodeBytes(encryptBytes);
    }
}
