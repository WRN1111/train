package org.wrn.train.common.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
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
        LOGGER.info("生成Token :{}", token);
        return token;
    }

    public static boolean validate(String token) {
        JWT jwt = JWTUtil.parseToken(token).setKey(salt.getBytes());
        // validate包含了verify
        boolean validate = jwt.validate(0);
        LOGGER.info("JWT token校验结果：{}", validate);
        return validate;
    }

    public static JSONObject getJSONObject(String token) {
        JWT jwt = JWTUtil.parseToken(token).setKey(salt.getBytes());
        JSONObject payloads = jwt.getPayloads();
        payloads.remove(JWTPayload.ISSUED_AT);
        payloads.remove(JWTPayload.EXPIRES_AT);
        payloads.remove(JWTPayload.NOT_BEFORE);
        LOGGER.info("根据token获取原始内容：{}", payloads);
        return payloads;
    }

}
