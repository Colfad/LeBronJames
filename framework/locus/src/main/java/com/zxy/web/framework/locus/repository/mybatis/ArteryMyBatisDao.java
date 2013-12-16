package com.zxy.web.framework.locus.repository.mybatis;

import com.zxy.web.module.core.annotation.MyBatisDaoAnnotation;

import java.util.Map;

/**
 *
 * Artery MyBatis Dao以实现级联删除的效果，提高与数据库之间交互的速度
 *
 * @author James
 */
@MyBatisDaoAnnotation
public interface ArteryMyBatisDao {

    void updateArteryWhenDelete(Map<String, String> map);

    void deleteArtery(Map<String, String> map);

    void deleteClinic(Map<String, String> map);

    void deleteDescrib(Map<String, String> map);

    void deleteTreat(Map<String, String> map);

    void deleteVisit(Map<String, String> map);

    void deleteCoil(Map<String, String> map);

}
