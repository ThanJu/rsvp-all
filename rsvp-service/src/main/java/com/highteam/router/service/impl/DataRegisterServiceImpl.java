package com.highteam.router.service.impl;

import com.highteam.router.dao.DataRegisterMapper;
import com.highteam.router.model.DataRegister;
import com.highteam.router.service.DataRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class DataRegisterServiceImpl implements DataRegisterService {

    @Autowired
    DataRegisterMapper dataRegisterMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public boolean addRegisterData(DataRegister dataRegister) {
        dataRegisterMapper.insertSelective(dataRegister);

        try {
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    dataRegisterMapper.insertSelective(dataRegister);
                }
            });
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
