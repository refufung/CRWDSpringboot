package hk.org.ha.cms.ipmoe.dataService;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hk.org.ha.cms.ipmoe.entity.IpOrderLock;
import hk.org.ha.cms.ipmoe.entity.QIpOrderLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j


public class UpdateDataService {
    @Autowired
    private JPAQueryFactory queryFactory;

    private QIpOrderLock qIpOrderLock = QIpOrderLock.ipOrderLock;

    public List<IpOrderLock> updateIpOrderLockByCaseNoOrdNoPatKey(IpOrderLock ipOrderLock){
        return queryFactory
                .select(qIpOrderLock)
                .from(qIpOrderLock)
                .where(qIpOrderLock.patHospcode.eq(ipOrderLock.getPatHospcode())
                        .and(qIpOrderLock.patHospcode.eq(ipOrderLock.getPatHospcode()))
                        //.and(qNewOrders.ordNo.in(ipOrderLock.getOrdNoList()))
                        //.and(qIpOrderLock.caseNo.eq(ipOrderLock.getCaseNo()))
                )
                .fetch();
        //  q.setHint("eclipselink.refresh", "true");
        //    q.setParameter("patHospcode", patHospcode);
        //    q.setParameter("caseNo", caseNo);
        //    if(ordNoList.size()>0)
        //        q.setParameter("ordNoList", ordNoList);
        //    if(patientKey!=null && !patientKey.trim().equals(""))
        //        q.setParameter("patientKey", patientKey);
        //    ipOrderLockList = q.getResultList();
    }
}





