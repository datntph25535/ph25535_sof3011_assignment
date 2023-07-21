package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.KhachHang;
import com.poly.ph25535_sof3011_assignment.repository.KhachHangRepository;
import com.poly.ph25535_sof3011_assignment.viewModel.KhachHangViewModel;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private KhachHangViewModel khvm;

    @Autowired
    private KhachHangRepository khachHangRepository;

    private KhachHang convertToKhachHang(KhachHangViewModel khachHangViewModel){
        return mapper.map(khachHangViewModel, KhachHang.class);
    }

    @GetMapping("index")
    public String hienThi(@RequestParam(defaultValue = "0", value = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<KhachHang> dskh = khachHangRepository.findAll(pageable);
        model.addAttribute("datakh", dskh);
        return "crud/khachHang/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("khachHang", khvm);
        return "crud/khachHang/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("khachHang") KhachHangViewModel khachHangViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/khachHang/create";
        }
        KhachHang newKhachHang = this.convertToKhachHang(khachHangViewModel);
        this.khachHangRepository.save(newKhachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang){
        this.khachHangRepository.delete(khachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") KhachHang khachHang, Model model){
        model.addAttribute("khachHang", khachHang);
        return "crud/khachHang/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") KhachHang khachHang, @Valid @ModelAttribute("khachHang") KhachHangViewModel khachHangViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/khachHang/update";
        }
        if (khachHang != null){
            khachHangViewModel.setMa(khachHang.getMa());
            khachHangViewModel.setId(khachHang.getId());
            khachHangRepository.save(this.convertToKhachHang(khachHangViewModel));
        }
        return "redirect:/khach-hang/index";
    }

}
