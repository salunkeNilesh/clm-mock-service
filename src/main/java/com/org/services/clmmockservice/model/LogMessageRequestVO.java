package com.org.services.clmmockservice.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class LogMessageRequestVO {

    private BigDecimal applicationId;

    private String applicationName;

    private Map<String,Object> message;

}
