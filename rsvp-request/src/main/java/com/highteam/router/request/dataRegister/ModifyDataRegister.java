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
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改注册信息
 */
@Service
public class ModifyDataRegister extends AbstractRouteAdapater {

    @Autowired
    private DataRegisterMapper dataRegisterMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {

        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        DataRegister dataRegister = requestParam.getObject("dataRegister",DataRegister.class);
        if(dataRegister == null){
            throw new BusinessException("请求参数不正确！");
        }
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                dataRegisterMapper.updateByPrimaryKeySelective(dataRegister);
            }
        });
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataRegister-dataRegister-modifyDataRegister").toString();
    }

}
