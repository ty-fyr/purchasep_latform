package com.hospital.purchase.controller;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.service.ZjqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class zjqcontroller {

    @Autowired
    ZjqService zjqService;

    @RequestMapping("qubuchaxun")
    public String qubuchaxun(Model model) {
        List<Purchase> purchases = zjqService.selectByPrimaryName();
        model.addAttribute("purchases", purchases);
        return "query_statistics";
    }


    //页面跳转

    @RequestMapping("supplier")
    public String supplier() {
        return "by_supplier";
    }

    @RequestMapping("purchasing")
    public String purchasing() {
        return "purchasing_hospital";
    }

    @RequestMapping("transaction")
    public String transaction() {
        return "by_transaction";
    }

    @RequestMapping("drug")
    public String drug() {
        return "drug_trade";
    }



}
