package com.rayhahah.raymall.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unchecked")
public class Utils {


    /**
     * @param page     当前页数
     * @param pageSize 每页显示的数量
     * @return 返回起始记录和结束记录, 用于sql分页
     */
    public static int[] getRows(int page, int pageSize) {
        int[] rows = new int[2];
        rows[0] = (page - 1) * pageSize;
        rows[1] = page * pageSize;
        return rows;
    }

    /**
     * 校验批量删除ID
     *
     * @param param
     */
    public static boolean validDel(Map param) {
        String ids = (String) param.get("ids");
        StringBuffer sbf = new StringBuffer();
        if (ids != null && ids.trim() != "") {
            String[] idArr = ids.split(",");
            for (int i = 0; i < idArr.length; i++) {
                if (idArr[i] != null && !"".equals(idArr[i].trim())) {
                    if (i == idArr.length - 1) {
                        sbf.append(idArr[i]);
                        break;
                    }
                    sbf.append(idArr[i]).append(",");
                }
            }
            String paramIds = sbf.toString();
            if (paramIds == null || "".equals(paramIds)) {
                return false;
            }
            param.put("ids", paramIds);
            return true;
        }
        return false;
    }

    /**
     * 获取当前系统时间,并格式化
     *
     * @return
     */
    public static String getCurrentTime() {
        return parseToString(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前系统时间,并格式化
     *
     * @return
     */
    public static String getCurrentDate() {
        return parseToString(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前系统时间,并格式化
     *
     * @return
     */
    public static String getNowDate() {
        return parseToString(new Date(), "yyyy-MM-dd");
    }

    /**
     * 获取当前时间后24小时,并格式化
     *
     * @return
     */
    public static String getNextDate() {
        return parseToString(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000), "yyyy-MM-dd HH:mm:ss");
    }





    /**
     * 将url的反斜杆"\\"转为正斜杠"/"
     *
     * @return
     */
    public static String changeUrlSprit(String url) {
        //两次转换
        url = url.replaceAll("\\\\\\\\", "/"); //  "\\"
        return url.replaceAll("\\\\", "/");  //    "\"
    }


    /**
     * 将一个日期转换为字符串，格式为：yyyy-MM-dd HH:mm:SS。
     *
     * @param date 要转换的日期。
     * @throws
     */
    public static String parseToString(Date date, String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return sdf.format(calendar.getTime());
    }

    /**
     * 处理日期和时间的字符串
     *
     * @param strTime
     * @return
     * @throws ParseException
     */
    public static String covertDateTime(String strTime, String format) throws ParseException {
        if (strTime != null && !"".equals(strTime)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date dateTime = sdf.parse(strTime.replace("T", " "));
            strTime = sdf.format(dateTime);
        }
        return strTime;
    }

    /**
     * <p>Checks if a String is whitespace, empty ("") or null.</p>
     * <p>
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("null")      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     * @since 2.0
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.trim().length()) == 0 || "null".equals(str)) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    //MD5方式编码
    public static String MD5Encode(String origin, String charsetName) {
        if (origin == null)
            return null;

        StringBuilder sb = new StringBuilder();
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        // 生成一组length=16的byte数组
        byte[] bs = digest.digest(origin.getBytes(Charset.forName(charsetName)));

        for (int i = 0; i < bs.length; i++) {
            int c = bs[i] & 0xFF; // byte转int为了不丢失符号位， 所以&0xFF
            if (c < 16) { // 如果c小于16，就说明，可以只用1位16进制来表示， 那么在前面补一个0
                sb.append("0");
            }
            sb.append(Integer.toHexString(c));
        }
        return sb.toString();
    }


    public static String[] chars = {"a", "b", "c", "d", "e", "f", "g", "h",

            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",

            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",

            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",

            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",

            "U", "V", "W", "X", "Y", "Z"};

    //生成6位字符串，可以作为唯一标识
    public static String ShortURLBuilder(String url) {
        if (url == null) {
            return null;
        }
        //先得到url的32个字符的md5码
        String md5 = MD5Encode(url, "UTF-8");
        String[] resUrl = new String[4];
        //将32个字符的md5码分成4段处理，每段8个字符
        for (int i = 0; i < 4; i++) {

            int offset = i * 8;

            String sub = md5.substring(offset, offset + 8);

            long sub16 = Long.parseLong(sub, 16); //将sub当作一个16进制的数，转成long

            // & 0X3FFFFFFF，去掉最前面的2位，只留下30位
            sub16 &= 0X3FFFFFFF;

            StringBuilder sb = new StringBuilder();
            //将剩下的30位分6段处理，每段5位
            for (int j = 0; j < 6; j++) {
                //得到一个 <= 61的数字
                long t = sub16 & 0x0000003D;
                sb.append(chars[(int) t]);

                sub16 >>= 5; //将sub16右移5位
            }
            resUrl[i] = sb.toString();
        }
        return resUrl[2];
    }

    /**
     * 把Unicode编码转换为汉字
     *
     * @param source
     * @return
     */
    public static String convertUnicodeToChar(String source) {
        if (null == source || " ".equals(source)) {
            return source;
        }

        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < source.length()) {
            if (source.charAt(i) == '\\') {
                int j = Integer.parseInt(source.substring(i + 2, i + 6), 16);
                sb.append((char) j);
                i += 6;
            } else {
                sb.append(source.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    /**
     * 汉字转换为Unicode编码
     *
     * @param source
     * @return
     */
    public static String convertCharToUnicode(String source) {
        if (null == source || " ".equals(source)) {
            return source;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            sb.append("\\u" + Integer.toHexString(c));
        }
        return sb.toString();
    }

    public static void setupjqGridPageQueryParam(Map paramMap) {
        String page = (String) paramMap.get("page");
        String rows = (String) paramMap.get("rows");
        String sidx = (String) paramMap.get("sidx");
        String sord = (String) paramMap.get("sord");
        int tempPage = Integer.parseInt(page);
        int tempRows = Integer.parseInt(rows);
        paramMap.put("start", (tempPage - 1) * tempRows);
        paramMap.put("limit", tempRows);
        //排序
        paramMap.put("sort", sidx);
        paramMap.put("dir", sord);

    }

    /**
     * 封装request请求参数到Map里
     *
     * @param request
     * @return
     */
    public static Map<String, String> paramsToMap(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String, String>();
        // 得到枚举类型的参数名称，参数名称若有重复的只能得到第一个
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String paramName = (String) em.nextElement();
            String paramValue = request.getParameter(paramName);
            // 形成键值对应的map
            params.put(paramName, paramValue);
        }
        return params;
    }

    public static void main(String[] args) {
//		System.out.println(Util.send_code_sms("15018446196"));
//		Map paramMap = new HashMap();
//		paramMap.put("account", "account");
//		String password = (String) paramMap.get("password");
//		System.out.println(Calendar.getInstance().getTimeInMillis());
//		String str = ShortURLBuilder("http://blog.csdn.net/is_zhoufeng/article/details/21494281"); 
//		String str = ShortURLBuilder(String.valueOf(Calendar.getInstance().getTimeInMillis())); 
//		String str = ShortURLBuilder("123"); 
//		System.out.println(str);
//		String a = "A";
//		String b =a.substring(0, Integer.valueOf(ResourceUtil.getOrgCodeLengthType())+1);
//		System.out.println(convertUnicodeToChar("中国人民：\u666e\u901a\u65e5\u884c\u516c\u4ea4\u8f66"));  
//	    System.out.println(convertCharToUnicode("{\"title\"")); 

        String str = "sfds fds\ngh\tgf";

        System.out.println(replaceCharForJson(str));

    }

    /**
     * 获取cookie 的值
     *
     * @param cookieName
     * @param request
     * @return
     */
    public static String getCookieValue(String cookieName, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        try {
            if (cookies != null && cookies.length > 0) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookieName.equals(cookie.getName())) {
                        return cookie.getValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    /**
     * 删除文件
     *
     * @param path
     * @return
     */
    public static boolean deleteFile(String path) {
        boolean success = false;
        File file = new File(path);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            success = true;
        }
        return success;
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }



    /**
     * 替换回车、水平制表符、换行 为 一个空格字符串
     *
     * @param str
     * @return
     * @author: ltaimao@gmail.com
     * @MethodName: replaceCahrForJson
     * @date:2016年12月19日 下午4:10:01
     * \n 回车(\u000a)
     * \t 水平制表符(\u0009)
     * \s 空格(\u0008)
     * \r 换行(\u000d)
     */
    public static String replaceCharForJson(String str) {
        String dest = null;
        if (str != null) {
            //Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll(" ");
        }
        return dest;
    }



    // 获取某月28号
    public static String getThisMonthDate() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);//获取年份
        int month = ca.get(Calendar.MONTH) + 1;//获取月份
        String thisDate = year + "-" + month + "-" + 28;
        return thisDate;
    }

    // 获取上个月28号
    public static String getLastMonthDate() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);//获取年份
        if (year == 1) {
            year = ca.get(Calendar.YEAR) - 1;
        }
        int month = ca.get(Calendar.MONTH);//获取月份
        String thisDate = year + "-" + month + "-" + 28;
        return thisDate;

    }

    /**
     * 将URL转换成map类型
     *
     * @param:
     * @Author:pinux
     * @Description：
     * @Date：2017/9/8 13:30
     * @return:
     */
    public static Map<String, Object> getUrlParams(String param) {
        Map<String, Object> map = new HashMap<String, Object>(0);
        if (StringUtils.isBlank(param)) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }

    /**
     * 将map转换成URL参数
     *
     * @param:
     * @Author:pinux
     * @Description：
     * @Date：2017/9/8 13:30
     * @return:
     */
    public static String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = org.apache.commons.lang.StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }

    /**
     * 将map转换成URL参数
     *
     * @param:
     * @Author:pinux
     * @Description：
     * @Date：2017/9/8 13:30
     * @return:
     */
    public static String getUrlParamsByMapString(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                sb.append(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = org.apache.commons.lang.StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }


    /**将对象转换为hashmap
     *
     *@param:
     *@Author:pinux
     *@Description：
     *@Date：2017/9/12 11:44
     *@return:
     */
    public static HashMap toHashMap(Object obj) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Class clazz = obj.getClass();
        List<Class> clazzs = new ArrayList<Class>();

        do {
            clazzs.add(clazz);
            clazz = clazz.getSuperclass();
        } while (!clazz.equals(Object.class));

        for (Class iClazz : clazzs) {
            Field[] fields = iClazz.getDeclaredFields();
            for (Field field : fields) {
                Object objVal = null;
                field.setAccessible(true);
                try {
                    objVal = field.get(obj);
                    if (objVal instanceof Date && objVal != null) {
                        objVal = parseToString((Date) objVal, "yyyy-MM-dd HH:mm:SS");
                    }else if (objVal == null) {
                        objVal = "";
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                hashMap.put(field.getName(), objVal);
            }
        }

        return hashMap;
    }

    /**
     * 将以,连接的字符串转换成map参数
     *
     * @param:
     * @Author:pinux
     * @Description：
     * @Date：2017/9/8 13:30
     * @return:
     */
    public static Map<String, Object> getStringParams(String param) {
        Map<String, Object> map = new HashMap<String, Object>(0);
        if (StringUtils.isBlank(param)) {
            return map;
        }
        String[] params = param.split(",");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }

}
