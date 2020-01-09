package com.hospital.purchase.controller;

import com.alibaba.fastjson.JSON;
import com.hospital.purchase.domain.*;
import com.hospital.purchase.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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

    @RequestMapping("uptefind")
    public  String uptefind(Integer id,Model model){
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
    public  String xxadd(DrugInformationSheet children){
        String json=null;
        try {
            int xxadd = categoryService.xxadd(children);
             json = JSON.toJSONString(xxadd);
            LOGGER.info("CategoryController-------xxadd----yes--"+json);
        }catch (Exception e){
            LOGGER.info("CategoryController-------xxadd----no---"+json);
        }
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
        int upayy = categoryService.upayy(children);
        String  json = JSON.toJSONString(upayy);
        return json ;
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

    @RequestMapping("exceldc")
    public String exceldc(HttpServletRequest request,HttpServletResponse response){
        String dc="";
        return null;
    }

}
