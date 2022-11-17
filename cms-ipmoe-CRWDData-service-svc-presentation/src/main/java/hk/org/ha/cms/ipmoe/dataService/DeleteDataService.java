package hk.org.ha.cms.ipmoe.dataService;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hk.org.ha.cms.ipmoe.entity.IpOrderLock;
import hk.org.ha.cms.ipmoe.entity.QIpOrderLock;
import hk.org.ha.cms.ipmoe.entity.primaryKey.IpOrderLockPK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@Transactional
public class DeleteDataService {
        @Autowired
        private JPAQueryFactory queryFactory;
        
        private QIpOrderLock qIpOrderLock = QIpOrderLock.ipOrderLock;

    public List<IpOrderLock> deleteIpOrderLockByCaseNoOrdNoPatKey(IpOrderLockPK ipOrderLockPK) {
        queryFactory.delete(qIpOrderLock)
                .where(qIpOrderLock.patHospcode.eq(ipOrderLockPK.getPatHospcode())
                        .and(qIpOrderLock.caseNo.eq(ipOrderLockPK.getCaseNo())))
                        .execute();

        return null;
    }
}
    



