package com.highteam.router.request.activityPage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.ActivityPageMapper;
import com.highteam.router.enums.ActivityPageStatusEnum;
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
import java.util.Date;

/**
 * 添加活动配置页面
 * */
@Service
public class AddActivityPage extends AbstractRouteAdapater {
    @Autowired
    private ActivityPageMapper activityPageMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject requestParam = JSONObject.parseObject(JSON.toJSONString(param.getModel()));
        ActivityPage activityPage =requestParam.getObject("activityPage",ActivityPage.class);
        if (activityPage == null){
            throw new BusinessException("请求数据为空");
        }else {
            Date currentDate = new Date();
            activityPage.setCreateId(userInfo.getUserId());
            activityPage.setCreateName(userInfo.getUserRealName());
            activityPage.setCreateTime(currentDate);
            activityPage.setStatus(ActivityPageStatusEnum.VALID.getCode());

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    activityPageMapper.insertSelective(activityPage);
                }
            });
        }
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("activityPage-activityPage-addActivityPage").toString();
    }
}
