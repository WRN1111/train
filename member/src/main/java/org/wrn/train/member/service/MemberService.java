package org.wrn.train.member.service;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.wrn.train.common.exception.BusinessException;
import org.wrn.train.common.exception.BusinessExceptionEnum;
import org.wrn.train.common.util.SnowUtil;
import org.wrn.train.member.domain.Member;
import org.wrn.train.member.domain.MemberExample;
import org.wrn.train.member.mapper.MemberMapper;
import org.wrn.train.member.req.MemberRegisterReq;
import org.wrn.train.member.req.MemberSendCodeReq;

import java.util.List;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-11 17:35
 **/
@Service
public class MemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    // TODO JWT+salt认证方法
    public long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        // TODO redis查一遍
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(members)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);

        memberMapper.insert(member);

        return member.getId();
    }


    public void sendCode(MemberSendCodeReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);

        if (CollUtil.isNotEmpty(members)) {
            LOGGER.info("手机号不存在,插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);

            memberMapper.insert(member);
        } else {
            LOGGER.info("手机号存在 不插入记录");
        }

        String code = "8888";
        LOGGER.info("生成验证码: {}", code);


        // 保存短信记录表：手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，使用时间
        LOGGER.info("保存短信记录表");

        // 对接短信通道，发送短信
        LOGGER.info("对接短信通道");
    }
}
