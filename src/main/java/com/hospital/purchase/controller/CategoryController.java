package com.hospital.purchase.controller;

import com.alibaba.fastjson.JSON;
import com.hospital.purchase.domain.*;
import com.hospital.purchase.service.CategoryService;
import com.hospital.purchase.utils.ExcelUtil;
import com.hospital.purchase.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create YEAR−YEAR−{MONTH}-30 15:59
 */
@Controller
public class CategoryController {
    public static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/namesadd")
    public String add(){
        return "namesadd";
    }

    @RequestMapping("/up")
    public String up(){
        return "drugadd";
    }

    /**
     * 修改查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("uptefind")
    public  String uptefind(Model model, Integer id){
        DrugInformationSheet uptefind = categoryService.uptefind(id);
        model.addAttribute("uptefind",uptefind);
        return "namesupdate";
    }
    /**
     * 查询药品类别
     * @return
     */
    @RequestMapping(value = "seldrugc", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String seldrugc(){
        String json=null;
        try {
            List<DrugCategory> seldrugc = categoryService.seldrugc();
             json = JSON.toJSONString(seldrugc);
            LOGGER.info("CategoryController-------seldrugc----yes"+json);
        }catch (Exception e){
            LOGGER.info("CategoryController-------seldrugc----no"+json);
        }
        return json;
    }

    /**
     * 单位
     * @return
     */
    @RequestMapping(value = "unt", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String unt(){
        String json=null;
        try {
            List<Units> unfind = categoryService.unfind();
            json = JSON.toJSONString(unfind);
            LOGGER.info("CategoryController-------qual----yes"+json);
        }catch (Exception e){
            LOGGER.info("CategoryController-------qual----no"+json);
        }
        return json;
    }

    /**
     * 层次
     * @return
     */
    @RequestMapping(value = "qual", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String qual(){
        String json=null;
        try {
            List<QualityLevel> quali = categoryService.quali();
            json = JSON.toJSONString(quali);
            LOGGER.info("CategoryController-------qual----yes------"+json);
        }catch (Exception e){
            LOGGER.info("CategoryController-------qual----no-----"+json);
        }
        return json;
    }

    /**
     * 生产企业查询
     * @return
     */
    @RequestMapping(value = "scqy", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String scqy(){
        String json=null;
        try {
            List<Enterprise> scqy = categoryService.scqy();
             json = JSON.toJSONString(scqy);
            LOGGER.info("CategoryController-------scqy----yes---"+json);
        }catch (Exception e){
            LOGGER.info("CategoryController-------scqy----no----"+json);
        }
        return json;
    }

    /**
     * 药品品目查询
     */
    @RequestMapping("/names")
    public String names(Model model){
        List<DrugInformationSheet> findal=null;
        try {
            findal = categoryService.findall();
            model.addAttribute("findall",findal);
            LOGGER.info("CategoryController-------names----yes---"+findal);
        }catch (Exception e){
            LOGGER.info("CategoryController-------names----no----"+findal);
        }
        return "names";
    }

    /**
     * 药品信息查询
     * @param model
     * @return
     */
    @RequestMapping("/findxx")
    public String findxx(Model model){
        List<DrugInformationSheet> finxx=null;
        try {
             finxx = categoryService.finxx();
            model.addAttribute("findxx",finxx);
            LOGGER.info("CategoryController-------findxx----yes----"+finxx);
        }catch (Exception e){
            LOGGER.info("CategoryController-------findxx----no--"+finxx);
        }
        return "drugna";
    }

    /**
     * 添加药品品目
     * @param children
     * @return
     */
    @RequestMapping(value = "findadd", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String findadd(DrugInformationSheet children){

        String json=null;
        try {
            int finda = categoryService.findadd(children);
             json = JSON.toJSONString(finda);
            LOGGER.info("CategoryController-------findadd----yes--"+json);
        }catch (Exception e){
            LOGGER.info("CategoryController-------findadd----no--"+json);
        }
        return json;
    }

    /**
     * 药品信息添加
     * @param children
     * @return
     */
    @RequestMapping(value = "xxadd", produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String xxadd(DrugInformationSheet children, String approvalNumberDate1, String drugInspectionReport1) throws Exception{
            children.setT1(approvalNumberDate1);
            children.setT2(drugInspectionReport1);
            int xxadd = categoryService.xxadd(children);
           String  json = JSON.toJSONString(xxadd);
       return json;
    }


    /**
     * 药品品目修改
     * @param children
     * @return
     */
    @RequestMapping(value = "upayy", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  upayy(DrugInformationSheet children){
        String json=null;
        try {
            int upayy = categoryService.upayy(children);
            json  = JSON.toJSONString(upayy);
            LOGGER.info("CategoryController-------upayy----yes--"+json);
        }catch (Exception e){
            LOGGER.info("CategoryController-------upayy----no---"+json);
        }
        return json;
    }

    /**
     * 模糊查询
     * @param children
     * @param model
     * @return
     */
    @RequestMapping("mhfind")
    public String mhfind(DrugInformationSheet children,Model model){
        List<DrugInformationSheet> mhfind = categoryService.mhfind(children);
        try {
            model.addAttribute("findall",mhfind);
            LOGGER.info("CategoryController-------mhfind----yes--"+mhfind);
        }catch (Exception e){
            LOGGER.info("CategoryController-------mhfind----no---"+mhfind);
        }
        return "names";
    }

    //删除
    @RequestMapping("delfind")
    public String delfind(int ids){
        int delfind=0;
        try {
            delfind = categoryService.delfind(ids);
            LOGGER.info("CategoryController-------delfind----yes--"+delfind);
        }catch (Exception e){
            LOGGER.info("CategoryController-------delfind----no---"+delfind);
        }
        return "redirect:names";
    }

    /**
     * 导出
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("exceldc")
    public String exceldc(HttpServletRequest request,HttpServletResponse response){
        String dc="";
        List<DrugInformationSheet> dcfinayy = categoryService.dcfinayy();
        String[] title = { "药品品目号", "通用名", "剂型", "规格", "单位", "转换系数", "药品类别", "交易状态"};

        String fileName = "dcfinayy" + System.currentTimeMillis() + ".xlsx";
        String sheetName = "药品品目";
        List<Units> findun = categoryService.findun();
        List<DrugCategory> fincat = categoryService.fincat();
        String[][] content = new String[dcfinayy.size()][];
        for (int i=0;i<dcfinayy.size();i++){
            content[i] = new String[title.length];
            DrugInformationSheet sheet = dcfinayy.get(i);
            content[i][0] =sheet.getDrugItemNo()+"";
            content[i][1] =sheet.getGenericDrug()+"";
            content[i][2] =sheet.getDosageForm()+"";
            content[i][3] =sheet.getSpecification()+"";
            for (Units unit :findun){
              if(sheet.getUnits().equals(unit.getUnitsId())){
                  content[i][4] =unit.getUnits();
              }
            }
            content[i][5] =sheet.getConversionFactor()+"";
            for(DrugCategory drugry : fincat){
                if(sheet.getDcId().equals(drugry.getDcId())){
                    content[i][6] =drugry.getDrugType();
                }
            }
            if(sheet.getDescripId()==0){
                content[i][7] ="正常";
            }else {
                content[i][7] ="暂停交易";
            }
        }
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content,
                null);
        // 响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
            dc = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            dc = "ERROR";
        }
        return "成功";
    }
    // 发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping("exceldr")
    public String exceldr(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        System.err.println(path);
        // 导入文件名
        String name = file.getOriginalFilename();
        System.out.println(name);
        // 路径+文件名称
        path = path +"/"+name;
        File file2 = new File(path);
        System.out.println(path);
        file.transferTo(new File(path));
        System.err.println(name);
            return "成功";
    }
}
