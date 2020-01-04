package ir.fmehrtash.phonebook.controller;

import ir.fmehrtash.phonebook.entity.Person;
import ir.fmehrtash.phonebook.entity.Phone;
import ir.fmehrtash.phonebook.service.personService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/person")
public class personController {

    private final personService personService;


    public personController(personService personService) {
        this.personService = personService;
    }

    @GetMapping("/detail")
    public String showDetail(
            @RequestParam("pid") int pid,
            Model m
    ) {

        Person pObj = personService.getPersonById(pid);

        List<Phone> phoneList = pObj.getPhoneList();

        m.addAttribute("personInfo", pObj);
        m.addAttribute("phoneList", phoneList);

        return "main/person_detail";
    }


    @PostMapping("/new")
    public ModelAndView newPerson(
            @RequestParam("name") String name,
            @RequestParam("family") String family
    ) {
        if (name.length() > 0 && family.length() > 0) {
            personService.newPerson(name, family);
        }
        return new ModelAndView("redirect:/person");
    }

    @GetMapping("/delete")
    public ModelAndView deletePerson(@RequestParam("pid") int pid) {
        personService.deletePerson(pid);
        return new ModelAndView("redirect:/person");
    }

    @GetMapping("")
    public String showPersonList(Model m) {
        ArrayList<Person> personList = personService.getAllPerson();
        m.addAttribute("pList", personList);
        return "main/user_list";
    }


}
