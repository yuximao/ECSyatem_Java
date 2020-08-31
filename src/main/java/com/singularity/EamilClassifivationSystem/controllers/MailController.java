package com.singularity.EamilClassifivationSystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singularity.EamilClassifivationSystem.beans.Email;
import com.singularity.EamilClassifivationSystem.beans.User;
import com.singularity.EamilClassifivationSystem.daos.UserDao;
import com.singularity.EamilClassifivationSystem.http.Response;
import com.singularity.EamilClassifivationSystem.services.MailService;
import com.singularity.EamilClassifivationSystem.services.UserService;




@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserService userService;
    
    private User user = new User();


    @PostMapping("/forgetPassword")
    public Response sendEmail2(@RequestBody List<String> addressList) {
        Email email_email = new Email();
        email_email.setToAddress(addressList);
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        System.out.println(result);
        String email = addressList.get(0);
        if (userDao.findByEmail(email) != null) {
            User u = userDao.findByEmail(email);
            u.setPassword(result);
            userService.changePassword(u);
            String username = u.getUsername();
            email_email.setToAddress(addressList);
            email_email.setSubject("Forgot password");
            email_email.setContent("Hi"+username+", here is your new password " + result);
            mailService.sendMail(email_email);
            return new Response(true);
        } else {
            return new Response(false);
        }

    }
}
