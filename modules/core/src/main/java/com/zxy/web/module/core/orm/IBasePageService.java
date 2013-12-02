package com.zxy.web.module.core.orm;

import com.zxy.web.module.core.orm.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * page base service interface
 *
 * @author James
 *
 */
public interface IBasePageService<T extends Serializable, ID extends Serializable> extends IBaseService {
    abstract Page<T> findAll(Pageable pageable);



}
