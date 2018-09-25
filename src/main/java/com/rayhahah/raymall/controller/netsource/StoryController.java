package com.rayhahah.raymall.controller.netsource;

import com.github.pagehelper.PageInfo;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.NetSourceStory;
import com.rayhahah.raymall.service.netsource.INSStoryService;
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
@RequestMapping("/netsource/story")
public class StoryController {

    @Autowired
    private INSStoryService storyService;


    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<NetSourceStory> add(NetSourceStory story) {
        return storyService.add(story);
    }

    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<NetSourceStory> update(NetSourceStory story) {
        return storyService.update(story);
    }

    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delete(int id) {
        return storyService.delete(id);
    }

    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> query(@RequestParam(value = "id", defaultValue = "0") int id,
                                          @RequestParam(value = "storyFrom", defaultValue = "") String from,
                                          @RequestParam(value = "storyTitle", defaultValue = "") String title,
                                          @RequestParam(value = "storyContent", defaultValue = "") String content,
                                          @RequestParam(value = "storyCategory", defaultValue = "") String category,
                                          @RequestParam(value = "storyLabel", defaultValue = "") String label,
                                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                          @RequestParam(value = "orderBy", required = false, defaultValue = "time_desc") String orderBy) {
        return storyService.query(id, from, title, content, category, label, pageNum, pageSize, orderBy);
    }

}
