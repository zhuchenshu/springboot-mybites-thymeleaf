package com.mybites.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/23
 * * Time: 21:10
 * * Description: 重定向的数据传递
 */
@Controller
public class RedirectDemo {
    // 通过url模板进行重定向
    @RequestMapping("/redirect")
    public String urlRedirect(RedirectAttributes model) {
        model.addAttribute("message", 123);
        return "redirect:/redirectDemo/{message}";
    }

    // 使用flash属性
    @RequestMapping("/redirectFlash")
    public String redirectFlash(RedirectAttributes model) {
        model.addFlashAttribute("message", 123);
        return "redirect:/redirectFlashDemo";
    }

    @RequestMapping("/redirectDemo/{message}")
    public String redirectDemo(Model model,@PathVariable String message) {
        return "redirectDemo";
    }

    @RequestMapping("/redirectFlashDemo")
    public String redirectFlashDemo() {
        return "redirectDemo";
    }
}
