package com.tjh.seckill.controller;

import com.tjh.seckill.domain.User;
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

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "tjh");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(Model model) {
        User user = userService.getByid(1);
        return Result.success(user);
    }

}
