package com.poly.ph25535_sof3011_assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {
    @GetMapping("trangChu")
    public String trangChu(Model model){
        return "trangChu/trangChu";
    }

    @GetMapping("hienThi")
    public String hienThi(Model model){
        String uri = String.valueOf(model.containsAttribute("d"));
        return "trangChu/trangChu";
    }
}
