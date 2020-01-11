package com.tjh.seckill.controller;

import com.tjh.seckill.domain.User;
import com.tjh.seckill.redis.RedisService;
import com.tjh.seckill.redis.UserKey;
import com.tjh.seckill.result.Result;
import com.tjh.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/demo")
public class SampleController {
    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "tjh");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user = userService.getByid(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
        userService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User v1 = redisService.get(UserKey.getById, "1", User.class);
        return Result.success(v1);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<User> redisSet() {
        User user = new User();
        user.setId(11);
        user.setName("long");
        boolean ret = redisService.set(UserKey.getById, "" + 1, user);
        if (ret == true) {
            User ans = redisService.get(UserKey.getById, "1", User.class);
            return Result.success(ans);
        } else {
            return null;
        }

    }

}
