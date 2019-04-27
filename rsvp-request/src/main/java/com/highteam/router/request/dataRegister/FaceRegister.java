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
 * 添加注册信息
 */
@Service
public class FaceRegister extends AbstractRouteAdapater {
    @Autowired
    private DataRegisterMapper dataRegisterMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject requestParam = JSONObject.parseObject(JSON.toJSONString(param.getModel()));
//        {"optType":1,"applyId":3311,"uUserId":"17611030057","projectToken":"228C80FEA87149E293C6F960D2F3817E",
//                "item1":"海天","appId":15999957,"groupId":"star","name":"港哥","logId":155639750762569,
//                "channelType":1,"telephone":"17611030057",
//                "faceImage":"http://bj.bcebos.com/v1/aip-web/BD99B264021943C2A7B328020484D37D?authorization=bce-auth-v1%2Ff86a2044998643b5abc89b59158bad6d%2F2019-04-27T20%3A36%3A59Z%2F-1%2F%2Fa02a50b82b3f4d89316cfe44e89a6e093d1bc3b83a239a42992e61249524f776"}

        if (requestParam == null) {
            throw new BusinessException("请求数据为空");
        } else {
            DataRegister dataRegister = new DataRegister();
            switch (requestParam.get("optType").toString()) {
                case "1":
                    //审核通过--执行添加注册信息操作

                    dataRegister.setWorkPhone(requestParam.get("telephone").toString());
                    dataRegister.setUserName(requestParam.get("name").toString());
                    dataRegister.setCompanyName(requestParam.get("item1").toString());
                    dataRegister.setCreateTime(new Date());
                    dataRegister.setStatus(1);

                    DataRegister modefiyRegister = new DataRegister();
                    modefiyRegister.setStatus(3);
                    modefiyRegister.setWorkPhone(dataRegister.getWorkPhone());
                    transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                        @Override
                        protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                            //更新已存在的注册信息
                            dataRegisterMapper.updateByPhoneSelective(modefiyRegister);
                            //添加新的注册信息
                            dataRegisterMapper.insertSelective(dataRegister);
                        }
                    });
                    break;
                case "2":
                    //驳回---
                    dataRegister.setWorkPhone(requestParam.get("telephone").toString());
                    dataRegister.setUserName(requestParam.get("name").toString());
                    dataRegister.setCompanyName(requestParam.get("item1").toString());
                    dataRegister.setCreateTime(new Date());
                    dataRegister.setStatus(2);

                    transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                        @Override
                        protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                            dataRegisterMapper.insertSelective(dataRegister);
                        }
                    });
                    break;
                case "3":
                    //删除--删除注册信息（修改注册状态）

                    dataRegister.setCreateTime(new Date());
                    dataRegister.setWorkPhone(requestParam.get("telephone").toString());
                    dataRegister.setStatus(3);//更新至删除状态
                    transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                        @Override
                        protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                            dataRegisterMapper.updateByPhoneSelective(dataRegister);
                        }
                    });
                    break;
            }
        }
        return true;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataRegister-dataRegister-faceRegister").toString();
    }

    @Override
    public boolean requiredAuthor() {
        return false;
    }
}
