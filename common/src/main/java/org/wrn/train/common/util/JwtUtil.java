package org.wrn.train.common.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-14 17:12
 **/
public class JwtUtil {
    private static final String salt = "12306";

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    public static String creatToken(Long id, String mobile) {
        DateTime now = DateTime.now();
        DateTime expire = now.offsetNew(DateField.HOUR, 24);

        Map<String, Object> payload = new HashMap<>();
        payload.put(JWTPayload.ISSUED_AT, now);
        payload.put(JWTPayload.EXPIRES_AT, expire);
        payload.put(JWTPayload.NOT_BEFORE, now);

        payload.put("id", id);
        payload.put("mobile", mobile);

        String token = JWTUtil.createToken(payload, salt.getBytes());
        LOGGER.info("生成Token");
        return token;
    }


}
