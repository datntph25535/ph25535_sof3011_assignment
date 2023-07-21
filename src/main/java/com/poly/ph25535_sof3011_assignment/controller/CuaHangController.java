package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.CuaHang;
import com.poly.ph25535_sof3011_assignment.repository.CuaHangRepository;
import com.poly.ph25535_sof3011_assignment.viewModel.CuaHangViewModel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("cua-hang")
public class CuaHangController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CuaHangViewModel chvm;

    @Autowired
    private CuaHangRepository cuaHangRepository;

    private CuaHang convertToCuaHang(CuaHangViewModel cuaHangViewModel){
        return mapper.map(cuaHangViewModel, CuaHang.class);
    }

    @GetMapping("index")
    public String HienThi(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<CuaHang> dsch = cuaHangRepository.findAll(pageable);
        model.addAttribute("datach", dsch);
        return  "crud/cuaHang/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("cuaHang", chvm);
        return "crud/cuaHang/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("sanPham") CuaHangViewModel cuaHangViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/cuaHang/create";
        }
        CuaHang newCuaHang = this.convertToCuaHang(cuaHangViewModel);
        this.cuaHangRepository.save(newCuaHang);
        return "redirect:/cua-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang){
        this.cuaHangRepository.delete(cuaHang);
        return "redirect:/cua-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") CuaHang cuaHang, Model model){
        model.addAttribute("cuaHang", cuaHang);
        return "crud/cuaHang/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") CuaHang cuaHang, @Valid @ModelAttribute("sanPham") CuaHangViewModel cuaHangViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/cuaHang/update";
        }
        if (cuaHang != null){
            cuaHangViewModel.setMa(cuaHang.getMa());
            cuaHangViewModel.setId(cuaHang.getId());
            cuaHangRepository.save(this.convertToCuaHang(cuaHangViewModel));
        }
        return "redirect:/cua-hang/index";
    }

}
