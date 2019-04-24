package com.highteam.router.request.configDict;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.ConfigDictMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.ConfigDict;
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
public class AddConfigDict extends AbstractRouteAdapater {
    @Autowired
    private ConfigDictMapper configDictMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject requestParam = JSONObject.parseObject(JSON.toJSONString(param.getModel()));
        ConfigDict configDict =requestParam.getObject("configDict",ConfigDict.class);
        if (configDict == null){
            throw new BusinessException("请求数据为空");
        }else {
            configDict.setCreateTime(new Date());

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    configDictMapper.insertSelective(configDict);
                }
            });
        }
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("configDict-configDict-addConfigDict").toString();
    }
}
