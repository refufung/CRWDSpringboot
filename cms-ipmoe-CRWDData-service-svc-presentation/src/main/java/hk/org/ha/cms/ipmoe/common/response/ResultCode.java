package hk.org.ha.cms.ipmoe.common.response;

public enum ResultCode  {

    //HTTP Error
    SUCCESS(200, "success"),
    PAGE_NOT_FOUND(404, "page not found"),
    SYSTEM_ERROR(500, "system error,please try again later"),

    //Assert Error
    ASSERT_ERROR(4000, "assert error"),
    ASSERT_NULL(4001, "data not found"),

    //Parameter Error 10001-19999
    PARAM_IS_INVALID(10001, "parameter is invalid"),

    //Customize Error 20001-29999
    USER_HAS_EXPIRED(20001, "user has been expired or not exists, please try to login again"),
    USER_NOT_FIND(20002, "username does not exist");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}
