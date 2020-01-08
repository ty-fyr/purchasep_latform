package com.hospital.purchase.controller;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("/purchase")
    public String selectAll(Model model,Integer purchaseNumber,String purchaseName,Integer descripId,
                            String year, String month, String day,String hospitalName){
        Map<String,Object> map = new HashMap<String, Object>();
        String startTime = "";
        if (year!=null && "0".equals(year)){
            if ("0".equals(month)){
                startTime = year;
            }else if (month.length()==1){
                startTime = year+"-0"+month;
                if (!"0".equals(day) && day.length()==1){
                    startTime = startTime + "-0" + day;
                }
            }else {
                startTime = year + "-" + month;
                if (!"0".equals(day) && day.length()==1){
                    startTime = startTime + "-0" + day;
                }else if (!"0".equals(day) && day.length()==2){
                    startTime = startTime + "-" + day;
                }
            }
        }
        map.put("startTime",startTime);
        map.put("purchaseNumber",purchaseNumber);
        map.put("purchaseName",purchaseName);
        map.put("descripId",descripId);
        map.put("hospitalName",hospitalName);
        List<Purchase> list = purchaseService.seleLike(map);
        model.addAttribute("list",list);
        return "purchase_order";
    }
}
