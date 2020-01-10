package com.hospital.purchase.controller;

import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    public static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);
    @RequestMapping("/suppAll")
    public String All(Model model){
                List<DrugInformationSheet> list = supplierService.findAll();
                model.addAttribute("list",list);
            return "supplier_audit";
    }
}
