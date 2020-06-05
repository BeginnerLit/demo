package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.example.demo.mapper",sqlSessionFactoryRef = "bootdbSqlSessionFactory")
public class DataSourceConfig {
    private static Logger logger=LoggerFactory.getLogger(DataSourceConfig.class);

     @Bean(name = "bootdb")
     @ConfigurationProperties(prefix = "spring.datasource.bootdb")
     public DataSource bootdbDataSource() {
         return DataSourceBuilder.create().build();
     }

    @Bean("bootdbSqlSessionFactory")
    public SqlSessionFactory bootdbSqlSessionFactory(@Qualifier("bootdb") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //classpath这里必须带* 不然会报找不到xml
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/base/*.xml"));
        return bean.getObject();
     }


}
