package org.wrn.train.member.service;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.wrn.train.common.exception.BusinessException;
import org.wrn.train.common.exception.BusinessExceptionEnum;
import org.wrn.train.member.domain.Member;
import org.wrn.train.member.domain.MemberExample;
import org.wrn.train.member.mapper.MemberMapper;
import org.wrn.train.member.req.MemberRegisterReq;

import java.util.List;

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

    public long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(members)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);

        memberMapper.insert(member);

        return member.getId();
    }
}
