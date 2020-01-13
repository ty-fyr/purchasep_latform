package com.hospital.purchase.controller;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    public static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);
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
        try{
            List<Purchase> all = purchaseService.seleLike(map);
            model.addAttribute("all",all);
            LOGGER.info("PurchaseController---------purchase ---成功" + all);
        }catch (Exception e){
            LOGGER.debug("PurchaseController---------purchase ---失败");

        }

        return "purchase_order";
    }


    @RequestMapping("/purAll")
    public String purAll(Model model){
        try {
            List<Purchase> all = purchaseService.findAll();
            model.addAttribute("all",all);
            LOGGER.info("PurchaseController---------purAll------没毛病");
        }catch (Exception e){
            LOGGER.debug("PurchaseController---------purAll------毛病大了");
        }
        return "purchase_order";
    }

    @ResponseBody
    @RequestMapping("updeta")
    public String update(@RequestParam("piId") Integer[] piId,@RequestParam("result") Integer[] result,@RequestParam("opinion") String[] opinion){
        String message = "";
        Purchase purchase = new Purchase();
        try {
            for (int i=0;i<piId.length;i++){
                    purchase.setResult(result[i]);
                    purchase.setOpinion(opinion[i]);
                    purchase.setPiId(piId[i]);
                    purchaseService.update(purchase);
                LOGGER.info("PurchaseController---------updeta------我也不想这样难过");
            }
            message = "SUCCESS";
            return message;

        }catch (Exception e){
            message = "ERROR";
            LOGGER.info("PurchaseController---------updeta------我也不想这样蹉跎");
            return message;

        }
    }
}
