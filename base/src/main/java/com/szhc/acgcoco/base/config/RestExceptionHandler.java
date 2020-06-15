package com.szhc.acgcoco.base.config;

import com.szhc.acgcoco.base.dto.ResultDTO;
import com.szhc.acgcoco.base.dto.ResultDTOBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理类似rest风格的接口，返回json
 */
@RestControllerAdvice
public class RestExceptionHandler{
    static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
    /**
     * 返回json
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultDTO restExceptionHandle(Exception e) {
        log.error("error:{}",e);
        return ResultDTOBuilder.failure("00003");
    }

}
