package org.wrn.train.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wrn.train.common.exception.BusinessException;
import org.wrn.train.common.resp.CommonResp;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-13 17:09
 **/

@ControllerAdvice
public class ControllerExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResp exceptionHandler(Exception e) throws Exception {
        CommonResp resp = new CommonResp();
        LOGGER.error(e.getMessage(), e);
        resp.setSuccess(false);
        resp.setMessage(e.getMessage());
        return resp;
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp exceptionHandler(BusinessException e) {
        CommonResp commonResp = new CommonResp();
        LOGGER.error("业务异常：{}", e.getE().getDesc());
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getE().getDesc());
        return commonResp;
    }


}
