package com.highteam.router.request.activitySignWay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.ActivitySignWayMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.ActivitySignWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 添加签到方式
 * */
@Service
public class AddActivitySignWay extends AbstractRouteAdapater {
    @Autowired
    private ActivitySignWayMapper activitySignWayMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject requestParam = JSONObject.parseObject(JSON.toJSONString(param.getModel()));
        ActivitySignWay activitySignWay =requestParam.getObject("activitySignWay",ActivitySignWay.class);
        if (activitySignWay == null){
            throw new BusinessException("请求数据为空");
        }else {
            activitySignWay.setCreateId(userInfo.getUserId());
            activitySignWay.setCreateName(userInfo.getUserRealName());
            activitySignWay.setCreateTime(new Date());

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    activitySignWayMapper.insertSelective(activitySignWay);
                }
            });
        }
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("activitySignWay-activitySignWay-addActivitySignWay").toString();
    }
}
