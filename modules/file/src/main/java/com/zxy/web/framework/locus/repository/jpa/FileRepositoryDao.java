package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.FileRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * FileRepository的dao层类
 *
 * @author James
 */
public interface FileRepositoryDao extends PagingAndSortingRepository<FileRepository, String>, JpaSpecificationExecutor<FileRepository> {
}
