package com.rayhahah.raymall.service.jijian;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.JiJianAppIp;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/10/9
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface IJiJianAppIpService {
    ServerResponse<JiJianAppIp> getUrlByName(String name);

    ServerResponse<JiJianAppIp> insertUrlByName(String name, String url);

    ServerResponse<JiJianAppIp> updateUrlByName(String name, String url);
}
