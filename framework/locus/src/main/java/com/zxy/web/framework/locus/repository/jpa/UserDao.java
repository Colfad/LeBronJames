package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User用户的Dao层
 *
 * @author James
 */
public interface UserDao extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User> {

    public User findByUserName(String userName);

    public User findByEmail(String email);
}
