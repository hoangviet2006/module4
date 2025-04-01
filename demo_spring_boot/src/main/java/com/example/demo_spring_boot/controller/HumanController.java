    package com.example.demo_spring_boot.controller;

    import com.example.demo_spring_boot.model.Human;
    import com.example.demo_spring_boot.service.ICloudinaryService;
    import com.example.demo_spring_boot.service.IHumanService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    import org.springframework.web.servlet.mvc.support.RedirectAttributes;

    import java.io.IOException;
    import java.util.List;

    @Controller
    public class HumanController {
        @Autowired
        IHumanService humanService;
        @Autowired
        ICloudinaryService cloudinaryService;

        @GetMapping("/human")
        public String getHuman(Model model) {
            List<Human> humanList = humanService.getHuman();
            model.addAttribute("human", humanList);
            return "/student/list";
        }

        @GetMapping("/human/create")
        public String formCreateHuman(Model model) {
            model.addAttribute("human", new Human());
            return "/student/create";
        }

        @PostMapping("/human/create")
        public String createHuman(@ModelAttribute Human human, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
            try {
                String img= cloudinaryService.uploadImage(file);
                human.setUrlImg(img);
            } catch (IOException e) {
                redirectAttributes.addFlashAttribute("error", "Lỗi khi upload ảnh: " + e.getMessage());
                return "redirect:/human/create";
            }
            humanService.createHuman(human);
            redirectAttributes.addFlashAttribute("message", "Thêm Mới Thành Công!");
            return "redirect:/human";
        }

        @GetMapping("/human/update")
        public String formUpdate(@RequestParam("id") int id, Model model) {
            Human human = humanService.findId(id);
            model.addAttribute("findHuman", human);
            return "/student/update";
        }

        @GetMapping("/human/detail/{id}")
        public String detail(@PathVariable("id") int id, Model model) {
            Human human = humanService.findId(id);
            model.addAttribute("detail", human);
            return "/student/detail";
        }

        @PostMapping("/human/update")
        public String update(@ModelAttribute Human human, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
            try {
                String img= cloudinaryService.uploadImage(file);
                human.setUrlImg(img);
            } catch (IOException e) {
                redirectAttributes.addFlashAttribute("error", "Lỗi khi upload ảnh: " + e.getMessage());
                return "redirect:/human/create";
            }
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
            return "/student/list";
        }
    }
