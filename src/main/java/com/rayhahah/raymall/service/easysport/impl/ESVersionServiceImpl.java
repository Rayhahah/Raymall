package com.rayhahah.raymall.service.easysport.impl;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.dao.ESVersionMapper;
import com.rayhahah.raymall.pojo.ESVersion;
import com.rayhahah.raymall.service.easysport.IESVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/19
 * @tips 这个类是Object的子类
 * @fuction
 */
@Service("iESVersionService")
public class ESVersionServiceImpl implements IESVersionService {

    @Autowired
    private ESVersionMapper esVersionMapper;

    @Override
    public ServerResponse<ESVersion> checkVersion() {
        ESVersion esVersion = esVersionMapper.queryLatestVersion();
        if (esVersion != null) {
            return ServerResponse.createBySuccess("获取版本信息成功",esVersion);
        }
        return ServerResponse.createByErrorMessage("当前没有最新版本");
    }
}
