package org.wrn.train.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-07 20:51
 **/

@RestController
public class TestController {


    @GetMapping("/hello")
    public String test() {
        return "test";
    }
}
