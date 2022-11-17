package hk.org.ha.cms.ipmoe.repository;

import hk.org.ha.cms.ipmoe.entity.IpOrderLock;
import hk.org.ha.cms.ipmoe.entity.primaryKey.IpOrderLockPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface createdateRepository extends JpaRepository<IpOrderLock, IpOrderLockPK> {

    IpOrderLock save (IpOrderLock ipOrderLock);

}
