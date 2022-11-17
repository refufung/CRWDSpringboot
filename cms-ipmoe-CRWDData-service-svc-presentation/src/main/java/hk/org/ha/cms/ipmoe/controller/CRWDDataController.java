package hk.org.ha.cms.ipmoe.controller;

import hk.org.ha.cms.ipmoe.common.response.R;
import hk.org.ha.cms.ipmoe.dataService.CreateDataService;
import hk.org.ha.cms.ipmoe.dataService.DeleteDataService;
import hk.org.ha.cms.ipmoe.dataService.ReadDataService;
import hk.org.ha.cms.ipmoe.dataService.UpdateDataService;
import hk.org.ha.cms.ipmoe.dto.ipOrderLockQueryDTO;
import hk.org.ha.cms.ipmoe.entity.IpOrderLock;
import hk.org.ha.cms.ipmoe.entity.NewOrders;
import hk.org.ha.cms.ipmoe.entity.primaryKey.IpOrderLockPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(
        allowCredentials = "true",
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT}
)
@Validated
@RestController
@RequestMapping("/api")
public class CRWDDataController {
    @Autowired
    ReadDataService readDataService;

    @GetMapping("/getNewOrdersByCase")
    public R<List<NewOrders>> NewOrdersByCase() {
        NewOrders newOrders = new NewOrders();
        List<NewOrders> requestList = readDataService.queryNewOrdersByCase(newOrders);
        return R.success(requestList);
    }

    @GetMapping("/getIpOrderLockByCaseNoOrdNoPatKey")
    public R<List<IpOrderLock>> IpOrderLockByCaseNoOrdNoPatKey() {
        IpOrderLock ipOrderLock = new IpOrderLock();
        List<IpOrderLock> requestList = readDataService.queryIpOrderLockByCaseNoOrdNoPatKey(ipOrderLock);
        return R.success(requestList);
    }

    @CrossOrigin(
            allowCredentials = "true",
            origins = "http://localhost:3000",
            allowedHeaders = "*",
            methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
    )
    @PostMapping("/IpOrderLock")
    public R<List<IpOrderLock>> IpOrderLockList(@RequestBody @Valid ipOrderLockQueryDTO IpOrderlock) {
        IpOrderLockPK ipOrderLockPK = new IpOrderLockPK();
        ipOrderLockPK.setCaseNo(IpOrderlock.getCaseNo());
        ipOrderLockPK.setPatHospcode(IpOrderlock.getPatHospcode());
        List<IpOrderLock> requestList = readDataService.queryIpOrderLockList(ipOrderLockPK);
        return R.success(requestList);
    }

    @Autowired
    CreateDataService createDataService;

    @GetMapping("/CreateIpOrderLockByCaseNoOrdNoPatKey")
    public R<String> CreateIpOrderLockByCaseNoOrdNoPatKey(){
        IpOrderLock i = new IpOrderLock();
        i.setPatHospcode("DH");
        //i.setOrdNo(ipOrderLock.getOrdNo());
        i.setCaseNo(" HN12345340z");
        i.setStatus("");
        i.setCreateBy("@CMSIT");
        i.setCreateDtm(Timestamp.valueOf("1999-10-04 11:22:33"));
        i.setUpdateBy("");
        i.setUpdateDtm(Timestamp.valueOf("1999-10-04 44:55:66"));
        i.setWrkStnId("");
        i.setFnName("");
        i.setFullname("");
        i.setWrkStnType("");
        i.setPatientKey("");
        i.setOrdNo(0);
        createDataService.createIpOrderLockByCaseNoOrdNoPatKey(i);
        return R.success("Success");
    }
    @Autowired
    UpdateDataService updateDataService;

    @GetMapping("/UpdateIpOrderLockByCaseNoOrdNoPatKey")
    public R<List<IpOrderLock>> UpdateIpOrderLockByCaseNoOrdNoPatKey() {
        IpOrderLock ipOrderLock = new IpOrderLock();
        ipOrderLock.setPatHospcode("VH");
        List<IpOrderLock> requestList = updateDataService.updateIpOrderLockByCaseNoOrdNoPatKey(ipOrderLock);
        return R.success(requestList);
    }

    @Autowired
    DeleteDataService deleteDataService;

    @CrossOrigin(
            allowCredentials = "true",
            origins = "http://localhost:3000",
            allowedHeaders = "*",
            methods = {RequestMethod.GET,
                    RequestMethod.POST,
                    RequestMethod.DELETE,
                    RequestMethod.PUT
            }
    )
    @PostMapping ("/deleteIpOrderLock")
    public R<List<IpOrderLock>> DeleteLockByCaseNoOrdNoPatKey(@RequestBody @Valid ipOrderLockQueryDTO IpOrderlock) {
        IpOrderLockPK ipOrderLockPK = new IpOrderLockPK();
        ipOrderLockPK.setCaseNo(IpOrderlock.getCaseNo());
        ipOrderLockPK.setPatHospcode(IpOrderlock.getPatHospcode());
        List<IpOrderLock> requestList = deleteDataService.deleteIpOrderLockByCaseNoOrdNoPatKey(ipOrderLockPK);
        System.out.println(requestList);
        return R.success(requestList);
    }
}