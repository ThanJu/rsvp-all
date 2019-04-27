package com.highteam.router.request.activityPage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.ActivityPageMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.ActivityPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改配置页面
 */
@Service
public class ModifyActivityPage extends AbstractRouteAdapater {

    @Autowired
    private ActivityPageMapper activityPageMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {

        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        ActivityPage activityPage = requestParam.getObject("activityPage",ActivityPage.class);
        if(activityPage == null){
            throw new BusinessException("请求参数不正确！");
        }
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                activityPageMapper.updateByPrimaryKeySelective(activityPage);
            }
        });
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("activityPage-activityPage-modifyActivityPage").toString();
    }

}
