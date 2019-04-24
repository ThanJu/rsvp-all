package com.highteam.router.log.service.impl;

import com.highteam.router.log.model.Log;
import com.highteam.router.log.service.LogService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service("consoleOutLogServiceImpl")
public class ConsoleOutLogServiceImpl implements LogService {

    @Override
    public void recordLog(Log log) {
        Class c = log.getClass();
        try {
            System.out.println("--------------------Log Start--------------------");
            for(Field field : c.getDeclaredFields()){
                field.setAccessible(true);
                System.out.println(field.getName()+" : "+field.get(log));
            }
            System.out.println("--------------------Log End  --------------------");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
