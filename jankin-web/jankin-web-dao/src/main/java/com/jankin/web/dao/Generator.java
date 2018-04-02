package com.jankin.web.dao;

import com.jankin.common.util.MybatisGeneratorUtil;
import com.jankin.common.util.PropertiesFileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * mysql逆向工程-代码生成类
 *
 * @author 刘洋印
 * @date 2018/3/29 9:05
 */
public class Generator {
    /**
     *  根据命名规范，只修改此常量值即可
     */
    private static String MODULE = "jankin-web";
    private static String DATABASE = "score_treasure";
    private static String TABLE_PREFIX = "";
    private static String PACKAGE_NAME = "com.jankin.web";
    private static String JDBC_DRIVER = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.driver");
    private static String JDBC_URL = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.url");
    private static String JDBC_USERNAME = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.username");
    private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.password");
    /**
     *  需要insert后返回主键的表配置，key:表名,value:主键名
     */
    private static Map<String, String> LAST_INSERT_ID_TABLES = new HashMap<>();
    static {
    }

    /**
     * 自动代码生成
     * @param args
     */
    public static void main(String[] args) throws Exception {
        MybatisGeneratorUtil.generator(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE, DATABASE, TABLE_PREFIX, PACKAGE_NAME, LAST_INSERT_ID_TABLES);
    }
}
