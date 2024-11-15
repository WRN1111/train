package org.wrn.train.member.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-14 16:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginResp {

    private Long id;

    private String mobile;

    private String token;

}
