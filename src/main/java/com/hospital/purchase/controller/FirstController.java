package com.hospital.purchase.controller;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.service.PurchaseService;
import com.hospital.purchase.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


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

    /**
     * 导出采购单查询结果
     * @param response
     *
     */
    @RequestMapping("/outputPurchase")
    @ResponseBody
    public void outputPurchase(HttpServletResponse response) {
        List<Purchase> purchaseList = purchaseService.selectAll();
        AtomicInteger index = new AtomicInteger();
        String head = "序号,采购医院,采购单编号,采购单名称,采购状态,开始采购时间,结束采购时间,建单时间,提交时间,审核时间,采购量,采购金额";
        String body = purchaseList
                .stream()
                .map(item -> item.formatToOutputCsv(index.incrementAndGet()))
                .collect(Collectors.joining("\n"));
        long orderQuantity = purchaseList.stream().mapToLong(item -> item.getTransactionInfo().getOrderQuantity()).sum();
        double orderAmount = purchaseList.stream().mapToDouble(item -> item.getTransactionInfo().getOrderAmount()).sum();
        String foot = String.format(",合计,,,,,,,,,%d,%.2f", orderQuantity, orderAmount);
        StringJoiner fileContentJoiner = new StringJoiner("\n").add(head);
        if (StringUtils.isNotEmpty(body)) {
            fileContentJoiner.add(body);
        }
        String fileContent = fileContentJoiner.add(foot).toString();
        FileUtil.outputCsvFile(response, "采购单信息.csv", fileContent);
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
    /**
     * 导出供货商查询结果
     * @param response
     * @param searchDTO
     */
    @RequestMapping("/outputSupplier")
    @ResponseBody
    public void outputSupplier(HttpServletResponse response, SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseService.selectAllSupplier();
        AtomicInteger index = new AtomicInteger();
        String head ="序号,供应商,采购状态,订货量,订货金额,送货量,送货金额";
        String body = purchaseList
                .stream()
                .map(item -> item.format2OutputCsv(index.incrementAndGet()))
                .collect(Collectors.joining("\n"));
        long orderQuantity = purchaseList.stream().mapToLong(item -> item.getTransactionInfo().getOrderQuantity()).sum();
        double orderAmount = purchaseList.stream().mapToDouble(item -> item.getTransactionInfo().getOrderAmount()).sum();
        long deliveryVolume = purchaseList.stream().mapToLong(item -> item.getTransactionInfo().getDeliveryVolume()).sum();
        double deliveryAmount = purchaseList.stream().mapToDouble(item -> item.getTransactionInfo().getDeliveryAmount()).sum();
        String foot = String.format(",合计,,%d,%.2f,%d,%.2f", orderQuantity, orderAmount, deliveryVolume, deliveryAmount);
        StringJoiner fileContentJoiner = new StringJoiner("\n").add(head);
        if (StringUtils.isNotEmpty(body)) {
            fileContentJoiner.add(body);
        }
        String fileContent = fileContentJoiner.add(foot).toString();
        FileUtil.outputCsvFile(response, "供货商.csv", fileContent);
    }
    //跳转到采购医院查询
    @RequestMapping("/buyHospitalQuery")
    public String buyHospitalQuery(ModelMap map) {
        List<Purchase> purchaseList = purchaseService.selectAllHospital();
        map.put("purchaseList",purchaseList);
        return "purchasing_hospital_query";
    }

    /**
     * 导出医院查询结果
     * @param response
     *
     */
    @RequestMapping("/outputHospital")
    @ResponseBody
    public void outputHospital(HttpServletResponse response) {
        List<Purchase> purchaseList = purchaseService.selectAllHospital();
        AtomicInteger index = new AtomicInteger();
        String head = "序号,采购医院,采购状态,采购量,采购金额,入库量,入库金额";
        String body = purchaseList
                .stream()
                .map(item -> item.formatAndOutputCsv(index.incrementAndGet()))
                .collect(Collectors.joining("\n"));
        long orderQuantity = purchaseList.stream().mapToLong(item -> item.getTransactionInfo().getOrderQuantity()).sum();
        double orderAmount = purchaseList.stream().mapToDouble(item -> item.getTransactionInfo().getOrderAmount()).sum();
        long receipt = purchaseList.stream().mapToLong(item -> Integer.valueOf(item.getRepertory().getReceipt())).sum();
        double receiptMoney = purchaseList.stream().mapToDouble(item -> item.getRepertory().getReceiptMoney()).sum();
        String foot = String.format(",合计,,%d,%.2f,%d,%.2f", orderQuantity, orderAmount,receipt,receiptMoney);
        StringJoiner fileContentJoiner = new StringJoiner("\n").add(head);
        if (StringUtils.isNotEmpty(body)) {
            fileContentJoiner.add(body);
        }
        String fileContent = fileContentJoiner.add(foot).toString();
        FileUtil.outputCsvFile(response, "采购医院.csv", fileContent);
    }
    //按采购医院搜索
    @RequestMapping("/searchHospital")
    public ModelAndView searchHospital(ModelAndView modelAndView,SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseService.searchHospital(searchDTO);
        modelAndView.addObject("purchaseList",purchaseList);
        modelAndView.setViewName("purchasing_hospital_query");
        return modelAndView;
    }
    //跳转到交易药品查询
    @RequestMapping("/buyDrugsQuery")
    public String buyDrugsQuery(ModelMap map){
        List<Purchase> purchaseList = purchaseService.selectTradingDrugs();
        map.put("purchaseList",purchaseList);
        return "trading_drugs";
    }

    //按交易药品搜索
    @RequestMapping("/searchBuyDrug")
    public ModelAndView searchBuyDrug(ModelAndView modelAndView,SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseService.searchBuyDrug(searchDTO);
        modelAndView.addObject("purchaseList",purchaseList);
        modelAndView.setViewName("trading_drugs");
        return modelAndView;
    }
    //跳转到查询药品交易明细
    @RequestMapping("/buyDrugsInfo")
    public String buyDrugsInfo(ModelMap map){
        List<Purchase> purchaseList = purchaseService.queryDrugInfo();
        map.put("purchaseList",purchaseList);
        return "trading_drugs_info";
    }

    //按药品信息搜索
    @RequestMapping("/searchDrugInfo")
    public ModelAndView searchDrugInfo(ModelAndView modelAndView,SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseService.searchDrugInfo(searchDTO);
        modelAndView.addObject("purchaseList",purchaseList);
        modelAndView.setViewName("trading_drugs_info");
        return modelAndView;
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
