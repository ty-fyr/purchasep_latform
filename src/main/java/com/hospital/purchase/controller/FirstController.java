package com.hospital.purchase.controller;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @ProjectName: hospital
 * @Package: com.hospital.purchase.web
 * @ClassName: FirstController
 * @Author: 85235
 * @Description: ${description}
 * @Date: 2019/12/28 14:28

 */
@Controller
public class FirstController {
    public static final Logger LOGGER = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private PurchaseService purchaseService;



    //跳转到采购单查询

    @RequestMapping("/purchaseQuery")
        public ModelAndView purchaseQueryAll(ModelAndView modelAndView){
            try {
                List<Purchase> purchases = purchaseService.selectAll();
                modelAndView.addObject("purchases",purchases);
                modelAndView.setViewName("transaction_statistics_query");
                LOGGER.info("FirstController-------purchaseQuery-----成功"+purchases);
            }catch (Exception e){
                LOGGER.info("FirstController-------purchaseQuery------错误");
            }
        return modelAndView;
    }
    //采购单搜索
    @RequestMapping("/SearchPurchaseQuery")
    public ModelAndView SearchPurchaseQuery(SearchDTO searchDTO, ModelAndView modelAndView){
        List<Purchase> purchases = purchaseService.selectBySearchBean(searchDTO);

        modelAndView.addObject("purchases",purchases);
        modelAndView.setViewName("transaction_statistics_query");
        return modelAndView;
    }
    //跳转到供货商查询
    @RequestMapping("/supplierQuery")
    public String supplierQuery(ModelMap map){
        List<Purchase> purchaseList = purchaseService.selectAllSupplier();
        map.put("purchaseList",purchaseList);
        return "supplier_query";
    }
    //查询全部供货商
    @ResponseBody
    @RequestMapping("querySupplier")
    public List<Supplier> querySupplier(){
        List<Supplier> supplier = purchaseService.findSupplier();
        return supplier;
    }

    //供货商搜索
    @ResponseBody
    @RequestMapping("searchSupplier")
    public ModelAndView SearchSupplier(ModelAndView modelAndView,SearchDTO searchDTO){
        List<Purchase> purchaseList = purchaseService.selectBySupplier(searchDTO);
        modelAndView.addObject("purchaseList",purchaseList);
        modelAndView.setViewName("supplier_query");
        return modelAndView;
    }
    //跳转到采购医院查询
    @RequestMapping("/buyHospitalQuery")
    public String buyHospitalQuery(ModelMap map) {
        List<Purchase> purchaseList = purchaseService.selectAllHospital();
        map.put("purchaseList",purchaseList);
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


    @RequestMapping("/query")
    public String query(){
        return "login";
    }
    //跳转到退货页面
    @RequestMapping("/select")
    public String select(){

        return "return_goods_info";
    }

}
