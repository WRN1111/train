package org.wrn.train.member.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-13 16:38
 **/
@Data
public class MemberRegisterReq {
    @NotBlank(message = "【手机号】不能为空")
    private String mobile;
}
