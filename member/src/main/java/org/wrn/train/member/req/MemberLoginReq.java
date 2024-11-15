package org.wrn.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-14 16:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginReq {

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1\\d{10}$", message = "手机号码格式错误")
    private String mobile;

    @NotBlank(message = "短信验证码不能为空")
    private String code;
}
