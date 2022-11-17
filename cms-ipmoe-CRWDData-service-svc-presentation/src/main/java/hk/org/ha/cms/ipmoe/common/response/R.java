package hk.org.ha.cms.ipmoe.common.response;

import lombok.Data;

@Data
public class R<T> {

    private Integer status;
    private String message;
    private T data;

    public static <T> R<T> success() {
        R<T> result = new R();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static <T> R<T> success(T data) {
        R<T> result = new R();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> R<T> error(Integer status, String desc) {
        R<T> result = new R();
        result.setStatus(status);
        result.setMessage(desc);
        return result;
    }

    public static <T> R<T> error(ResultCode resultCode) {
        R<T> result = new R();
        result.setResultCode(resultCode);
        return result;
    }

    private void setResultCode(ResultCode code) {
        this.status = code.code();
        this.message = code.message();
    }

}
