package com.zxy.web.module.core.orm;

import com.zxy.web.module.core.orm.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 基本的DAO层接口
 *
 * @author James
 * @param <T> 继承自BaseEntity对象的类
 * @param <ID> 实现序列化接口的ID，但是我们这里做的时候是不用考虑这点的，因为我们这里是用String类型的id
 */
public interface IBaseDao<T extends BaseEntity, ID extends Serializable> {

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
     * 查找到所有对象
     *
     * @return
     */
    abstract List<T> findAll();

    /**
     * 根据Hql查找对象
     *
     * @param hql hql语句
     * @return 查找到符合条件的所有对象
     */
    abstract List<T> findByHql(String hql);

    /**
     * 根据Sql语句查找对象
     *
     * @param sql
     * @return
     */
    abstract List<T> findBySql(String sql);


}
