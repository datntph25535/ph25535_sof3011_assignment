package com.poly.ph25535_sof3011_assignment.controller;

import com.poly.ph25535_sof3011_assignment.entity.ChucVu;
import com.poly.ph25535_sof3011_assignment.repository.ChucVuRepository;
import com.poly.ph25535_sof3011_assignment.viewModel.ChucVuViewModel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ChucVuViewModel cvvm;

    @Autowired
    private ChucVuRepository chucVuRepository;

    private ChucVuViewModel convertToChucVuViewModel(ChucVu chucVu) {
        return mapper.map(chucVu, ChucVuViewModel.class);
    }

    private ChucVu convertToChucVu(ChucVuViewModel chucVuViewModel){
        return mapper.map(chucVuViewModel, ChucVu.class);
    }

    @GetMapping("index")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<ChucVu> dscv = chucVuRepository.findAll(pageable);
        model.addAttribute("datacv", dscv);
        return "crud/chucVu/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("chucVu", cvvm);
        return "crud/chucVu/create";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("cvvm") ChucVuViewModel cvvm, BindingResult result, ChucVuViewModel chucVuViewModel) {
        if (result.hasErrors()) {
            return "crud/chucVu/create";
        }
        ChucVu newChucVu = this.convertToChucVu(chucVuViewModel);
        this.chucVuRepository.save(newChucVu);
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChucVu chucVu){
        this.chucVuRepository.delete(chucVu);
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChucVu chucVu, Model model){
        model.addAttribute("chucVu", chucVu);
        return "crud/chucVu/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") ChucVu chucVu, @Valid @ModelAttribute("chucVu") ChucVuViewModel chucVuViewModel, BindingResult result){
        if (result.hasErrors()) {
            return "crud/chucVu/update";
        }
        if (chucVu != null){
            chucVuViewModel.setMa(chucVu.getMa());
            chucVuViewModel.setId(chucVu.getId());
            chucVuRepository.save(this.convertToChucVu(chucVuViewModel));
        }
        return "redirect:/chuc-vu/index";
    }
}
