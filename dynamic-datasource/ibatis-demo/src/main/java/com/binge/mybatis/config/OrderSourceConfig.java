package com.binge.mybatis.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.binge.mybatis.mapper.order", sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class OrderSourceConfig {

    /**
     * 创建 orders 数据源
     */
    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.order")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 MyBatis SqlSessionFactory
     */
    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        // <2.1> 设置 orders 数据源
        bean.setDataSource(this.dataSource());
        // <2.2> 设置 entity 所在包
        bean.setTypeAliasesPackage("com.binge.mybatis.model");
        // <2.3> 设置 config 路径
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        // <2.4> 设置 mapper 路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/order/*.xml"));
        return bean.getObject();
    }

    /**
     * 创建 MyBatis SqlSessionTemplate
     */
    @Bean(name = "orderSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
            return new SqlSessionTemplate(this.sqlSessionFactory());
    }

    /**
     * 创建 orders 数据源的 TransactionManager 事务管理器
     */
    @Bean(name = "OrderTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

}
