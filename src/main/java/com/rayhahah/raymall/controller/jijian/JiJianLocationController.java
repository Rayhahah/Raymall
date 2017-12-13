package com.rayhahah.raymall.controller.jijian;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.service.jijian.IJiJianLocationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/12/13
 * @fuction
 */
@Controller
@RequestMapping("/jijian/location")
public class JiJianLocationController {

    @Autowired
    private IJiJianLocationService iJiJianLocationService;

    @RequestMapping(value = "upload.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse upload(@RequestParam(value = "points", required = false) String points) {
        if (StringUtils.isNotBlank(points)) {
            return iJiJianLocationService.upload(points);
        } else {
            return ServerResponse.createByErrorMessage("上传信息不能为空");
        }
    }
}
