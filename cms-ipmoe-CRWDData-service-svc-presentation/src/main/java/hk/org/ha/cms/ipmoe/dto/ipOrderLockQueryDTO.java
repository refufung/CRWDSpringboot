package hk.org.ha.cms.ipmoe.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ipOrderLockQueryDTO {
    @Size(max = 3)
    @NotNull
    private String patHospcode;

    @Size(max = 12)
    @NotNull
    private String caseNo;
}