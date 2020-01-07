package com.hospital.purchase.controller;

import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.QualityLevel;
import com.hospital.purchase.domain.dto.SelectDto;
import com.hospital.purchase.service.JizedongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //查询全部药品信息
    @RequestMapping("selectSuppliers")
    public String commodityManagement(ModelMap map){
        List<DrugInformationSheet> drugInformationSheets = jizedongService.selecetDrugInformationSheet();
        map.addAttribute("drugInformationSheets",drugInformationSheets);
        return "select_suppliers";
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
}
