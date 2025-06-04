package com.apuliadigital.corsospring.service;

import com.apuliadigital.corsospring.model.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final Map<Integer, User> users= new HashMap<>();
    private int nextId=4;
    public UserService(){
        users.put(1, new User(1, "Mario", "mario@email.it", 25) );
        users.put(2, new User(2, "Ciccio", "ciccio@email.it", 21) );
        users.put(3, new User(3, "Mimmo", "mimmo@email.it", 22) );

    }
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(int id){
        return users.get(id);
    }

    public User createUser(User user){
        user.setId(nextId++);
        users.put(user.getId(), user);
        return user;
    }

    public boolean deleteUserById(int id){
        return users.remove(id) !=null;
    }

    public User updateUser(int id, User updatedUser){
        if (users.containsKey(id)){
            updatedUser.setId(id);
            users.put(id, updatedUser);
            return updatedUser;
        }
        return null;
    }
}
