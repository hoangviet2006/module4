package com.example.luyen_tap_1.controller;

import com.example.luyen_tap_1.model.Human;
import com.example.luyen_tap_1.service.IHumanService;
import jdk.internal.org.jline.keymap.BindingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HumanController {
    @Autowired
    IHumanService humanService;

    @GetMapping("/human")
    public String getHuman(Model model) {
        List<Human> humanList = humanService.getHuman();
        model.addAttribute("human", humanList);
        return "/list";
    }

    @GetMapping("/human/create")
    public String formCreateHuman(Model model) {
        model.addAttribute("human", new Human());
        return "/create";
    }

    @PostMapping("/human/create")
//    public String createHuman(@RequestParam("name") String name,  @RequestParam("address") String address,@RequestParam("date") String date,@RequestParam("gender") String gender,@RequestParam("phoneNumber") String phoneNumber,@RequestParam("job") String job,@RequestParam("nationality") String nationality, RedirectAttributes redirectAttributes) {
//
//
//        int id = humanService.getHuman().size()+1;
//        Human human = new Human(id,name,date,gender,phoneNumber,address,job,nationality);
//        humanService.createHuman(human);
//        redirectAttributes.addFlashAttribute("message","Thêm Mới Thành Công!");
//        return "redirect:/human";
//    }
    public String createHuman(@Valid @ModelAttribute Human human, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){
            return "/create";
        }
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
        return "/update";
    }

    @GetMapping("/human/{id}/detail")
    public String detail(@PathVariable("id") int id, Model model) {
        List<Human> human = humanService.findHuman(id);
        model.addAttribute("detail", human);
        return "/detail";
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
        return "/list";
    }
}
