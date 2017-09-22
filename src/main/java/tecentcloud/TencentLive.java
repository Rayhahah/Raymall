package tecentcloud;

import com.rayhahah.raymall.pojo.ESLive;
import com.rayhahah.raymall.util.DateUtil;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangjf on 2017/7/31.
 */
public class TencentLive {

    private static String chars = "abcdefghijklmnopqrstuvwxyz";

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 生成推流地址
     *
     * @param second
     * @return
     */
    public static ESLive getPushUrl(int second) {
        ESLive esLive = new ESLive();

        String streamId = null; // 直播码
        String resultUrl = ""; // 推流URL
        String rtmpUrl = ""; //播放地址 (RTMP)
        String flvUrl = ""; //播放地址 (FLV)
        String hlsUrl = ""; //播放地址 (HLS)
        streamId = LiveConfig.bizid + "_easysport" + chars.charAt((int) (Math.random() * 26)) + Long.toHexString(new Date().getTime()).toUpperCase().toString();
        // 拼接直播码
        String safeUrl = getSafeUrl(LiveConfig.fandaokey, streamId, DateUtil.getDateLater2(new Date(), second).getTime() / 1000);
        resultUrl += "rtmp://" + LiveConfig.bizid + ".livepush.myqcloud.com/live/" + streamId + "?bizid=" + LiveConfig.bizid + "&" + safeUrl;
        rtmpUrl += "rtmp://" + LiveConfig.bizid + ".liveplay.myqcloud.com/live/" + streamId;
        flvUrl += "http://" + LiveConfig.bizid + ".liveplay.myqcloud.com/live/" + streamId + ".flv";
        hlsUrl += "http://" + LiveConfig.bizid + ".liveplay.myqcloud.com/live/" + streamId + ".m3u8";
        esLive.setPushUrl(resultUrl);
        esLive.setStreamId(streamId);
        esLive.setRtmpUrl(rtmpUrl);
        esLive.setFlvUrl(flvUrl);
        esLive.setHlsUrl(hlsUrl);
        return esLive;
    }

    /**
     * 获取当前正在直播的频道的信息
     *
     * @param day    请求地址过期时间间隔
     * @param apikey Api鉴权key
     * @param appid  appId
     * @return String
     */
    public static String getLivingInformation(int day, String apikey, String appid) {
        String preUrl = "http://statcgi.video.qcloud.com/common_access";
        String actionName = "Get_LiveStat";
        String result = null;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
        String sign = null; // md5(key+有效截止时间戳)
        long t = 0; // 有效截止时间戳
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setContentCharset("UTF-8");
        // "http://statcgi.video.qcloud.com/common_access?appid=" LiveConfig.appid + "&interface=Get_LiveStat&t="+t+"&sign="+sign;
        try {
            t = DateUtil.getDateLater(new Date(), 100).getTime() / 1000;
            String params = apikey + t; // key+有效截止时间戳
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            sign = byteArrayToHexString(messageDigest.digest(params.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//		String sendurl = preUrl + "?appid=" + appid + "&interface=" + actionName + "&t=" + t + "&sign=" + sign;
        String sendurl = preUrl + "?cmd=" + LiveConfig.appid + "&interface=" + actionName + "&t=" + t + "&sign=" + sign;
        GetMethod getMethod = new GetMethod(sendurl);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        String responseMsg = "";
        try {
            httpClient.executeMethod(getMethod);
            byte[] responseBody = getMethod.getResponseBody();
            responseMsg = new String(responseBody);
            result = responseMsg;
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getMethod.releaseConnection();
        }
        return result;
    }

    /**
     * 查询直播中频道列表
     *
     * @param day
     * @param apikey
     * @param appid
     * @return
     */
    public static String getLiveChannelList(int day, String apikey, String appid) {
        String preUrl = "http://fcgi.video.qcloud.com/common_access?";
        String actionName = "Live_Channel_GetLiveChannelList";
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
        String sign = null; // md5(key+有效截止时间戳)
        long t = 0; // 有效截止时间戳
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setContentCharset("UTF-8");
        try {
            Date now = sdf.parse(sdf.format(calendar.getTime()));
            t = now.getTime() / 1000; // 有效截止时间戳
            String params = LiveConfig.apikey + t; // key+有效截止时间戳
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            sign = byteArrayToHexString(messageDigest.digest(params.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
//		String sendurl = preUrl + "?appid=" + appid + "&interface="+ actionName + "&t=" + t + "&sign=" + sign;
        String sendurl = preUrl + "?appid=" + LiveConfig.appid + "&interface=" + actionName + "&t=" + t + "&sign=" + sign;
        GetMethod getMethod = new GetMethod(sendurl);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        String responseMsg = "";
        try {
            httpClient.executeMethod(getMethod);
            byte[] responseBody = getMethod.getResponseBody();
            responseMsg = new String(responseBody);
            result = responseMsg;
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getMethod.releaseConnection();
        }
        return result;
    }

    /**
     * 查询频道列表
     *
     * @return
     */
    public static String getChannelList() {
        String preUrl = "http://fcgi.video.qcloud.com/common_access";
        String actionName = "Live_Channel_GetChannelList";
        String result = "";
        Calendar calendar = Calendar.getInstance();
        String t = DateUtil.date2TimeStamp("2119-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");// 有效截止时间戳
        String sign = null; // md5(key+有效截止时间戳)
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setContentCharset("UTF-8");
        try {
            String params = LiveConfig.apikey + t; // key+有效截止时间戳
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            sign = byteArrayToHexString(messageDigest.digest(params.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String sendurl = preUrl + "?appid=" + LiveConfig.appid + "&interface=" + actionName + "&t=" + t + "&sign=" + sign;
        GetMethod getMethod = new GetMethod(sendurl);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        String responseMsg = "";
        try {
            httpClient.executeMethod(getMethod);
            byte[] responseBody = getMethod.getResponseBody();
            responseMsg = new String(responseBody);
            result = responseMsg;
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getMethod.releaseConnection();
        }
        return result;
    }

    /**
     * 删除腾讯云点播视频的接口
     *
     * @param fileId    腾讯云的点播文件id 通过设置腾讯云消息回调接口获得
     * @param SecretId  腾讯云安全凭证中的SecretId
     * @param SecretKey 腾讯云安全凭证中的Secretkey
     * @param priority  可填0；优先级0:中 1：高 2：低 腾讯云接口要求参数
     * @return
     */
    public static String deleteTecentVideoFile(String fileId, String SecretId, String SecretKey, Integer priority) {
        long timeStamp = new Date().getTime() / 1000;
        int max = 60000;
        int min = 10000;
        int nonce = new Random().nextInt(max) % (max - min + 1) + min;
        HmacEncrypt encryptMan = new HmacEncrypt("DeleteVodFile",
                Integer.toString(nonce), "ap-guangzhou", SecretId,
                "HmacSHA256", String.valueOf(timeStamp), fileId,
                String.valueOf(priority));
        String encryptedStr = encryptMan.encrypt(SecretKey);
        String responseMsg = "";
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setContentCharset("UTF-8");
        String url = "https://vod.api.qcloud.com/v2/index.php";
        PostMethod postMethod = new PostMethod(url);
        postMethod.addParameter("Action", "DeleteVodFile");
        postMethod.addParameter("Nonce", Integer.toString(nonce));
        postMethod.addParameter("Region", "ap-guangzhou");
        postMethod.addParameter("SecretId", SecretId);
        postMethod.addParameter("SignatureMethod", "HmacSHA256");
        postMethod.addParameter("Timestamp", String.valueOf(timeStamp));
        postMethod.addParameter("fileId", fileId);
        postMethod.addParameter("priority", String.valueOf(priority));
        postMethod.addParameter("Signature", encryptedStr);
        try {
            httpClient.executeMethod(postMethod);// 200
            responseMsg = postMethod.getResponseBodyAsString().trim();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            postMethod.releaseConnection();// 7.释放连接
        }
        return responseMsg;
    }

    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String getSafeUrl(String key, String streamId, long txTime) {
        String input = new StringBuilder().append(key).append(streamId).append(Long.toHexString(txTime).toUpperCase()).toString();
        String txSecret = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            txSecret = byteArrayToHexString(messageDigest.digest(input.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return txSecret == null ? "" : new StringBuilder().append("txSecret=")
                .append(txSecret).append("&").append("txTime=")
                .append(Long.toHexString(txTime).toUpperCase()).toString();
    }

    private static String byteArrayToHexString(byte[] data) {
        char[] out = new char[data.length << 1];
        for (int i = 0, j = 0; i < data.length; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return new String(out);
    }

}
