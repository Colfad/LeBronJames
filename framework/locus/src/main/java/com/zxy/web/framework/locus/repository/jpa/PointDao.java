package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.Point;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * 存储点的DAO层
 * 这里是用JPA来做的，但是考虑到加点的速度以及效率上来说
 * 我们这里会使用MyBatis技术来重新封装一遍DAO层
 *
 * @author James
 */
public interface PointDao extends PagingAndSortingRepository<Point, String>, JpaSpecificationExecutor<Point> {

}
