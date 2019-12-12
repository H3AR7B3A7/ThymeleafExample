package be.steven.d.dog.blogapp.ctrl;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorCtrl implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
