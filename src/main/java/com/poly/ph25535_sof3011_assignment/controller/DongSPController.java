package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.DongSP;
import com.poly.ph25535_sof3011_assignment.repository.DongSPRepository;
import com.poly.ph25535_sof3011_assignment.viewModel.DongSPViewModel;
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
@RequestMapping("dong-sp")
public class DongSPController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DongSPViewModel dspvm;

    @Autowired
    private DongSPRepository dongSPRepository;

    private DongSP convertToDongSP(DongSPViewModel dongSPViewModel){
        return mapper.map(dongSPViewModel, DongSP.class);
    }

    @GetMapping("index")
    public String hienThi(@RequestParam(defaultValue = "1", value = "page") int number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<DongSP> dsdsp = dongSPRepository.findAll(pageable);
        model.addAttribute("datadsp", dsdsp);
        return "crud/dongSP/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("dongSP", dspvm);
        return "crud/dongSP/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("dspvm") DongSPViewModel dongSPViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/dongSP/create";
        }
        DongSP newDongSP = this.convertToDongSP(dongSPViewModel);
        this.dongSPRepository.save(newDongSP);
        return "redirect:/dong-sp/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") DongSP dongSP){
        this.dongSPRepository.delete(dongSP);
        return "redirect:/dong-sp/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") DongSP dongSP, Model model){
        model.addAttribute("dongSP", dongSP);
        return "crud/dongSP/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") DongSP dongSP, @Valid @ModelAttribute("dongSP") DongSPViewModel dongSPViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/dongSP/update";
        }
        if(dongSP != null){
            dongSPViewModel.setMa(dongSP.getMa());
            dongSPViewModel.setId(dongSP.getId());
            dongSPRepository.save(this.convertToDongSP(dongSPViewModel));
        }
        return "redirect:/dong-sp/index";
    }

}
