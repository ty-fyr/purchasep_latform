package com.hospital.purchase.controller;

import com.hospital.purchase.domain.Hospital;
import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.service.ZjqService;
import com.hospital.purchase.utils.ExcelUtil;
import com.hospital.purchase.utils.Page;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ZjqController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ZjqController.class);

    @Autowired
    ZjqService zjqService;

    /**
     * <<——交易查询统计
     */

    /**
     *  按采购单查询
     * @param model
     * @return
     */
    @RequestMapping("/qubuchaxun")
    public String caigoudancx(Model model){
            List<Purchase> purchases = zjqService.selectByPrimaryCGD();
            model.addAttribute("purchases",purchases);
        return "query_statistics";
    }

    /**
     * 按供货商查询
     * @param model
     * @return
     */
    @RequestMapping("/supplier")
    public String supplier(Model model){
        List<Purchase> supplier = zjqService.selectByPrimaryGHS();
        model.addAttribute("supplier",supplier);
        return "by_supplier";
    }

    /**
     *  按采购医院查询
     * @param model
     * @return
     */
    @RequestMapping("/purchasing")
    public String purchasing(Model model){
        List<Purchase> hospital = zjqService.selectByPrimaryYY();
        model.addAttribute("hospital",hospital);
        return "purchasing_hospital";
    }

    /**
     * 按交易药品查询
     * @return
     */
    @RequestMapping("transaction")
    public String transaction(Model model){
        List<Purchase> drug = zjqService.selectByPrimaryJYYP();
        model.addAttribute("drug",drug);
        return "by_transaction";
    }

    /**
     * 药品交易明细
     * @return
     */
    @RequestMapping("/drug")
    public String drug(Model model){
        List<Purchase> jymx = zjqService.selectByPrimaryJYMX();
        model.addAttribute("jymx",jymx);
        return "drug_trade";
    }

    /**
     * 模糊查询
     * 采购医院
     * @param searchDTO
     * @param model
     * @return
     */
    @RequestMapping("/PurchaseMHCX")
    public String PurchaseMHCX(SearchDTO searchDTO, Model model){
        List<Purchase> purchases = zjqService.selectByPrimaryMHCX(searchDTO);
        model.addAttribute("purchases",purchases);
       return "query_statistics";
    }

    /**
     * 模糊查询
     * 供应商
     * @param searchDTO
     * @param model
     * @return
     */
    @RequestMapping("/SuppMHCX")
    public String SuppMHCX(SearchDTO searchDTO, Model model){
        List<Purchase> supplier = zjqService.selectSupplierMHCX(searchDTO);
        model.addAttribute("supplier",supplier);
        return "by_supplier";
    }

    /**
     * 模糊查询
     * 采购医院
     * @param searchDTO
     * @param model
     * @return
     */
    @RequestMapping("/HospitalMHCX")
    public String HospitalMHCX(SearchDTO searchDTO, Model model){
        List<Purchase> hospital = zjqService.selectHospitalMHCX(searchDTO);
        model.addAttribute("hospital",hospital);
        return "purchasing_hospital";
    }

    /**
     * 导出
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/export")
    public String export(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String message = "";

        //获取数据
        List<Purchase> list = zjqService.selectByPrimaryCGD();

        //excel标题
        String[] title = {"采购医院","采购单编号","采购单名称","采购状态","开始采购单时间","结束采购单时间","" +
                "建单时间","提交时间","审核时间","采购量","采购金额","入库量","入库金额","退货量","退货金额","结算量","结算金额"};

        //excel文件名
        String fileName = "按采购单查询"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "采购单";

        DateFormat a = new SimpleDateFormat("yyyy-MM-dd");

        String [][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Purchase stu = list.get(i);
            String StartTime = a.format(stu.getStartTime());
            String OverTime = a.format(stu.getOverTime());
            String ActivateTime = a.format(stu.getActivateTime());
            String SubmitTime = a.format(stu.getSubmitTime());
            String AssessorTime = a.format(stu.getAssessorTime());

            content[i][0] = stu.getHospital().getHospitalName()+"";
            content[i][1] = stu.getPurchaseNumber()+"";
            content[i][2] = stu.getPurchaseName()+"";
            content[i][3] = stu.getDescripId()+"";
            content[i][4] = StartTime+"";
            content[i][5] = OverTime+"";
            content[i][6] = ActivateTime+"";
            content[i][7] = SubmitTime+"";
            content[i][8] = AssessorTime+"";
            content[i][9] = stu.getTransactionInfo().getOrderQuantity()+"";
            content[i][10] = stu.getTransactionInfo().getOrderAmount()+"";
            content[i][11] = stu.getRepertory().getReceipt()+"";
            content[i][12] = stu.getRepertory().getReceiptMoney()+"";
            content[i][13] = stu.getTransactionInfo().getReturnNumber()+"";
            content[i][14] = stu.getTransactionInfo().getReturnAmount()+"";
            content[i][15] = stu.getTransactionInfo().getSettlementNumber()+"";
            content[i][16] = stu.getTransactionInfo().getSettlementAmount()+"";
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
        return null;

    }

    /**
     * 导出
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/exporti")
    public String supper(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String message = "";

        //获取数据
        List<Purchase> list = zjqService.selectByPrimaryGHS();

        //excel标题
        String[] title = {"序号","供货商","采购状态", "订货量","订货金额","送货量","送货金额","退货量","退货金额","结算量","结算金额"};

        //excel文件名
        String fileName = "按供应商"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "供应商";

        DateFormat a = new SimpleDateFormat("yyyy-MM-dd");

        String [][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Purchase stu = list.get(i);

            content[i][0] = stu.getSupplier().getSupplierId()+"";
            content[i][1] = stu.getSupplier().getSupplierName()+"";
            content[i][2] = stu.getDescripId()+"";
            content[i][3] = stu.getTransactionInfo().getOrderQuantity()+"";
            content[i][4] = stu.getTransactionInfo().getOrderAmount()+"";
            content[i][5] = stu.getTransactionInfo().getDeliveryVolume()+"";
            content[i][6] = stu.getTransactionInfo().getDeliveryAmount()+"";
            content[i][7] = stu.getTransactionInfo().getReturnNumber()+"";
            content[i][8] = stu.getTransactionInfo().getReturnAmount()+"";
            content[i][9] = stu.getTransactionInfo().getSettlementNumber()+"";
            content[i][10] = stu.getTransactionInfo().getSettlementAmount()+"";
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
        return null;

    }

    /**
     * 导出
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/export2")
    public String Hospital(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String message = "";

        //获取数据
        List<Purchase> list = zjqService.selectByPrimaryYY();

        //excel标题
        String[] title = {"序号","采购医院","采购状态", "采购量","采购金额","入库量","入库金额","退货量","退货金额","结算量","结算金额"};

        //excel文件名
        String fileName = "按供应商"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "供应商";

        DateFormat a = new SimpleDateFormat("yyyy-MM-dd");

        String [][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Purchase stu = list.get(i);

            content[i][0] = stu.getHospitalId()+"";
            content[i][1] = stu.getHospital().getHospitalName()+"";
            content[i][2] = stu.getDescripId()+"";
            content[i][3] = stu.getTransactionInfo().getOrderQuantity()+"";
            content[i][4] = stu.getTransactionInfo().getOrderAmount()+"";
            content[i][5] = stu.getRepertory().getReceipt()+"";
            content[i][6] = stu.getRepertory().getReceiptMoney()+"";
            content[i][7] = stu.getTransactionInfo().getReturnNumber()+"";
            content[i][8] = stu.getTransactionInfo().getReturnAmount()+"";
            content[i][9] = stu.getTransactionInfo().getSettlementNumber()+"";
            content[i][10] = stu.getTransactionInfo().getSettlementAmount()+"";
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
        return null;

    }

    /**
     * 导出
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/export3")
    public String DrugInfor(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String message = "";

        //获取数据
        List<Purchase> list = zjqService.selectByPrimaryJYYP();

        //excel标题
        String[] title = {"序号","流水号","通用名","商品名","剂型","规格","单位","转换系数","质量层次","生产企业",
                "采购量","采购金额","采购状态","入库量","入库金额","退货量","退货金额","结算量","结算金额"};

        //excel文件名
        String fileName = "按供应商"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "供应商";

        DateFormat a = new SimpleDateFormat("yyyy-MM-dd");

        String [][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Purchase stu = list.get(i);

            content[i][0] = stu.getDrugId()+"";
            content[i][1] = stu.getDrugInformationSheet().getDrugSerialNumber()+"";
            content[i][2] = stu.getDrugInformationSheet().getGenericDrug()+"";
            content[i][3] = stu.getDrugInformationSheet().getTradeName()+"";
            content[i][4] = stu.getDrugInformationSheet().getDosageForm()+"";
            content[i][5] = stu.getDrugInformationSheet().getSpecification()+"";
            content[i][6] = stu.getDrugInformationSheet().getUnits()+"";
            content[i][7] = stu.getDrugInformationSheet().getConversionFactor()+"";
            content[i][8] = stu.getDrugInformationSheet().getLevelId()+"";
            content[i][9] = stu.getEnterprise().getEnterpriseName()+"";
            content[i][10] = stu.getTransactionInfo().getOrderQuantity()+"";
            content[i][11] = stu.getTransactionInfo().getOrderAmount()+"";
            content[i][12] = stu.getDescripId()+"";
            content[i][13] = stu.getRepertory().getReceipt()+"";
            content[i][14] = stu.getRepertory().getReceiptMoney()+"";
            content[i][15] = stu.getTransactionInfo().getReturnNumber()+"";
            content[i][16] = stu.getTransactionInfo().getReturnAmount()+"";
            content[i][17] = stu.getTransactionInfo().getSettlementNumber()+"";
            content[i][18] = stu.getTransactionInfo().getSettlementAmount()+"";
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
        return null;

    }


    /**
     * 导出
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/export4")
    public String jymx(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String message = "";

        //获取数据
        List<Purchase> list = zjqService.selectByPrimaryJYMX();

        String[] title = {"序号","采购医院","采购单编号","采购单名称","开始采购时间","结束采购时间","流水号","通用名",
                "商品名","剂型","规格","单位","转换系数","质量层次","生产企业","中标价","交易价","采购量","采购金额",
                "采购状态","入库量","入库金额","退货量","退货金额","结算量","结算金额"};


        //excel文件名
        String fileName = "查询交易明细"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "交易";

        DateFormat a = new SimpleDateFormat("yyyy-MM-dd");

        String [][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Purchase stu = list.get(i);
            //excel标题

            String StartTime = a.format(stu.getStartTime());
            String OverTime = a.format(stu.getOverTime());

            content[i][0] = stu.getPiId()+"";
            content[i][1] = stu.getHospital().getHospitalName()+"";
            content[i][2] = stu.getPurchaseNumber()+"";
            content[i][3] = stu.getPurchaseName()+"";
            content[i][4] = StartTime+"";
            content[i][5] = OverTime+"";
            content[i][6] = stu.getDrugInformationSheet().getDrugSerialNumber()+"";
            content[i][7] = stu.getDrugInformationSheet().getGenericDrug()+"";
            content[i][8] = stu.getDrugInformationSheet().getTradeName()+"";
            content[i][9] = stu.getDrugInformationSheet().getDosageForm()+"";
            content[i][10] = stu.getDrugInformationSheet().getSpecification()+"";
            content[i][11] = stu.getDrugInformationSheet().getUnits()+"";
            content[i][12] = stu.getDrugInformationSheet().getConversionFactor()+"";
            content[i][13] = stu.getDrugInformationSheet().getLevelId()+"";
            content[i][14] = stu.getDrugInformationSheet().getThePrice()+"";
            content[i][15] = stu.getDrugInformationSheet().getThePrice()+"";
            content[i][16] = stu.getEnterprise().getEnterpriseName()+"";
            content[i][17] = stu.getTransactionInfo().getOrderQuantity()+"";
            content[i][18] = stu.getTransactionInfo().getOrderAmount()+"";
            content[i][19] = stu.getDescripId()+"";
            content[i][20] = stu.getRepertory().getReceipt()+"";
            content[i][21] = stu.getRepertory().getReceiptMoney()+"";
            content[i][22] = stu.getTransactionInfo().getReturnNumber()+"";
            content[i][23] = stu.getTransactionInfo().getReturnAmount()+"";
            content[i][24] = stu.getTransactionInfo().getSettlementNumber()+"";
            content[i][25] = stu.getTransactionInfo().getSettlementAmount()+"";
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
        return null;

    }

    /**
     * 帮助导出
     * 发送响应流方法
     * @param response
     * @param fileName
     * @return
     */
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

    /**
     * 结尾   交易查询统计——>>
     */

    /**
     * <<——采购目录管理
     */

    /**
     * 采购药品选择
     * @return
     */
    @RequestMapping("Purchasing")
    public String Purchasing(){

        return "Purchasing_medicine";
    }

    /**
     *采购目录维护
     * @return
     */
    @RequestMapping("Directory")
    public String Directory(){

        return "Directory_maintenance";
    }



    /**
     * 结尾   采购目录管理——>>
     */


}
