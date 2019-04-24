package com.highteam.router.log.service.impl;


import com.highteam.router.dao.AppLogMapper;
import com.highteam.router.log.model.Log;
import com.highteam.router.log.service.LogService;
import com.highteam.router.model.AppLogWithBLOBs;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service("databaseLogService")
public class DatabaseLogServiceImpl implements LogService {

    @Autowired
    private AppLogMapper appLogMapper;
    @Override
    public void recordLog(Log log) {
        AppLogWithBLOBs appLog = new AppLogWithBLOBs();
        BeanUtils.copyProperties(log,appLog);
        Set<Map.Entry<String,String>> entries = log.getHeaders().entrySet();
        StringBuilder headers = new StringBuilder();
        for (Map.Entry<String,String> entry : entries){
            String key = entry.getKey();
            String value = entry.getValue();
            if("User-Agent".equalsIgnoreCase(key)||"Content-Type".equalsIgnoreCase(key)||"Authorization".equalsIgnoreCase(key)) {
                headers.append(key + "\t:\t" + value + ";\n");
            }
        }
        appLog.setHeaders(headers.toString());
        appLogMapper.insertSelective(appLog);
    }
}
