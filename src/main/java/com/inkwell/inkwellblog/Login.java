package com.inkwell.inkwellblog;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Login {
    @PostMapping("login")
    public UserData logIn(@RequestParam String uid, @RequestParam String psw) {
        UserData userData = new UserData();
        userData.setUserId(uid);
        userData.setPassword(psw);
        return userData;
    }
}
