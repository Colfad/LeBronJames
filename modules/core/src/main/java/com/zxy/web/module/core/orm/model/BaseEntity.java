package com.zxy.web.module.core.orm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础的java bean 类定义整体共同的数据库表对象
 *
 * @author James
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 9082079979547699176L;

	/**
     * id 这里使用的是为uuid的形式
     */
    protected String id;

    protected Date createDate;


    /**
     * 使用的数据库为mysql
     * 如果想使用Integer的自增长
     * 请自行修改
     * 
     * 使用JPA自动生成的UUID并不是特别的好
     * @return
     */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy="assigned")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
