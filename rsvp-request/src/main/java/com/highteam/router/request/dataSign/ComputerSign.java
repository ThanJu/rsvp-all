package com.highteam.router.request.dataSign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.DataRegisterMapper;
import com.highteam.router.dao.DataSignMapper;
import com.highteam.router.enums.ActivitySignWayTypeEnum;
import com.highteam.router.enums.dataRegisterStatusEnum;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.DataRegister;
import com.highteam.router.model.DataSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 电脑签到
 */
@Service
public class ComputerSign extends AbstractRouteAdapater {
    @Autowired
    private DataSignMapper dataSignMapper;
    @Autowired
    private DataRegisterMapper dataRegisterMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject requestParam = JSONObject.parseObject(JSON.toJSONString(param.getModel()));
        DataSign dataSign =requestParam.getObject("dataSign",DataSign.class);
        if (dataSign == null){
            throw new BusinessException("请求数据为空");
        }else {
            dataSign.setCreateTime(new Date());
            dataSign.setSignType(ActivitySignWayTypeEnum.COMPUTER.getCode());
            dataSign.setSignTypeName(ActivitySignWayTypeEnum.COMPUTER.getName());

            DataRegister dataRegister = new DataRegister();
            dataRegister.setRegisterId(dataSign.getDataRegisterId());
            dataRegister.setStatus(dataRegisterStatusEnum.ALREADY_SIGN.getCode());
            dataRegister.setStatusName(dataRegisterStatusEnum.ALREADY_SIGN.getName());

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    dataRegisterMapper.updateByPrimaryKeySelective(dataRegister);
                    dataSignMapper.insertSelective(dataSign);
                }
            });
        }
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataSign-dataSign-computerSign").toString();
    }
}
