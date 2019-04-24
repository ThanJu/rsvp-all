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
import java.util.Date;

/**
 * 新建活动
 * */
@Service
public class AddDataRegister extends AbstractRouteAdapater {
    @Autowired
    private DataRegisterMapper dataRegisterMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject requestParam = JSONObject.parseObject(JSON.toJSONString(param.getModel()));
        DataRegister dataRegister =requestParam.getObject("dataRegister",DataRegister.class);
        if (dataRegister == null){
            throw new BusinessException("请求数据为空");
        }else {
            dataRegister.setCreateTime(new Date());

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    dataRegisterMapper.insertSelective(dataRegister);
                }
            });
        }
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataRegister-dataRegister-addDataRegister").toString();
    }
}
