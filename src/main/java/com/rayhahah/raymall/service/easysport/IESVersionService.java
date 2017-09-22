package com.rayhahah.raymall.service.easysport;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.ESVersion;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/19
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface IESVersionService {
    ServerResponse<ESVersion> checkVersion();
}
