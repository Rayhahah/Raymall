package com.rayhahah.raymall.service.easysport.impl;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.dao.ESCrashMessageMapper;
import com.rayhahah.raymall.pojo.ESCrashMessage;
import com.rayhahah.raymall.service.easysport.IESCrashMessageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/11
 * @tips 这个类是Object的子类
 * @fuction
 */
@Service("iESCrashMessageService")
public class ESCrashMessageServiceImpl implements IESCrashMessageService {

    @Autowired
    private ESCrashMessageMapper esCrashMessageMapper;

    @Override
    public ServerResponse<String> commit(ESCrashMessage esCrashMessage) {
        if (StringUtils.isBlank(esCrashMessage.getVersionName()) && StringUtils.isBlank(esCrashMessage.getVersionCode())) {
            return ServerResponse.createByErrorMessage("必须要VersionName或VersionCode");
        }

        int count = esCrashMessageMapper.insert(esCrashMessage);
        if (count > 0) {
            return ServerResponse.createBySuccess("上传异常成功");
        }
        return ServerResponse.createByErrorMessage("上传异常失败");
    }
}
