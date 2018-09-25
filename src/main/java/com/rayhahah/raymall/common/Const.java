package com.rayhahah.raymall.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by leizh on 2017/9/10.
 */
public class Const {


    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Tecent {
        String KEY = "10abeb6a3699b91da1a628eb233c6aec";
        String API_KEY = "8e603017734201d0b92fa829cde3cf47";
        String DEFAULT_RTMP = "rtmp://11148.livepush.myqcloud.com/live/11148_1ecd1b8c26?bizid=11148&txSecret=6ee210f1ba4cbf976779a2471c33a0f2&txTime=59BBF8FF";

        String STATUS_OFF_LINE = "0";
        String STATUS_ON_LINE = "1";
        String STATUS_RECORD_READY = "100";

        String STREAM_ID = "stream_id";
        String EVENT_TYPE = "event_type";

        String EVENT_TYPE_BREAK = "0";
        String EVENT_TYPE_PUSH = "1";
        String EVENT_TYPE_RECORD = "100";
        String EVENT_TYPE_SCREENSHOT = "200";
        String PIC_URL = "pic_url";
        String VIDEO_URL = "video_url";
    }

    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    public interface Cart {
        int CHECKED = 1;//即购物车选中状态
        int UN_CHECKED = 0;//购物车中未选中状态

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }

    public interface Role {
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }

    public enum ProductStatusEnum {
        ON_SALE(1, "在线");
        private String value;
        private int code;

        ProductStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }


    public enum OrderStatusEnum {
        CANCELED(0, "已取消"),
        NO_PAY(10, "未支付"),
        PAID(20, "已付款"),
        SHIPPED(40, "已发货"),
        ORDER_SUCCESS(50, "订单完成"),
        ORDER_CLOSE(60, "订单关闭");


        OrderStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static OrderStatusEnum codeOf(int code) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (orderStatusEnum.getCode() == code) {
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("么有找到对应的枚举");
        }
    }

    public interface OrderBy {
        Set<String> TIME_ASC_DESC = Sets.newHashSet("time_desc", "time_asc");
        String TIME_COLUMN = "update_time";

        Set<String> DOWNLOAD_ASC_DESC = Sets.newHashSet("download_desc", "download_asc");
        String DOWNLOAD_COLUMN = "download";

        Set<String> CATEGORY_ASC_DESC = Sets.newHashSet("category_desc", "category_asc");
        String CATEGORY_ORDER_COLUMN = "category_order";


        Set<String> HOT_ASC_DESC = Sets.newHashSet("hot_desc", "hot_asc");
        String HOT_COLUMN = "hot";


        /**
         * 降序
         * 最新在最上面
         */
        String DESC = "desc";
        /**
         * 升序
         * 最久在最上面
         */
        String ASC = "asc";
    }

    public interface AlipayCallback {
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }


    public enum PayPlatformEnum {
        ALIPAY(1, "支付宝");

        PayPlatformEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PaymentTypeEnum {
        ONLINE_PAY(1, "在线支付");

        PaymentTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


        public static PaymentTypeEnum codeOf(int code) {
            for (PaymentTypeEnum paymentTypeEnum : values()) {
                if (paymentTypeEnum.getCode() == code) {
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("么有找到对应的枚举");
        }

    }
}
