package com.zxy.web.module.core.orm;

import com.zxy.web.module.core.orm.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础的Service层接口封装
 *
 * @author James
 */
public interface IBaseService <T extends BaseEntity, ID extends Serializable> {
    /**
     * 持久化一个BaseEntity子类对象
     *
     * @param entity 持久化对象
     * @return 保存后的对象
     */
    abstract T save(T entity);

    /**
     * 根据id获得一个对象
     *
     * @param id 要查询的id
     * @return 查询获得的对象
     */
    abstract T getById(ID id);

    /**
     * 更新一个对象
     *
     * @param entity 要更新的对象
     * @return 更新后的对象
     */
    abstract T update(T entity);

    /**
     * 删除一个实体对象
     *
     * @param entity
     * @return
     */
    abstract void delete(T entity);

    /**
     * 根据id删除一个对象
     *
     * @param id
     */
    abstract void delete(ID id);

    /**
     * 查找到所有对象
     *
     * @return
     */
    abstract List<T> findAll();
    
    /**
     * 根据params来查找相应的数据
     *
     * @param params
     * @return
     */
    abstract List<T> findByParams(Map<String, Object> params);
    
}
