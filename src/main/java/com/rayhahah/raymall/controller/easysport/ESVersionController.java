package com.rayhahah.raymall.controller.easysport;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.ESVersion;
import com.rayhahah.raymall.service.easysport.IESVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/19
 * @tips 这个类是Object的子类
 * @fuction
 */
@Controller
@RequestMapping("/easysport/version")
public class ESVersionController {

    @Autowired
    private IESVersionService iesVersionService;

    // TODO: 2017/9/20 Easysport版本更新模块

    @RequestMapping(value = "check.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<ESVersion> checkVersion() {
        return iesVersionService.checkVersion();
    }
}
