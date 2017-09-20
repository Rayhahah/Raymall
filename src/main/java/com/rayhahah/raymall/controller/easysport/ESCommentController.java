package com.rayhahah.raymall.controller.easysport;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.ESComment;
import com.rayhahah.raymall.service.easysport.IESCommentService;
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
@RequestMapping("/easysport/comment")
public class ESCommentController {

    @Autowired
    private IESCommentService iesCommentService;



    @RequestMapping(value = "commit.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> commit(ESComment esComment) {
        return iesCommentService.commit(esComment);
    }



}
