package com.rayhahah.raymall.controller.jijian;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.JiJianAppIp;
import com.rayhahah.raymall.service.jijian.IJiJianAppIpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/10/9
 * @tips 这个类是Object的子类
 * @fuction
 */
@Controller
@RequestMapping("/jijian/appip")
public class JiJianAppIpController {

    @Autowired
    private IJiJianAppIpService iJiJianAppIpService;


    @RequestMapping(value = "get_url.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<JiJianAppIp> getUrl(String name) {
        if (StringUtils.isNotBlank(name)) {
            return iJiJianAppIpService.getUrlByName(name);
        } else {
            return ServerResponse.createByErrorMessage("name不能为空");
        }
    }

}
