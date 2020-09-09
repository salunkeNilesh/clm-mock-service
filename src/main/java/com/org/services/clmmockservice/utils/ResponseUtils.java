package com.org.services.clmmockservice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.services.clmmockservice.model.LogMessageResponseVO;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResponseUtils {

    @SneakyThrows
    public static LogMessageResponseVO readJsonFile(String filename) {
        FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\response\\" + filename + ".json"));

        ObjectMapper mapper = new ObjectMapper();
        LogMessageResponseVO responseVO = mapper.readValue(file, LogMessageResponseVO.class);

        return responseVO;

    }

}
