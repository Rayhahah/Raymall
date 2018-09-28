package com.rayhahah.raymall.controller.netsource;

import com.github.pagehelper.PageInfo;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.service.netsource.INSComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2018/9/25
 * @fuction
 */
@Controller
@RequestMapping("/netsource/comic")
public class ComicController {

    @Autowired
    private INSComicService insComicService;

    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> query(@RequestParam(value = "id", defaultValue = "0") int id,
                                          @RequestParam(value = "comicFrom", defaultValue = "") String from,
                                          @RequestParam(value = "comicTitle", defaultValue = "") String title,
                                          @RequestParam(value = "comicAuthor", defaultValue = "") String author,
                                          @RequestParam(value = "comicCategory", defaultValue = "") String category,
                                          @RequestParam(value = "comicStatus", defaultValue = "") String status,
                                          @RequestParam(value = "comicLabel", defaultValue = "") String label,
                                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "15") int pageSize,
                                          @RequestParam(value = "orderBy", required = false, defaultValue = "time_desc") String orderBy) {
        return insComicService.query(id, from, title, author, category, status, label, pageNum, pageSize, orderBy);
    }

}
