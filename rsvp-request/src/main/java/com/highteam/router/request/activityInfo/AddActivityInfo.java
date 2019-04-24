package com.highteam.router.request.activityInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.ActivityInfoMapper;
import com.highteam.router.enums.ActivityInfoStatusEnum;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.ActivityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 新建活动
 * */
@Service
public class AddActivityInfo extends AbstractRouteAdapater {
    @Autowired
    private ActivityInfoMapper activityInfoMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject requestParam = JSONObject.parseObject(JSON.toJSONString(param.getModel()));
        ActivityInfo activityInfo =requestParam.getObject("activityInfo",ActivityInfo.class);
        if (activityInfo == null){
            throw new BusinessException("请求数据为空");
        }else {
            Date currentDate = new Date();
            activityInfo.setCreateId(userInfo.getUserId());
            activityInfo.setCreateName(userInfo.getUserRealName());
            activityInfo.setCreateTime(currentDate);
            activityInfo.setActivityStatus(ActivityInfoStatusEnum.NOT_START.getCode());
            activityInfo.setActivityStatusName(ActivityInfoStatusEnum.NOT_START.getName());

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    activityInfoMapper.insertSelective(activityInfo);
                }
            });
        }
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("activityInfo-activityInfo-addActivityInfo").toString();
    }
}
