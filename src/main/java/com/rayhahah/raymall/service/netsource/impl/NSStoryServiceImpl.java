package com.rayhahah.raymall.service.netsource.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayhahah.raymall.common.Const;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.dao.NetSourceStoryMapper;
import com.rayhahah.raymall.pojo.NetSourceStory;
import com.rayhahah.raymall.service.netsource.INSStoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/19
 * @tips 这个类是Object的子类
 * @fuction
 */
@Service("iNSStoryService")
public class NSStoryServiceImpl implements INSStoryService {

    @Autowired
    private NetSourceStoryMapper netSourceStoryMapper;

    @Override
    public ServerResponse<NetSourceStory> add(NetSourceStory story) {
        if (StringUtils.isBlank(story.getStoryTitle())) {
            return ServerResponse.createByErrorMessage("Story title can not be empty");
        }

        int result = netSourceStoryMapper.insert(story);
        if (result > 0) {
            return ServerResponse.createBySuccess("Success", story);
        }
        return ServerResponse.createByErrorMessage("Add story failure");
    }

    @Override
    public ServerResponse<NetSourceStory> update(NetSourceStory story) {
        int result = netSourceStoryMapper.updateByPrimaryKeySelective(story);
        if (result > 0) {
            return ServerResponse.createBySuccess("Success", story);
        }
        return ServerResponse.createByErrorMessage("Update story failure");
    }

    @Override
    public ServerResponse<String> delete(int id) {
        if (id <= 0) {
            return ServerResponse.createByErrorMessage("Id is not exist");
        }
        int result = netSourceStoryMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return ServerResponse.createBySuccess("Delete story success");
        }

        return ServerResponse.createByErrorMessage("Delete story failure");
    }

    @Override
    public ServerResponse<PageInfo> query(int id, String from, String title, String content, String category, String label, int pageNum, int pageSize, String orderBy) {

        PageHelper.startPage(pageNum, pageSize);
        //排序处理
        if (StringUtils.isNotBlank(orderBy)) {
            if (Const.OrderBy.TIME_ASC_DESC.contains(orderBy)) {
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(Const.OrderBy.TIME_COLUMN + " " + orderByArray[1]);
            }
        }
        List<NetSourceStory> collections = netSourceStoryMapper.query(id, from, title, content, category, label);
        PageInfo pageResult = new PageInfo(collections);
        return ServerResponse.createBySuccess("Success", pageResult);
    }
}
