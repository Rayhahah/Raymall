package com.rayhahah.raymall.service.jijian.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.dao.JiJianLocationMapper;
import com.rayhahah.raymall.pojo.JiJianLocation;
import com.rayhahah.raymall.service.jijian.IJiJianLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/12/13
 * @fuction
 */
@Service("iJiJianLocationService")
public class JiJianLocationServiceImpl implements IJiJianLocationService {

    @Autowired
    private JiJianLocationMapper jiJianLocationMapper;


    @Override
    public ServerResponse upload(String points) {
        JsonArray jsonArray = new Gson().fromJson(points, JsonArray.class);
        for (JsonElement jsonElement : jsonArray) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            String username = asJsonObject.get("username").getAsString();
            String latitude = asJsonObject.get("latitude").getAsString();
            String longtitude = asJsonObject.get("longtitude").getAsString();
            int time = asJsonObject.get("time").getAsInt();
            JiJianLocation jiJianLocation = new JiJianLocation();
            jiJianLocation.setUsername(username);
            jiJianLocation.setLatitude(latitude);
            jiJianLocation.setLongtitude(longtitude);
            jiJianLocation.setTime((long) time);
            jiJianLocationMapper.insert(jiJianLocation);
        }
        return ServerResponse.createBySuccess("插入坐标成功！");
    }
}
