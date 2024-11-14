package org.wrn.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-14 16:29
 **/

@Data
public class MemberSendCodeReq {

    @NotBlank(message = "【手机号】不能为空")
    @Pattern(regexp = "^\\d{10}$", message = "手机号码格式错误")
    private String mobile;
}
