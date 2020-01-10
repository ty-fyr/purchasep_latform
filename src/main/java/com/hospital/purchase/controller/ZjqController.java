package com.hospital.purchase.controller;

import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.Hospital;
import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.domain.dto.VO;
import com.hospital.purchase.service.ZjqService;
import com.hospital.purchase.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
     *  按采购单查询
     * @param model
     * @return
     */
    @RequestMapping("qubuchaxun")
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
    @RequestMapping("supplier")
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
    @RequestMapping("purchasing")
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
        List<Purchase> drugInformationSheet = zjqService.selectByPrimaryJYYY();
        model.addAttribute("drugInformationSheet",drugInformationSheet);
        return "by_transaction";
    }

    /**
     * 导出
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {

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


    }

    /**
     * 导出
     * 发送响应流方法
     * @param response
     * @param fileName
     * @return
     */
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
        return "query_statistics";
    }

    /**
     * 模糊查询
     * 采购医院
     * @param searchDTO
     * @param model
     * @return
     */
    @RequestMapping("/MHCX")
    public String MHCX(SearchDTO searchDTO, Model model){
        List<Purchase> purchases = zjqService.selectByPrimaryMHCX(searchDTO);
        model.addAttribute("purchases",purchases);
       return "query_statistics";
    }
    /**
     * 模糊查询
     * 供应商
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping("/SuppMHCX")
    public String SuppMHCX(VO vo, Model model){
        List<Supplier> suppliers = zjqService.selectSupplierMHCX(vo);
        model.addAttribute("suppliers",suppliers);
        return "by_supplier";
    }



    //页面跳转
    @RequestMapping("drug")
    public String drug() {
        return "drug_trade";
    }



}
