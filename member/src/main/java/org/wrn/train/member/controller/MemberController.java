package org.wrn.train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wrn.train.common.resp.CommonResp;
import org.wrn.train.member.req.MemberRegisterReq;
import org.wrn.train.member.service.MemberService;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-11 17:37
 **/

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
        CommonResp<Integer> resp = new CommonResp<>();
        resp.setContent(count);
        return resp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req) {
        Long register = memberService.register(req);
        CommonResp<Long> resp = new CommonResp<>();
        resp.setContent(register);
        return resp;
    }


}
