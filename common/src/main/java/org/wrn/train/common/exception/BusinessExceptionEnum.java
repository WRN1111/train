package org.wrn.train.common.exception;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-13 17:20
 **/
public enum BusinessExceptionEnum {

    MEMBER_MOBILE_EXIST("手机号已注册");


    private String desc;

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BusinessExceptionEnum{" +
                "desc='" + desc + '\'' +
                "} " + super.toString();
    }
}
