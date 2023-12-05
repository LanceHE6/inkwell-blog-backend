package com.inkwell.inkwellblog;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Login {
    /**
     * login请求示例
     * @param uid uid参数
     * @param psw password参数
     * @return 返回请求的uid和密码
     */
    @PostMapping("login")
    public UserData logIn(@RequestParam String uid, @RequestParam String psw) {
        // UserData为数据类，用于封装数据
        UserData userData = new UserData();
        // 将传入的参数设置给数据类
        userData.setUserId(uid);
        userData.setPassword(psw);
        // 返回数据 like:
        /*
        *{userId: uid, password: psw}
        * */
        return userData;
    }
}
