package sg.edu.nus.iss.app.App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.app.App.model.Person;

@Controller
@RequestMapping(path="/demo", produces=MediaType.TEXT_HTML_VALUE)
public class IndexController {
    Logger logger= Logger.getLogger(IndexController.class.getName());

    @GetMapping("/currtime")
    public String getCurrDateTime(Model model){
        logger.log(Level.INFO, "get date time");
        model.addAttribute("currtime", new Date().toString());
        return "currtime";
    }

    @GetMapping("/person")
    public String getPerson(Model model){
        Person p = new Person();
        p.setId(1);
        p.setFirstName("Kenneth");
        p.setLastName("Phang");
        p.setGender('F');
        model.addAttribute("currtime", new Date().toString());
        model.addAttribute("person", p);
        return "currtime";
    }

    @GetMapping("/allperson")
    public String getAllPerson(Model model){
        List<Person> allperson = new ArrayList<Person>();
        Person p = new Person();
        p.setId(1);
        p.setFirstName("Kenneth");
        p.setLastName("Phang");
        p.setGender('M');

        allperson.add(p);
        Person p2 = new Person();
        p2.setId(2);
        p2.setFirstName("Christine");
        p2.setLastName("Tan");
        p2.setGender('F');
        allperson.add(p2);
        model.addAttribute("currtime", new Date().toString());
        model.addAttribute("person", p);
        model.addAttribute("allperson", allperson);
        return "currtime";
    }

    @GetMapping("/searchPerson")
    public String searchPerson(@RequestParam(required=true) String firstName,
        Model model){
        List<Person> allperson = new ArrayList<Person>();
        Person pResult = null;
        Person p = new Person();
        p.setId(1);
        p.setFirstName("Kenneth");
        p.setLastName("Phang");
        p.setGender('M');

        allperson.add(p);
        Person p2 = new Person();
        p2.setId(2);
        p2.setFirstName("Christine");
        p2.setLastName("Tan");
        p2.setGender('F');
        allperson.add(p2);

        if(firstName.equals("Kenneth")){
            pResult = p;
        }

        if(firstName.equals("Christine")){
            pResult = p2;
        }

        model.addAttribute("currtime", new Date().toString());
        model.addAttribute("person", p);
        model.addAttribute("allperson", allperson);
        model.addAttribute("result", pResult);
        return "currtime";
    }

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
