package org.wrn.train.common.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wrn.train.common.resp.MemberLoginResp;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-18 11:03
 **/
public class LoginMemberContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginMemberContext.class);

    private static ThreadLocal<MemberLoginResp> memberLoginResp = new ThreadLocal<>();

    public static MemberLoginResp getMember() {
        return memberLoginResp.get();
    }

    public static void setMember(MemberLoginResp memberLoginResp) {
        LoginMemberContext.memberLoginResp.set(memberLoginResp);
    }

    public static Long getId() {
        try {
            return memberLoginResp.get().getId();
        } catch (Exception e) {
            LOGGER.error("获取登录会员信息异常", e);
            throw e;
        }
    }


}
