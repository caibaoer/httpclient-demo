package com.hwc.controller;

import com.hwc.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/8/27 16:56
 * @Created by huangwencai
 */
@RestController
public class UserController {

    @RequestMapping(value = "testhttpclientGet",method = RequestMethod.GET)
    public String testhttpclientGet(){
        return "hello  get ...";
    }


    @RequestMapping(value = "testhttpclientPost",method = RequestMethod.POST)
    public String testhttpclientPost(User user){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user.toString();
    }
}
