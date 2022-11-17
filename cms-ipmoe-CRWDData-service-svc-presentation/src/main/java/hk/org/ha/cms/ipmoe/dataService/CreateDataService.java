package hk.org.ha.cms.ipmoe.dataService;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hk.org.ha.cms.ipmoe.repository.createdateRepository;
import hk.org.ha.cms.ipmoe.entity.IpOrderLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@Transactional
public class CreateDataService {
    @Autowired
    //private IpOrderLock ipOrderLock;
    private createdateRepository createdateRepository;

    @Autowired
    private JPAQueryFactory queryFactory;
    //private QIpOrderLock qIpOrderLock = QIpOrderLock.ipOrderLock;
    @Transactional
    public void createIpOrderLockByCaseNoOrdNoPatKey(IpOrderLock ipOrderLock) {
        System.out.println(ipOrderLock);
        createdateRepository.save(ipOrderLock);

       /* queryFactory.insert(qIpOrderLock)
                .columns(qIpOrderLock.patHospcode,
                        qIpOrderLock.ordNo,
                        /*qIpOrderLock.status,
                        qIpOrderLock.createBy,
                        qIpOrderLock.createDtm,
                        qIpOrderLock.updateBy,
                        qIpOrderLock.updateDtm,
                        qIpOrderLock.wrkStnId,
                        qIpOrderLock.fnName,
                        qIpOrderLock.fullname,
                        qIpOrderLock.caseNo,
                        qIpOrderLock.wrkStnType,*/
                     /*   qIpOrderLock.patientKey)
                        .values(ipOrderLock.getPatHospcode(),
                                ipOrderLock.getOrdNo(),*/
                                //ipOrderLock.getStatus(),
                                //ipOrderLock.getCreateBy(),
                                //ipOrderLock.getCreateDtm(),
                                /*ipOrderLock.getUpdateBy(),
                                ipOrderLock.getUpdateDtm(),
                                ipOrderLock.getWrkStnId(),
                                ipOrderLock.getFnName(),
                                ipOrderLock.getFullname(),
                                ipOrderLock.getCaseNo(),
                                ipOrderLock.getWrkStnType(),*/
                               /* ipOrderLock.getPatientKey())
                        .execute();*/

     //   return null;
    }
}
