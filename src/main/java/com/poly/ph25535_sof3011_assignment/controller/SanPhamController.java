package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.SanPham;
import com.poly.ph25535_sof3011_assignment.repository.SanPhamRepository;
import com.poly.ph25535_sof3011_assignment.viewModel.SanPhamViewModel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.matcher.ModifierMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamViewModel spvm;

    private SanPham convertToSanPham(SanPhamViewModel sanPhamViewModel){
        return mapper.map(sanPhamViewModel, SanPham.class);
    }

    @GetMapping("index")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<SanPham> dssp = sanPhamRepository.findAll(pageable);
        model.addAttribute("datasp", dssp);
        return "crud/sanPham/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("sanPham", spvm);
        return "crud/sanPham/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("sanPham") SanPhamViewModel sanPhamViewModel, BindingResult result){
        if(result.hasErrors()){
            return "crud/sanPham/create";
        }
        SanPham newSanPham = this.convertToSanPham(sanPhamViewModel);
        this.sanPhamRepository.save(newSanPham);
        return "redirect:/san-pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPham sanPham){
        this.sanPhamRepository.delete(sanPham);
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPham sanPham, Model model){
        model.addAttribute("sanPham", sanPham);
        return "crud/sanPham/update";
    }

    @PostMapping("update/{id}")
    public  String update(@PathVariable("id") SanPham sanPham, @Valid @ModelAttribute("sanPham") SanPhamViewModel sanPhamViewModel, BindingResult result){
        if(result.hasErrors()){
            return "crud/sanPham/update";
        }
        if (sanPham != null){
            sanPhamViewModel.setMa(sanPham.getMa());
            sanPhamViewModel.setId(sanPham.getId());
            sanPhamRepository.save(this.convertToSanPham(sanPhamViewModel));
        }
        return "redirect:/san-pham/index";
    }
}
