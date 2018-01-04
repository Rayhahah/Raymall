package com.rayhahah.raymall.service.jijian.impl;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.dao.JiJianAppIpMapper;
import com.rayhahah.raymall.pojo.JiJianAppIp;
import com.rayhahah.raymall.service.jijian.IJiJianAppIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/10/9
 * @tips 这个类是Object的子类
 * @fuction
 */
@Service("iJiJianAppIpService")
public class JiJianAppIpServiceImpl implements IJiJianAppIpService {

    @Autowired
    private JiJianAppIpMapper jiJianAppIpMapper;

    @Override
    public ServerResponse<JiJianAppIp> getUrlByName(String name) {
        JiJianAppIp appIp = jiJianAppIpMapper.queryByName(name);
        if (appIp != null) {
            return ServerResponse.createBySuccess("获取访问信息成功", appIp);
        } else {
            return ServerResponse.createByErrorMessage("没有找到相关信息");
        }
    }

    @Override
    public ServerResponse<JiJianAppIp> insertUrlByName(String name, String url) {
        JiJianAppIp appIp = jiJianAppIpMapper.queryByName(name);
        if (appIp == null) {
            JiJianAppIp jianAppIp = new JiJianAppIp();
            jianAppIp.setName(name);
            jianAppIp.setUrl(url);
            int insert = jiJianAppIpMapper.insert(jianAppIp);
            if (insert > 0) {
                return ServerResponse.createBySuccess("获取访问信息成功", appIp);
            } else {
                return ServerResponse.createByErrorMessage("新增失败~");
            }
        } else {
            return ServerResponse.createByErrorMessage("name已存在/(ㄒoㄒ)/~~");
        }
    }

    @Override
    public ServerResponse<JiJianAppIp> updateUrlByName(String name, String url) {
        JiJianAppIp appIp = jiJianAppIpMapper.queryByName(name);
        if (appIp == null) {
            return ServerResponse.createByErrorMessage("name不存在/(ㄒoㄒ)/~~");
        } else {
            appIp.setUrl(url);
            int update = jiJianAppIpMapper.updateByPrimaryKeySelective(appIp);
            if (update > 0) {
                return ServerResponse.createBySuccess("更新数据成功", appIp);
            } else {
                return ServerResponse.createByErrorMessage("更新数据失败");
            }
        }
    }
}
