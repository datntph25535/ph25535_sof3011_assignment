package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.MauSac;
import com.poly.ph25535_sof3011_assignment.repository.MauSacRepository;
import com.poly.ph25535_sof3011_assignment.viewModel.MauSacViewModel;
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
@RequestMapping("mau-sac")
public class MauSacController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MauSacViewModel msvm;

    @Autowired
    private MauSacRepository mauSacRepository;

    private MauSac convertToMauSac(MauSacViewModel mauSacViewModel){
        return mapper.map(mauSacViewModel, MauSac.class);
    }

    @GetMapping("index")
    public String hienThi(@RequestParam(defaultValue = "1", value = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<MauSac> dsms = mauSacRepository.findAll(pageable);
        model.addAttribute("datams", dsms);
        return "crud/mauSac/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("mauSac", msvm);
        return "crud/mauSac/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("mauSac") MauSacViewModel mauSacViewModel, BindingResult result){
        if(result.hasErrors()){
            return "crud/mauSac/create";
        }
        MauSac newMauSac = this.convertToMauSac(mauSacViewModel);
        this.mauSacRepository.save(newMauSac);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") MauSac mauSac){
        this.mauSacRepository.delete(mauSac);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") MauSac mauSac, Model model){
        model.addAttribute("mauSac", mauSac);
        return "crud/mauSac/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") MauSac mauSac, @Valid @ModelAttribute("mauSac") MauSacViewModel mauSacViewModel, BindingResult result){
        if(result.hasErrors()){
            return "crud/mauSac/update";
        }
        if (mauSac != null){
            mauSacViewModel.setMa(mauSac.getMa());
            mauSacViewModel.setId(mauSac.getId());
            mauSacRepository.save(this.convertToMauSac(mauSacViewModel));
        }
        return "redirect:/mau-sac/index";
    }
}
