package com.highteam.router.request.activityInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.ActivityInfoMapper;
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
 * 修改活动
 */
@Service
public class ModifyActivityInfo extends AbstractRouteAdapater {

    @Autowired
    private ActivityInfoMapper activityInfoMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {

        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        ActivityInfo activityInfo = requestParam.getObject("activityInfo",ActivityInfo.class);
        if(activityInfo == null){
            throw new BusinessException("请求参数不正确！");
        }
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                activityInfoMapper.updateByPrimaryKeySelective(activityInfo);
            }
        });
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("activityInfo-activityInfo-modifyActivityInfo").toString();
    }

}
