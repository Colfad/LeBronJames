package com.zxy.web.framework.locus.repository.mybatis;

import com.zxy.web.framework.locus.model.GoodType;
import com.zxy.web.module.core.annotation.MyBatisDaoAnnotation;

import java.util.List;

/**
 * 货物类型的DAO
 *
 * @author James
 */
@MyBatisDaoAnnotation
public interface GoodTypeMyBatisDao {

    public List<GoodType> findAll();

    public List<GoodType> findChildById(String parentId);

}
