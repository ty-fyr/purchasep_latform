package com.hospital.purchase.controller;

import com.hospital.purchase.domain.*;
import com.hospital.purchase.domain.dto.SelectDto;
import com.hospital.purchase.mapper.DrugInformationSheetMapper;
import com.hospital.purchase.service.JizedongService;
import com.hospital.purchase.utils.DateUtils;
import com.hospital.purchase.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @ProjectName: purchasep_latform
 * @Package: com.hospital.purchase.controller
 * @ClassName: JizedongController
 * @Author: 85235
 * @Description: ${description}
 * @Date: 2019/12/30 16:19
 * @Version: 1.0
 */
@Controller
public class JizedongController {

    @Autowired
    private JizedongService jizedongService;

    public static final Logger LOGGER = LoggerFactory.getLogger(JizedongController.class);
    //查询选择供货全部药品信息
    @RequestMapping("selectSuppliers")
    public String commodityManagement(ModelMap map){
        try {
            List<DrugInformationSheet> drugInformationSheets = jizedongService.selecetDrugInformationSheet();
            map.addAttribute("drugInformationSheets",drugInformationSheets);
            LOGGER.info("JizedongController---------selectSuppliers-----成功"+drugInformationSheets);
        }catch (Exception e){
            LOGGER.error("JizedongController---------selectSuppliers-----失败");
        }

        return "select_suppliers";
    }
    //查询取消供货全部药品信息
    @RequestMapping("cancelTheSupply")
    public String cancelTheSupply(ModelMap map){
        try{
            List<DrugInformationSheet> drugInformationSheets = jizedongService.selecetDrugInformationSheet1();
            map.addAttribute("drugInformationSheets",drugInformationSheets);
            LOGGER.info("JizedongController---------cancelTheSupply-----成功"+drugInformationSheets);
        }catch (Exception e){
            LOGGER.error("JizedongController---------cancelTheSupply-----失败");
        }

        return "cancel_the_supply";
    }
    //查询商品信息维护
    @RequestMapping("commodityInformationMaintenance")
    public String commodityInformationMaintenance(ModelMap map){
        try {
            List<DrugInformationSheet> drugInformationSheets = jizedongService.selecetDrugInformationSheet1();
            map.addAttribute("drugInformationSheets",drugInformationSheets);
            LOGGER.info("JizedongController---------commodityInformationMaintenance-----成功"+drugInformationSheets);
        }catch (Exception e){
            LOGGER.error("JizedongController---------commodityInformationMaintenance-----失败");
        }
        return "commodity_information_maintenance";
    }

    //条件查询选择供货药品信息
    @RequestMapping("findSerchBean")
    public String findSerchBean(SelectDto selectDto,ModelMap map){
        try {
            List<DrugInformationSheet> drugInformationSheets = jizedongService.findSerchBean(selectDto);
            map.addAttribute("drugInformationSheets",drugInformationSheets);
            map.addAttribute("selectDto",selectDto);
            LOGGER.info("JizedongController---------findSerchBean-----成功"+drugInformationSheets);
        }catch (Exception e){
            LOGGER.error("JizedongController---------findSerchBean-----失败");
        }

        return "select_suppliers";
    }

    //条件查询取消供货药品信息
    @RequestMapping("findSerchBean1")
    public String findSerchBean1(SelectDto selectDto,ModelMap map){
        try {
            List<DrugInformationSheet> drugInformationSheets = jizedongService.findSerchBean(selectDto);
            map.addAttribute("drugInformationSheets",drugInformationSheets);
            map.addAttribute("selectDto",selectDto);
            LOGGER.info("JizedongController---------findSerchBean1-----成功"+drugInformationSheets);
        }catch (Exception e){
            LOGGER.error("JizedongController---------findSerchBean1-----失败");
        }
        return "cancel_the_supply";
    }
    //条件查询商品信息维护信息
    @RequestMapping("findSerchBean2")
    public String findSerchBean2(SelectDto selectDto,ModelMap map){
        try{
            List<DrugInformationSheet> drugInformationSheets = jizedongService.findSerchBean(selectDto);
            map.addAttribute("drugInformationSheets",drugInformationSheets);
            map.addAttribute("selectDto",selectDto);
            LOGGER.info("JizedongController---------findSerchBean2-----成功"+drugInformationSheets);
        }catch (Exception e){
            LOGGER.error("JizedongController---------findSerchBean2-----失败");
        }
        return "commodity_information_maintenance";
    }

    //查询全部质量层次
    @ResponseBody
    @RequestMapping("findQualityLevel")
    public List<QualityLevel> findQualityLevel(){
        List<QualityLevel> qualityLevel = jizedongService.findQualityLevel();
        return qualityLevel;
    }
    //查询全部药品类别
    @ResponseBody
    @RequestMapping("findDrugCategory")
    public List<DrugCategory> findDrugCategory(){
        List<DrugCategory> drugCategory = jizedongService.findDrugCategory();
        return drugCategory;
    }
    //查询全部供货商
    @ResponseBody
    @RequestMapping("findSupplier")
    public List<Supplier> findSupplier(){
        List<Supplier> supplier = jizedongService.findSupplier();
        return supplier;
    }

    //导出
    @RequestMapping("/poiOut")
    public void poiOut(HttpServletResponse response){
        String message = "";

        //获取数据
        List<DrugInformationSheet> list = jizedongService.selecetDrugInformationSheet();

        //excel标题
        String[] title = {"药品流水号","通用名","剂型","规格","单位","转换系数","生产企业","商品名称","中标价",
                "质量层次","药品类别","药品交易状态","供货商","审核状态"};

        //excel文件名
        String fileName = "DrugInformationSheet"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "药品维护信息表";

        String[][] content = new String[list.size()][];
        for (int i = 0; i <list.size() ; i++) {
            content[i] = new String[title.length];
            DrugInformationSheet drugInformationSheet=list.get(i);
            content[i][0]=drugInformationSheet.getDrugSerialNumber()+"";
            content[i][1]=drugInformationSheet.getGenericDrug()+"";
            content[i][2]=drugInformationSheet.getDosageForm()+"";
            content[i][3]=drugInformationSheet.getSpecification()+"";
            content[i][4]=drugInformationSheet.getUnits1().getUnits()+"";
            content[i][5]=drugInformationSheet.getConversionFactor()+"";
            content[i][6]=drugInformationSheet.getEnterprise().getEnterpriseName()+"";
            content[i][7]=drugInformationSheet.getTradeName()+"";
            content[i][8]=drugInformationSheet.getThePrice()+"";
            content[i][9]=drugInformationSheet.getQualityLevel().getLevelType()+"";
            content[i][10]=drugInformationSheet.getDrugCategory().getDrugType()+"";
            Integer descripId = drugInformationSheet.getDescripId();
            if(descripId==0){
                content[i][11]="正常";
            }else {
                content[i][11]="暂停交易";
            }
           /* content[i][11]=drugInformationSheet.getDescripId()+"";*/
            content[i][12]=drugInformationSheet.getSupplierManagement().getSupplier().getSupplierName()+"";
            content[i][13]=drugInformationSheet.getSupplierManagement().getReviewResults()+"";
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
            message = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            message = "ERROR";
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


    //去修改药品维护信息页面
    @RequestMapping("/toUpdateInfo")
    public String toUpdateInfo(Integer drugId,ModelMap map){
        try {
            DrugInformationSheet drugInformationSheet = jizedongService.selecetDrugInformationSheetById(drugId);
            map.addAttribute("drugInformationSheet",drugInformationSheet);
            LOGGER.info("JizedongController---------toUpdateInfo-----成功"+drugInformationSheet);
        }catch (Exception e){
            LOGGER.error("JizedongController---------toUpdateInfo-----失败");
        }
        return "Modified_maintenance_drug";
    }

    //修改药品维护信息页面
   @RequestMapping("/info")
   @ResponseBody
    public String updateInfo(SelectDto selectDto){
       jizedongService.updateInfo(selectDto);
        return "1";
    }

    //批量提供供货
    @RequestMapping("/updateBatch")
    public String updateBatch(String ids){
        try {
            jizedongService.updateBatch(ids);
            LOGGER.info("JizedongController---------updateBatch-----成功");
        }catch (Exception e){
            LOGGER.error("JizedongController---------updateBatch-----失败");
        }
        return "redirect:selectSuppliers";
    }


    //批量取消供货
    @RequestMapping("/updaBatch")
    public String updaBatch(String ids){
        try {
            jizedongService.updaBatch(ids);
            LOGGER.info("JizedongController---------updaBatch-----成功");
        }catch (Exception e){
            LOGGER.error("JizedongController---------updaBatch-----失败");
        }
        return "redirect:cancelTheSupply";
    }

    //采购单管理
    @RequestMapping("/PurchaseOrderManagement")
    public String PurchaseOrderManagement(ModelMap modelMap){
        List<Purchase> purchases = jizedongService.PurchaseOrderManagement();
        modelMap.addAttribute("purchases",purchases);
        return "Purchase_order_management";
    }


    //条件查询采购单信息
    @RequestMapping("findSerchBean3")
    public String findSerchBean3(SelectDto selectDto,ModelMap map){
        try {
            List<Purchase> purchases = jizedongService.findSerchBean3(selectDto);
            map.addAttribute("purchases",purchases);
            map.addAttribute("selectDto",selectDto);
            LOGGER.info("JizedongController---------findSerchBean-----成功"+purchases);
        }catch (Exception e){
            LOGGER.error("JizedongController---------findSerchBean-----失败");
        }

        return "Purchase_order_management";
    }

    //导出
    @RequestMapping("/poiOut1")
    public void poiOut1(HttpServletResponse response){
        String message = "";

        //获取数据
        List<Purchase> list = jizedongService.PurchaseOrderManagement();

        //excel标题
        String[] title = {"序号","采购单编号","采购单名称","采购医院","开始采购时间","结束采购时间","流水号","通用名","商品名",
                "剂型","规格","单位","转换系数","生产企业","中标价","交易价","采购量","采购总金额","供货企业","采购状态"};

        //excel文件名
        String fileName = "Purchase"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "采购单信息表";

        String[][] content = new String[list.size()][];
        for (int i = 0; i <list.size() ; i++) {
            content[i] = new String[title.length];
            Purchase purchase=list.get(i);
            content[i][0]=purchase.getDrugId()+"";
            content[i][1]=purchase.getPurchaseNumber()+"";
            content[i][2]=purchase.getPurchaseName()+"";
            content[i][3]=purchase.getHospital().getHospitalName()+"";
            content[i][4]= DateUtils.dateFormat(purchase.getStartTime(),"yyyy-MM-dd");
            content[i][5]= DateUtils.dateFormat(purchase.getOverTime(),"yyyy-MM-dd");
            content[i][6]=purchase.getDrugInformationSheet().getDrugSerialNumber()+"";
            content[i][7]=purchase.getDrugInformationSheet().getGenericDrug()+"";
            content[i][8]=purchase.getDrugInformationSheet().getTradeName()+"";
            content[i][9]=purchase.getDrugInformationSheet().getDosageForm()+"";
            content[i][10]=purchase.getDrugInformationSheet().getSpecification()+"";
            content[i][11]=purchase.getDrugInformationSheet().getUnits1().getUnits()+"";
            content[i][12]=purchase.getDrugInformationSheet().getConversionFactor()+"";
            content[i][13]=purchase.getDrugInformationSheet().getEnterprise().getEnterpriseName()+"";
            content[i][14]=purchase.getDrugInformationSheet().getThePrice()+"";
            content[i][15]=purchase.getDrugInformationSheet().getThePrice()+"";
            content[i][16]=purchase.getTransactionInfo().getOrderQuantity()+"";
            content[i][17]=purchase.getTransactionInfo().getOrderAmount()+"";
            content[i][18]=purchase.getSupplier().getSupplierName()+"";
           /* content[i][19]=purchase.getDescripId()+"";*/
            Integer descripId1 = purchase.getDescripId();
            if(descripId1==0){
                content[i][19]="已入库";
            }else {
                content[i][19]="未入库";
            }
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
            message = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            message = "ERROR";
        }
    }

  /*  //发送响应流方法
    public String setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "redirect:/selectSuppliers";

    }*/
}
