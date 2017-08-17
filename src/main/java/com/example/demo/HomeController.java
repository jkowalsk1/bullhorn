package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by oracle on 8/16/17.
 */
@Controller
public class HomeController {
    @Autowired
    MessagesRepository messagesRepository;

    @RequestMapping("/")
    public String listTweets(Model model){
        model.addAttribute("messages", messagesRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String listnewtweets(Model model){
        model.addAttribute("message", new Messages());
        return "bullhornnewmessage";
    }
    @PostMapping("/process")
    public String processForm(@Valid Messages messages, BindingResult result){
        if(result.hasErrors()){
            return "bullhornnewmessage";
        }
        messagesRepository.save(messages);
        return "redirect:/";
    }
    @RequestMapping("/detail{id}")
    public String showJob(@PathVariable("id") long id, Model model){
        model.addAttribute("message", messagesRepository.findOne(id));
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateMessages(@PathVariable("id") long id, Model model){
        model.addAttribute("message", messagesRepository.findOne(id));
        return "bullhornnewmessage";
    }
    @RequestMapping("/delete/{id}")
    public String delJob(@PathVariable("id") long id){
        messagesRepository.delete(id);
        return "redirect:/";
    }
}
