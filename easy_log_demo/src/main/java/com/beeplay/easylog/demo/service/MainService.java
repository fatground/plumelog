package com.beeplay.easylog.demo.service;


import com.beeplay.easylog.core.util.LogExceptionStackTrace;
import com.beeplay.easylog.trace.annotation.Trace;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MainService.class);

    @Autowired
    TankService tankService;

    @Trace
    public void testLog() {
        System.out.println("testLog===>" + System.currentTimeMillis());
        try {
            say(System.currentTimeMillis() + "ppp");
            tankService.tankSay();
        } catch (Exception e) {
            logger.error("{}", LogExceptionStackTrace.erroStackTrace(e));
        }
    }

    public void say(String name) {
        System.out.println("say===>" + name);
    }
}