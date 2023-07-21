package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.ChucVu;
import com.poly.ph25535_sof3011_assignment.entity.CuaHang;
import com.poly.ph25535_sof3011_assignment.entity.NhanVien;
import com.poly.ph25535_sof3011_assignment.repository.ChucVuRepository;
import com.poly.ph25535_sof3011_assignment.repository.CuaHangRepository;
import com.poly.ph25535_sof3011_assignment.repository.NhanVienRepository;
import com.poly.ph25535_sof3011_assignment.viewModel.NhanVienViewModel;
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
@RequestMapping("nhan-vien")
public class NhanVienController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienViewModel nvvm;

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping("index")
    public String hienThi(@RequestParam(defaultValue = "0", value = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<NhanVien> dsnv = nhanVienRepository.findAll(pageable);
        model.addAttribute("datanv", dsnv);
        return "crud/nhanVien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhanVien nhanVien){
        this.nhanVienRepository.delete(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("listCH", this.cuaHangRepository.findAll());
        model.addAttribute("listCV", this.chucVuRepository.findAll());
        model.addAttribute("nhanVien", nvvm);
        return "crud/nhanVien/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("nhanVien") NhanVienViewModel nhanVienViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/nhanVien/create";
        }
        NhanVien nhanVien = mapper.map(nhanVienViewModel, NhanVien.class);
        CuaHang ch = this.cuaHangRepository.findById(nhanVienViewModel.getIdCH()).get();
        nhanVien.setCuaHang(ch);
        ChucVu cv = this.chucVuRepository.findById(nhanVienViewModel.getIdCV()).get();
        nhanVien.setChucVu(cv);
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NhanVien nhanVien, Model model){
        if (nhanVien != null){
            model.addAttribute("nhanVien", mapper.map(nhanVien, NhanVienViewModel.class));
            model.addAttribute("action", "nhan-vien/update" + nhanVien.getId());
            return "crud/nhanVien/update";
        }
        return "redirect:/nhan-vien/index";
    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute("nhanVien") NhanVienViewModel nhanVienViewModel, BindingResult result, @PathVariable("id") NhanVien nhanVien){
        if (result.hasErrors()){
            return "crud/nhanVien/update";
        }
        if (nhanVien != null){
            NhanVien newNhanVien = mapper.map(nhanVienViewModel, NhanVien.class);
            newNhanVien.setId(nhanVien.getId());
            newNhanVien.setMa(nhanVien.getMa());
            nhanVienRepository.save(newNhanVien);
        }
        return "redirect:/nhan-vien/index";
    }

}
