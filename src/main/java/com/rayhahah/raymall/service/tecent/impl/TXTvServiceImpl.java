package com.rayhahah.raymall.service.tecent.impl;

import com.rayhahah.raymall.common.Const;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.dao.ESLiveMapper;
import com.rayhahah.raymall.dao.ESUserMapper;
import com.rayhahah.raymall.pojo.ESLive;
import com.rayhahah.raymall.pojo.ESUser;
import com.rayhahah.raymall.service.tecent.ITXTvService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecentcloud.TencentLive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/12
 * @tips 这个类是Object的子类
 * @fuction
 */
@Service("iTXTvServie")
public class TXTvServiceImpl implements ITXTvService {

    @Autowired
    private ESLiveMapper esLiveMapper;

    @Autowired
    private ESUserMapper esUserMapper;

    @Override
    public ServerResponse<Map<String, String>> insertPushLive(String username) {
        Map<String, String> map = new HashMap<>();
        ESUser esUser = esUserMapper.queryByUsername(username);
        if (esUser == null) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        ESLive esLive = TencentLive.getPushUrl(20);
        esLive.setUsername(username);
        esLive.setScreenname(esUser.getScreenname());
        esLive.setPicUrl("");
        esLive.setLiveStatus(Const.Tecent.STATUS_OFF_LINE);
        int rowId = esLiveMapper.insert(esLive);
        if (rowId > 0) {
            return getPushUrlServerResponse(username, map, esLive);
        }
        return ServerResponse.createByErrorMessage("获取推流地址失败");
    }

    private ServerResponse<Map<String, String>> getPushUrlServerResponse(String username, Map<String, String> map, ESLive esLive) {
        map.put("username", username);
        map.put("msg", "success");
        map.put("pushUrl", esLive.getPushUrl());
        map.put("streamId", esLive.getStreamId());
        return ServerResponse.createBySuccess("获取推流成功", map);
    }

    @Override
    public ServerResponse<List<Map<String, String>>> getCurrentLive() {
        List<ESLive> esLiveList = esLiveMapper.queryAllLiveByStatus("1");
        if (esLiveList.size() <= 0) {
            return ServerResponse.createBySuccessMessage("当前无正在直播");
        }
        List<Map<String, String>> mapList = new ArrayList<>();
        for (ESLive esLive : esLiveList) {
            Map<String, String> map = new HashMap<>();
            map.put("username", esLive.getUsername());
            map.put("screenname", esLive.getScreenname());
            map.put("streamId", esLive.getStreamId());
            map.put("rtmpUrl", esLive.getRtmpUrl());
            map.put("flvUrl", esLive.getFlvUrl());
            map.put("hlsUrl", esLive.getHlsUrl());
            map.put("liveStatus", esLive.getLiveStatus());
            map.put("picUrl", esLive.getPicUrl());
            mapList.add(map);
        }
        return ServerResponse.createBySuccess("获取直播列表成功", mapList);
    }

    @Override
    public void updateESLiveStatusByStreamId(String steamId, String status) {
        if (StringUtils.isBlank(steamId)) {
            return;
        }
        esLiveMapper.updateStatusByStreamId(steamId, status);
    }

    @Override
    public void updateESLivePicByStreamId(String streamId, String picUrl) {
        if (StringUtils.isBlank(streamId) || StringUtils.isBlank(picUrl)) {
            return;
        }
        esLiveMapper.updatePicUrlByStreamId(streamId, picUrl);
    }

    @Override
    public void updateESLiveVideoByStreamId(String streamId, String videoUrl) {
        if (StringUtils.isBlank(streamId) || StringUtils.isBlank(videoUrl)) {
            return;
        }
        esLiveMapper.updateVideoUrlByStreamId(streamId, videoUrl);
    }
}
