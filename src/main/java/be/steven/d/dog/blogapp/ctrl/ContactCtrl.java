package be.steven.d.dog.blogapp.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactCtrl {
    @GetMapping(value = "/contact")
    public String showContact(ModelMap map) { return "contact";}
}