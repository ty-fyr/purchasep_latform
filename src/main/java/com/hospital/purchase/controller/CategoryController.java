package com.hospital.purchase.controller;

import com.alibaba.fastjson.JSON;
import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.service.CategoryService;
import com.hospital.purchase.domain.DrugInformationSheet;
import org.apache.poi.hslf.record.DummyPositionSensitiveRecordWithChildren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shkstart
 * @create YEAR−YEAR−{MONTH}-30 15:59
 */
@Controller
public class CategoryController {

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
     * 查询药品类别
     * @return
     */
    @RequestMapping(value = "seldrugc", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String seldrugc(){
        List<DrugCategory> seldrugc = categoryService.seldrugc();
        String json = JSON.toJSONString(seldrugc);
        return json;
    }
    /**
     * 药品品目查询
     * @return
     */
    @RequestMapping("/names")
    public String names(Model model){
        List<DrugInformationSheet> findal = categoryService.findall();
        model.addAttribute("findall",findal);
        return "names";
    }

    /**
     * 药品信息查询
     * @param model
     * @return
     */
    @RequestMapping("/findxx")
    public String findxx(Model model){
        List<DrugInformationSheet> finxx = categoryService.finxx();
        model.addAttribute("finxx",finxx);
        return "drugna";
    }
    /**
     *添加药品品目
     * @return
     */
    @RequestMapping("/findadd")
    @ResponseBody
    public String findadd(DrugInformationSheet children){
        int finda = categoryService.findadd(children);
        System.out.println(finda);
        String json = JSON.toJSONString(finda);
        return json;
    }
}
