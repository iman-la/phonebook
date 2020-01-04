package ir.fmehrtash.phonebook.controller;

import ir.fmehrtash.phonebook.service.phoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/phone")
public class phoneController {

    @Autowired
    private phoneService phoneService;

    @GetMapping("/delete")
    public String deletePhone(
            @RequestParam("pid") int pid
    ) {
        int person_id = phoneService.getPhoneById(pid).getPerson().getPerson_id();
        phoneService.deletePhone(pid);
        return "redirect:/person/detail?pid=" + person_id;
    }

    @PostMapping("/new")
    public String newPhone(
            @RequestParam("title") String title,
            @RequestParam("number") String number,
            @RequestParam("pid") int pid
    ) {

        phoneService.newPhone(title,number,pid);

        return "redirect:/person/detail?pid=" + pid;
    }


}
