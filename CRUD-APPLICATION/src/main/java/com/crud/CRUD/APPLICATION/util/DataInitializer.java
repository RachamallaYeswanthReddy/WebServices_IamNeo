package com.crud.CRUD.APPLICATION.util;

import com.crud.CRUD.APPLICATION.Entity.User;
import com.crud.CRUD.APPLICATION.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User();
        u1.setId(1);
        u1.setUsername("Yeswanth");
        u1.setPassword("12345");
        u1.setEnabled(true);
        u1.setRoles("admin");

        userService.saveUser(u1);

        User u2 = new User();
        u2.setId(2);
        u2.setUsername("Jatin");
        u2.setPassword("Yeshwanth");
        u2.setEnabled(true);
        u2.setRoles("user");

        userService.saveUser(u2);

    }
}
