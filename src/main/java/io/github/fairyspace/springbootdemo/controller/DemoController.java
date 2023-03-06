package io.github.fairyspace.springbootdemo.controller;

import io.github.fairyspace.springbootdemo.beans.req.UserReq;
import io.github.fairyspace.springbootdemo.beans.res.UserRes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping(value = "saveUser",produces = "application/json")
    public UserRes saveUser(@RequestBody UserReq userReq){
        System.err.println(userReq);
        UserRes userRes = new UserRes();
        userRes.setEmail("NNNNN");
        userRes.setName("GGGGG");
        return  userRes;
    }

    @PostMapping(value = "saveUser2",consumes ={"application/xml"},produces = "application/xml")
    public UserRes saveUser2(@RequestBody UserReq userReq){
        System.err.println(userReq);
        UserRes userRes = new UserRes();
        userRes.setEmail("NNNNN");
        userRes.setName("GGGGG");
        return  userRes;
    }
}
