package com.zhuicat.enums;

public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功啦，亲~~~"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作啦，亲~~~"),
    NO_OPERATOR_AUTH(403,"无权限操作啦，亲~~~"),
    SYSTEM_ERROR(500,"出现错误啦，亲~~~"),
    USERNAME_EXIST(501,"用户名已存在啦，亲~~~"),
    PHONENUMBER_EXIST(502,"手机号已存在啦，亲~~~"),
    EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名啦，亲~~~"),
    COMMENT_NOT_NULL(506, "评论内容不能为空，亲~~~"),
    FILE_TYPE_ERROR(507,"文件类型错误，请上传png文件"),
    USERNAME_NOT_NULL(508,"用户名不能为空，亲~"),
    NICKNAME_NOT_NULL(509,"昵称不能为空，亲~"),
    PASSWORD_NOT_NULL(510,"密码不能为空，亲~"),
    EMAIL_NOT_NULL(510,"邮箱不能为空，亲~"),
    NICKNAME_EXIST(511,"昵称已存在啦，亲~~~"),
    LOGIN_ERROR(505,"用户名或密码错误啦，亲~~~");

    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
