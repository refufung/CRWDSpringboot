package hk.org.ha.cms.ipmoe.entity.primaryKey;


import lombok.Data;

import java.io.Serializable;

@Data
public class IpOrderLockPK implements Serializable {
    //private String patHospcode;
    private Integer ordNo;
    private String caseNo;
    private String patHospcode;

    public IpOrderLockPK() {
    }

    public IpOrderLockPK(String patHospcode, int ordNo) {
        this.patHospcode = patHospcode;
        this.ordNo = ordNo;
    }
}