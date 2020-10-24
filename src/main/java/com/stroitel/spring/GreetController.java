package com.stroitel.spring;

import com.stroitel.spring.domain.Message;
import com.stroitel.spring.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetController {

    private MessageRepo messageRepo;

    @Autowired
    public GreetController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Model model){
        List<Message> list = new ArrayList<>();
        messageRepo.findAll().forEach(list::add);
        model.addAttribute("message", new Message());
        model.addAttribute("messages", list);
        return "index";
    }

    @PostMapping
    public String add(@ModelAttribute("message") Message message){
        messageRepo.save(message);
        return "redirect:/";
    }
}
