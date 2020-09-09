package com.org.services.clmmockservice.controller;

import com.org.services.clmmockservice.model.LogMessageRequestVO;
import com.org.services.clmmockservice.model.LogMessageResponseVO;
import com.org.services.clmmockservice.utils.ResponseUtils;
import org.apache.tomcat.util.http.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;

@RestController
public class LogMessage {

    @Autowired
    Environment env;

    @PostMapping(value = "/logMessage", consumes = "application/json",produces = "application/json")
    public ResponseEntity<LogMessageResponseVO> logMessage(@RequestBody LogMessageRequestVO requestVO) throws InterruptedException {

        if(requestVO.getApplicationName().endsWith("500")){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else if(requestVO.getApplicationName().endsWith("404")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else if(requestVO.getApplicationName().endsWith("204")){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else if(requestVO.getApplicationName().endsWith("TimeoutOver")){
            Thread.sleep(Long.parseLong(env.getProperty("api.connect.timout.over")));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LogMessageResponseVO response = ResponseUtils.readJsonFile("200Ok");

        return new ResponseEntity<LogMessageResponseVO>(response,HttpStatus.OK);

    }

}
