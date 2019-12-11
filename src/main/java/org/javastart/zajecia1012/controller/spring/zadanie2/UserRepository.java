package org.javastart.zajecia1012.controller.spring.zadanie2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository () {
        this.users = new ArrayList<>();
        users.add(new User("Marcin","Kowalski",20));
        users.add(new User("Ania","Kowalska",22));
        users.add(new User("Sonia","Kowal",19));
    }

    public List<User> getAll(){
        return users;
    }

    public void add(User user){
        users.add(user);
    }

    public void removeUser (User user){
        users.remove(user);
    }
}
