package com.highteam.router.request.dataRegister;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.DataRegisterMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.DataRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询活动人数信息
 */
@Service
public class countDataRegister extends AbstractRouteAdapater {
    @Autowired
    private DataRegisterMapper dataRegisterMapper;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject requestParam = JSONObject.parseObject(JSON.toJSONString(param.getModel()));
        int activityInfoId = requestParam.getInteger("activityInfoId");
        Map<String, Integer> map = new HashMap<>();
        if (activityInfoId == 0) {
            throw new BusinessException("请求数据为空");
        } else {
            List<DataRegister> dataRegisterList = dataRegisterMapper.selectStatusCount(activityInfoId);
            for (DataRegister register : dataRegisterList) {
                switch (register.getStatus()) {
                    case 1:
                        //未签到人数
                        map.put("notSignNum", register.getStatusCount());
                        break;
                    case 2:
                        //已签到人数
                        map.put("alreadySignNum", register.getStatusCount());
                        break;
                    case 3:
                        //审核中人数
                        map.put("auditNum", register.getStatusCount());
                        break;
                    case 4:
                        //审核未通过
                }
            }
            //已注册人数
            int activityRegisterNum = map.get("notSignNum") + map.get("alreadySignNum");
            map.put("activityRegisterNum", activityRegisterNum);
        }

        return map;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataRegister-dataRegister-countDataRegister").toString();
    }
}
