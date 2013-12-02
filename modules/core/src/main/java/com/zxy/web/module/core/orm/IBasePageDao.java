package com.zxy.web.module.core.orm;

import com.zxy.web.module.core.orm.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * 分页使用的DAO接口
 *
 * @author James
 *
 */
public interface IBasePageDao<T extends Serializable, ID extends Serializable> extends IBaseDao {

    /**
     * 根据分页的条件进行分页的操作
     *
     * @param pageable 分页条件
     * @return
     */
    public Page<T> findAll(Pageable pageable);

}
