package com.rayhahah.raymall.service.netsource.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayhahah.raymall.common.Const;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.dao.NetSourceComicMapper;
import com.rayhahah.raymall.pojo.NetSourceComic;
import com.rayhahah.raymall.service.netsource.INSComicService;
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
@Service("iNSComicService")
public class NSComicServiceImpl implements INSComicService {

    @Autowired
    private NetSourceComicMapper netSourceComicMapper;

    @Override
    public ServerResponse<PageInfo> query(int id, String from, String title, String author, String category, String status, String label, int pageNum, int pageSize, String orderBy) {

        PageHelper.startPage(pageNum, pageSize);
        //排序处理
        if (StringUtils.isNotBlank(orderBy)) {
            if (Const.OrderBy.TIME_ASC_DESC.contains(orderBy)) {
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(Const.OrderBy.TIME_COLUMN + " " + orderByArray[1]);
            }
        }
        List<NetSourceComic> collections = netSourceComicMapper.query(id, from, title, author, category, status, label);
        PageInfo pageResult = new PageInfo(collections);
        return ServerResponse.createBySuccess("Success", pageResult);
    }
}
