package com.gohan.button.worker;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired DataPooling dataPooling;
    
    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void reportCurrentTime() throws JsonProcessingException, IOException {
        log.info("The time is now {}", dateFormat.format(new Date()));
        String sessionID = dataPooling.login();
        String vehicleID = dataPooling.getInfoVehicle(sessionID);        
        String result = dataPooling.getStatusAlarm(sessionID,vehicleID);
        dataPooling.logout(sessionID);    
    }
}