package com.zxy.web.module.core.db;

import com.jolbox.bonecp.BoneCPDataSource;
import com.zxy.web.module.core.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据连接池的管理类，使用BoneCP技术来作为连接池
 *
 * @author James
 */
public class DBConnectionUtil {

    private static Logger logger = LoggerFactory.getLogger(DBConnectionUtil.class);

    /**
     * 获得连接
     *
     * @return
     * @throws java.sql.SQLException
     */
    public static synchronized Connection getConnection() throws SQLException {
        BoneCPDataSource dataSource = (BoneCPDataSource) SpringContextHolder.getBean("dataSource");
        return dataSource.getConnection();
    }

    /**
     * 因为使用JDK1.7,故不再需要finally语句去把Connection这些对象关闭
     * 
     * @param statement
     * @param resultSet
     */
    public static void close(Statement statement, ResultSet resultSet) {
        try {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        } catch (Exception e) {
            logger.error("close connection, had catch a exception{}", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("close connection, had catch a exception{}", e);
        } finally {
            close(statement, resultSet);
        }
    }
}
