package org.wrn.train.member.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.wrn.train.member.mapper.MemberMapper;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-11 17:35
 **/
@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }
}
