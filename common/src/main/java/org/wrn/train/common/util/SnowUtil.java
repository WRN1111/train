package org.wrn.train.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-13 17:40
 **/
public class SnowUtil {

    private static long dataCenterId = 1;  //数据中心
    private static long workerId = 1;     //机器标识

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
    }


}
