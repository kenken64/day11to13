package sg.edu.nus.iss.app.App.model;

import java.io.Serializable;

public class Person implements Serializable{
    
    private Integer id;
    private String firstName;
    private String lastName;
    private Character gender;

    public void setId(Integer _id){
        this.id = _id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setGender(Character _gender){
        this.gender = _gender;
    }

    public Character getGender(){
        return this.gender;
    }
    
}
