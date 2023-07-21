package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.*;
import com.poly.ph25535_sof3011_assignment.repository.*;
import com.poly.ph25535_sof3011_assignment.viewModel.ChiTietSPViewModel;
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
@RequestMapping("chi-tiet-sp")
public class ChitietSPController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ChiTietSPViewModel ctspvm;

    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @Autowired
    private DongSPRepository dongSPRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private NSXRepository nsxRepository;

    @GetMapping("index")
    public String hienThi(@RequestParam(defaultValue = "0", value = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<ChiTietSP> dsctsp = chiTietSPRepository.findAll(pageable);
        model.addAttribute("datactsp", dsctsp);
        return "crud/chiTietSP/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChiTietSP chiTietSP){
        this.chiTietSPRepository.delete(chiTietSP);
        return "redirect:/chi-tiet-sp/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("listSP", this.sanPhamRepository.findAll());
        model.addAttribute("listNSX", this.nsxRepository.findAll());
        model.addAttribute("listMS", this.mauSacRepository.findAll());
        model.addAttribute("listDongSP", this.dongSPRepository.findAll());
        model.addAttribute("chiTietSP", ctspvm);
        return "crud/chiTietSP/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("chiTietSP") ChiTietSPViewModel chiTietSPViewModel, BindingResult result){
        if(result.hasErrors()){
            return "crud/chiTietSP/create";
        }
        ChiTietSP chiTietSP = mapper.map(chiTietSPViewModel, ChiTietSP.class);
        SanPham sp = this.sanPhamRepository.findById(chiTietSPViewModel.getIdSP()).get();
        chiTietSP.setSanPham(sp);
        NSX nsx = this.nsxRepository.findById(chiTietSPViewModel.getIdNsx()).get();
        chiTietSP.setNsx(nsx);
        MauSac ms = this.mauSacRepository.findById(chiTietSPViewModel.getIdMauSac()).get();
        chiTietSP.setMauSac(ms);
        DongSP dsp = this.dongSPRepository.findById(chiTietSPViewModel.getIdDongSP()).get();
        chiTietSP.setDongSP(dsp);
        chiTietSPRepository.save(chiTietSP);
        return "redirect:/chi-tiet-sp/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChiTietSP chiTietSP, Model model){
        if (chiTietSP != null){
            model.addAttribute("chiTietSP", mapper.map(chiTietSP, ChiTietSPViewModel.class));
            model.addAttribute("action", "chi-tiet-sp/update/" + chiTietSP.getId());
            return "crud/chiTietSP/update";
        }
        return "redirect:/chi-tiet-sp/index";
    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute("chiTietSP") ChiTietSPViewModel chiTietSPViewModel, BindingResult result, @PathVariable("id") ChiTietSP chiTietSP){
        if (result.hasErrors()){
            return "crud/chiTietSP/update";
        }
        if (chiTietSP != null){
            ChiTietSP newChiTietSP = mapper.map(chiTietSPViewModel, ChiTietSP.class);
            newChiTietSP.setId(chiTietSP.getId());
            chiTietSPRepository.save(newChiTietSP);

        }
        return "redirect:/chi-tiet-sp/index";
    }

}
