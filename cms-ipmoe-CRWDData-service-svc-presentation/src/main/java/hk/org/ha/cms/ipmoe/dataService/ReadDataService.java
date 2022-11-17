package hk.org.ha.cms.ipmoe.dataService;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hk.org.ha.cms.ipmoe.entity.IpOrderLock;
import hk.org.ha.cms.ipmoe.entity.QIpOrderLock;
import hk.org.ha.cms.ipmoe.entity.QNewOrders;
import hk.org.ha.cms.ipmoe.entity.primaryKey.IpOrderLockPK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hk.org.ha.cms.ipmoe.entity.NewOrders;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Service
@Slf4j


public class ReadDataService{
        @Autowired
        private JPAQueryFactory queryFactory;
        private QNewOrders qNewOrders = QNewOrders.newOrders;
        private QIpOrderLock qIpOrderLock = QIpOrderLock.ipOrderLock;


    public List<NewOrders> queryNewOrdersByCase(NewOrders newOrders){



        return queryFactory
                .select(qNewOrders)
                .from(qNewOrders)
                .where(qNewOrders.patHospcode.eq(newOrders.getPatHospcode())
                        .and(qNewOrders.caseNo.eq(newOrders.getCaseNo()))
                        .and(qNewOrders.prescType.eq("I"))
                        .and(qNewOrders.ordStatus.in("O"))
                        ) 
                .orderBy(qNewOrders.bedNo.asc())
                .fetch();

        //if (newOrdersList != null && newOrdersList.size() > 0) {
        //    for (int i = 0; i < newOrdersList.size(); i++) {
        //        newOrdersList.get(i).getNewMedProfileChargeHdr();
        //    }

    }



    public List<IpOrderLock> queryIpOrderLockByCaseNoOrdNoPatKey(IpOrderLock ipOrderLock){
        return queryFactory
                .select(qIpOrderLock)
                .from(qIpOrderLock)
                .where(qIpOrderLock.patHospcode.eq(ipOrderLock.getPatHospcode())
                        .and(qIpOrderLock.patHospcode.eq(ipOrderLock.getPatHospcode()))
                        .and(qIpOrderLock.caseNo.eq(ipOrderLock.getCaseNo()))
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

    public List<IpOrderLock> queryIpOrderLockList(IpOrderLockPK ipOrderLockPK){

        return queryFactory
                .select(qIpOrderLock)
                .from(qIpOrderLock)
                .where(qIpOrderLock.patHospcode.eq(ipOrderLockPK.getPatHospcode())
                        .and(qIpOrderLock.caseNo.eq(ipOrderLockPK.getCaseNo()))
                )
                .fetch();

        //System.out.println(ipOrderLockPK.getCaseNo());
        //System.out.println(ipOrderLockPK.getPatHospcode());

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
    




