package org.javastart.zajecia1012.controller.spring.zadanie2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class TestControllerZ2 {

    private UserRepository repository;

    @Autowired
    public TestControllerZ2(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/show")
    @ResponseBody
    public String getUser(){
        List<User> users = repository.getAll();
        return users.stream()
                .map(User::getFirstName)
                .collect(Collectors.joining(", "));
    }

    @GetMapping("/search_name")
    @ResponseBody
    public String searchUserByName (@RequestParam("imie") String name){
        List<User> users = repository.getAll();
        for (User user:users) {
            if (name.equals(user.getFirstName())){
                return user.toString();
            }
        }
        return "/err.html";
    }

    @GetMapping("/search_lst_name")
    @ResponseBody
    public String searchUserByLastName (@RequestParam("nazwisko") String lastName){
        List<User> users = repository.getAll();
        for (User user:users) {
            if (lastName.equals(user.getLastName())){
                return user.toString();
            }
        }
        return "/err.html";
    }

    @GetMapping("/search_age")
    @ResponseBody
    public String searchUserByAge (@RequestParam("wiek") int age){
        List<User> users = repository.getAll();
        for (User user:users) {
            if (age == user.getAge()){
                return user.toString();
            }
        }
        return "/err.html";
    }

    @GetMapping("/add")
    public String addUser (@RequestParam("imie") String name, @RequestParam("nazwisko") String lastName,
                           @RequestParam("wiek") Integer age){
        if (name.isEmpty()){
            return "redirect:/err.html";
        }
        User user = new User(name,lastName,age);
        repository.add(user);
        return "redirect:/success.html";
    }

    @DeleteMapping("/delete")
    public void deleteUser (@RequestParam("imie") String name, @RequestParam("nazwisko") String lastName,
                            @RequestParam("wiek") int age){
        List<User> users = repository.getAll();
        for (User user:users) {
            if (user.getFirstName().equals(name)|| user.getLastName().equals(lastName)||user.getAge()==age){
                repository.removeUser(user);
            }
        }
    }
}
