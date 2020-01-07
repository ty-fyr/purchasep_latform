package com.hospital.purchase.controller;

import com.hospital.purchase.common.enums.ErrorEnum;
import com.hospital.purchase.common.exception.PurchasepRuntimeException;
import com.hospital.purchase.common.model.ResultBean;
import com.hospital.purchase.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/result")
public class ResultBeanController {
    private static final Logger LOG = LoggerFactory.getLogger(ResultBeanController.class);

    @GetMapping(value = "/testFail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultBean testFail() {
        LOG.info("接收xxx请求:{}", "xxxx");
        try {
            LOG.info("干活去了");
            throw new RuntimeException("sql exception");
        }catch (PurchasepRuntimeException e){
            return ResultUtil.buildErrorResult(e.getErrorEnum());
        }catch (Exception e) {
            LOG.info("xxx干活异常了,请求:{},expMsg:{}", "", e.getMessage(), e);
            return ResultUtil.buildErrorResult(ErrorEnum.SYSTEM_ERROR);
        }
    }

    @GetMapping(value = "/testSuccess", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultBean testSuccess() {
        LOG.info("接收xxx请求:{}", "xxxx");
        try {
            LOG.info("干活去了");
            String result = "我吃了吃了吃了吃了===============";
            LOG.info("干活结果:{}", result);
            return ResultUtil.buildSuccessResult(result);
        } catch (Exception e) {
            LOG.info("xxx干活异常了,请求:{},expMsg:{}", "", e.getMessage(), e);
            return ResultUtil.buildErrorResult(ErrorEnum.SYSTEM_ERROR);
        }
    }
}
