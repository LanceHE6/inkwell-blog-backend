package com.inkwell.inkwellblog;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

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
    @PostMapping("test")
    public UserData test(@RequestParam String uid, @RequestParam String psw) {
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

    @PostMapping("login")
    public UserData logIn(@RequestParam String uid, @RequestParam String psw) throws SQLException, ClassNotFoundException {
        SqliteHelper sqliteHelper = new SqliteHelper("inkwellDb.db");
        String sqlCreateString = "create table if not exists User(userId text, password text)";
        sqliteHelper.executeUpdate(sqlCreateString);

        // 添加数据 账号123456， 密码abcde
        String sqlAddString = "insert into User(userId, password) values('123456', 'abcde')";
        sqliteHelper.executeUpdate(sqlAddString);

        //读取数据
        String sqlQueryString = "select * from User where userId = 123456";
        String result = sqliteHelper.executeQuery(sqlQueryString, resultSet -> {
            return resultSet.getString("password");
        });

        // UserData为数据类，用于封装数据
        UserData userData = new UserData();
        // 将传入的参数设置给数据类
        userData.setUserId("123456");
        userData.setPassword(result);
        // 返回数据 like:
        /*
         *{userId: uid, password: psw}
         * */
        return userData;
    }
}
