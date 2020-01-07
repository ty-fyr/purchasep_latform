package com.hospital.purchase.controller;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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

    @Autowired
    private PurchaseService purchaseService;
    @RequestMapping("/query")
    public String query(){
        return "login";
    }
    //跳转到退货页面
    @RequestMapping("/select")
    public String select(){

        return "return_goods_info";
    }

    //跳转到采购单查询

    @RequestMapping("/purchaseQuery")
    public ModelAndView purchaseQueryAll(ModelAndView modelAndView){
        List<Purchase> purchases = purchaseService.selectAll();
        modelAndView.addObject("purchases",purchases);
        modelAndView.setViewName("transaction_statistics_query");
        return modelAndView;
    }
/*    //跳转到采购单查询
    @RequestMapping("/purchaseQuery")
    public ModelAndView purchaseQuery(SearchDTO searchDto, ModelAndView modelAndView){
        List<Purchase> purchases = purchaseService.selectBySearchBean(searchDto);

        modelAndView.addObject("purchases",purchases);
        modelAndView.setViewName("transaction_statistics_query");
        return modelAndView;
    }*/
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
