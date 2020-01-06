package com.hospital.purchase.controller;

import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.QualityLevel;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SelectDto;
import com.hospital.purchase.mapper.DrugInformationSheetMapper;
import com.hospital.purchase.service.JizedongService;
import com.hospital.purchase.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

    //查询选择供货全部药品信息
    @RequestMapping("selectSuppliers")
    public String commodityManagement(ModelMap map){
        List<DrugInformationSheet> drugInformationSheets = jizedongService.selecetDrugInformationSheet();
        map.addAttribute("drugInformationSheets",drugInformationSheets);
        return "select_suppliers";
    }
    //查询取消供货全部药品信息
    @RequestMapping("cancelTheSupply")
    public String cancelTheSupply(ModelMap map){
        List<DrugInformationSheet> drugInformationSheets = jizedongService.selecetDrugInformationSheet();
        map.addAttribute("drugInformationSheets",drugInformationSheets);
        return "cancel_the_supply";
    }
    //查询商品信息维护
    @RequestMapping("commodityInformationMaintenance")
    public String commodityInformationMaintenance(ModelMap map){
        List<DrugInformationSheet> drugInformationSheets = jizedongService.selecetDrugInformationSheet();
        map.addAttribute("drugInformationSheets",drugInformationSheets);
        return "commodity_information_maintenance";
    }

    //条件查询药品信息
    @RequestMapping("findSerchBean")
    public String findSerchBean(SelectDto selectDto,ModelMap map){
        List<DrugInformationSheet> drugInformationSheets = jizedongService.findSerchBean(selectDto);
        map.addAttribute("drugInformationSheets",drugInformationSheets);
        map.addAttribute("selectDto",selectDto);
        map.addAttribute("drugSerialNumber",selectDto.getDrugSerialNumber());
        return "select_suppliers";
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

    }

    //去修改药品维护信息页面
    @RequestMapping("toUpdateInfo")
    public String toUpdateInfo(Integer drugId,ModelMap map){
        DrugInformationSheet drugInformationSheet = jizedongService.selecetDrugInformationSheetById(drugId);
        map.addAttribute("drugInformationSheet",drugInformationSheet);
        return "Modified_maintenance_drug";
    }

}
