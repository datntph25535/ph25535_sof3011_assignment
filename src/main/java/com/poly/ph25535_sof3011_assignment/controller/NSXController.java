package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.NSX;
import com.poly.ph25535_sof3011_assignment.repository.NSXRepository;
import com.poly.ph25535_sof3011_assignment.viewModel.NSXViewModel;
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
@RequestMapping("NSX")
public class NSXController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private NSXViewModel nsxvm;

    @Autowired
    private NSXRepository nsxRepository;

    private NSX convertToNSX(NSXViewModel nsxViewModel){
        return mapper.map(nsxViewModel, NSX.class);
    }

    @GetMapping("index")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<NSX> dsnsx = nsxRepository.findAll(pageable);
        model.addAttribute("datansx", dsnsx);
        return "crud/nsx/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("nsx", nsxvm);
        return "crud/nsx/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("nsx") NSXViewModel nsxViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/nsx/create";
        }
        NSX newNsx = this.convertToNSX(nsxViewModel);
        this.nsxRepository.save(newNsx);
        return "redirect:/NSX/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NSX nsx){
        this.nsxRepository.delete(nsx);
        return "redirect:/NSX/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NSX nsx, Model model){
        model.addAttribute("nsx", nsx);
        return "crud/nsx/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") NSX nsx, @Valid @ModelAttribute("nsx") NSXViewModel nsxViewModel, BindingResult result){
        if (result.hasErrors()){
            return "crud/nsx/update";
        }
        if (nsx != null){
            nsxViewModel.setMa(nsx.getMa());
            nsxViewModel.setId(nsx.getId());
            nsxRepository.save(this.convertToNSX(nsxViewModel));
        }
        return "redirect:/NSX/index";
    }
}
