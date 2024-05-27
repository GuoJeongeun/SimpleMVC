package com.example.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class JDBCUtils {
    private static final DataSource ds;

    static {
        // 加载配置文件
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
