package com.example.demo_bai_3.controller;

import com.example.demo_bai_3.model.Human;
import com.example.demo_bai_3.service.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class HumanController {
    @Autowired
    IHumanService humanService;

    @GetMapping("/human")
    public String getHuman(Model model) {
        List<Human> humanList = humanService.getHuman();
        model.addAttribute("human", humanList);
        return "/human/list";
    }

    @GetMapping("/human/create")
    public String formCreateHuman(Model model) {
        model.addAttribute("human", new Human());
        return "/human/create";
    }

    @PostMapping("/human/create")
    public String createHuman(@ModelAttribute Human human, RedirectAttributes redirectAttributes) {
        int id = humanService.getHuman().size() + 1;
        human.setId(id);
        humanService.createHuman(human);
        redirectAttributes.addFlashAttribute("message", "Thêm Mới Thành Công!");
        return "redirect:/human";
    }

    @GetMapping("/human/update")
    public String formUpdate(@RequestParam("id") int id, Model model) {
        Human human = humanService.findId(id);
        model.addAttribute("findHuman", human);
        return "/human/update";
    }

    @GetMapping("/human/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        Human human = humanService.findHuman(id);
        model.addAttribute("detail", human);
        return "/human/detail";
    }

    @PostMapping("/human/update")
    public String update(@ModelAttribute Human human, RedirectAttributes redirectAttributes) {
        humanService.updateHuman(human.getId(), human);
        redirectAttributes.addFlashAttribute("message", "Chỉnh Sửa Thành Công!");
        return "redirect:/human";
    }

    @GetMapping("/human/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        humanService.deleteHuman(id);
        redirectAttributes.addFlashAttribute("message", "Xóa Thành Công!");
        return "redirect:/human";
    }

    @PostMapping("/human/search")
    public String search(@RequestParam(name = "name", defaultValue = "") String name, Model model) {
        List<Human> humanList = humanService.searchHuman(name);
        model.addAttribute("human", humanList);
        return "/human/list";
    }
}
