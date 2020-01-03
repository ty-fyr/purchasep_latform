package com.hospital.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class zjqcontroller {



    @RequestMapping("query1")
    public String query(){
        return "query_statistics";
    }

    @RequestMapping("supplier")
    public String supplier(){
        return "by_supplier";
    }
    @RequestMapping("purchasing")
    public String purchasing(){
        return "purchasing_hospital";
    }

    @RequestMapping("transaction")
    public String transaction(){
        return "by_transaction";
    }

    @RequestMapping("drug")
    public String drug(){
        return "drug_trade";
    }



}
