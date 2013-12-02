package com.zxy.web.framework.locus.repository.jpa;


import com.zxy.web.framework.locus.model.IcterusOperate;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IcterusOperateDao extends PagingAndSortingRepository<IcterusOperate, String>, JpaSpecificationExecutor<IcterusOperate> {

    @Query("select icterusOperate from IcterusOperate icterusOperate where icterusOperate.parent.id=?1")
    IcterusOperate getByParentId(String parentId);
}
