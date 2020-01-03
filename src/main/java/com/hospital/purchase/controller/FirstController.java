package com.hospital.purchase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @ProjectName: hospital
 * @Package: com.hospital.purchase.web
 * @ClassName: FirstController
 * @Author: 85235
 * @Description: ${description}
 * @Date: 2019/12/28 14:28
 * @Version: 1.0
 */
@Controller
public class FirstController {
    @RequestMapping("/query")
    public String query(){
        return "login";
    }
    @RequestMapping("/find")
    public String find(){
        return "index";
    }

    //跳转到退货页面
    @RequestMapping("/select")
    public String select(){

        return "content";
    }

    //跳转到采购单查询
    @RequestMapping("/purchaseQuery")
    public String purchaseQuery(){
        return "transaction_statistics_query";
    }
    //跳转到供货商查询
    @RequestMapping("/supplierQuery")
    public String supplierQuery(){
        return "supplier_query";
    }
    //跳转到采购医院查询
    @RequestMapping("/buyHospitalQuery")
    public String buyHospitalQuery(){
        return "purchasing_hospital_query";
    }
    //跳转到交易药品查询
    @RequestMapping("/buyDrugsQuery")
    public String buyDrugsQuery(){
        return "trading_drugs";
    }
    //跳转到查询药品交易明细
    @RequestMapping("/buyDrugsInfo")
    public String buyDrugsInfo(){
        return "trading_drugs_info";
    }
}
