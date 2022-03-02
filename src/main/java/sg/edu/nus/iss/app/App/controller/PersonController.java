package sg.edu.nus.iss.app.App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;

import java.util.logging.Logger;

import sg.edu.nus.iss.app.App.model.Person;

@Controller
@RequestMapping(path="/demo", produces=MediaType.TEXT_HTML_VALUE)
public class PersonController {
    Logger logger= Logger.getLogger(PersonController.class.getName());

    @GetMapping("/getSomeone/{firstName}")
    public String getKenneth(@PathVariable(name="firstName") String firstName,
        Model model){
        Person p = new Person();
        
        if(firstName.equals("Kenneth")){
            p.setId(1);
            p.setFirstName("Kenneth");
            p.setLastName("Phang");
            p.setGender('M');
        }

        if(firstName.equals("Christine")){
            p.setId(1);
            p.setFirstName("Christine");
            p.setLastName("Tan");
            p.setGender('F');
        }
        

        model.addAttribute("result", p);
        return "pathvar";
    }


}
