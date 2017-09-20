package com.rayhahah.raymall.controller.easysport;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.ESUser;
import com.rayhahah.raymall.service.easysport.IESUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/11
 * @tips 这个类是Object的子类
 * @fuction
 */
@Controller
@RequestMapping("/easysport/user")
public class ESUserController {

    @Autowired
    private IESUserService iesUserService;


    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<ESUser> register(ESUser user) {
        return iesUserService.register(user);
    }

    @RequestMapping(value = "get_user_info.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<ESUser> getUserInfo(String username,String password) {
        return iesUserService.getUserInfo(username,password);
    }


    @RequestMapping(value = "forget_get_question.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username) {
        return iesUserService.selectQuestion(username);
    }


    @RequestMapping(value = "forget_check_answer.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
        return iesUserService.checkAnswer(username, question, answer);
    }


    @RequestMapping(value = "forget_reset_password.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken) {
        return iesUserService.forgetResetPassword(username, passwordNew, forgetToken);
    }


    @RequestMapping(value = "reset_password.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(String username, String passwordOld, String passwordNew) {
        return iesUserService.resetPassword(username,passwordOld, passwordNew);
    }

    @RequestMapping(value = "update_hupuinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateHupuInfo(String username, String password, String hupuUsername, String hupuPassword) {
        return iesUserService.updateHupuInfo(username,password,hupuUsername,hupuPassword);
    }

    @RequestMapping(value = "update_normalinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateNormalInfo(String username, String password, String screenname, String email,String phone,String question,String answer) {
        return iesUserService.updateNormalInfo(username,password,screenname,email,phone,question,answer);
    }

    @RequestMapping(value = "update_cover.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateCover(String username, String password,String cover) {
        return iesUserService.updateCover(username,password,cover);
    }


}
