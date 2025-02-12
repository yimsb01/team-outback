package com.test.chj.practice2.config;

import javax.sql.DataSource;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

@MapperScan("com.test.chj.practice2.dao")

public class MybatisConfig {
  
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, ApplicationContext appCtx) throws Exception {

    // Mybatis의 Log4j2를 활성화 시키기
    LogFactory.useLog4J2Logging();

    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.test.chj.practice2.domain");
    sqlSessionFactoryBean.setMapperLocations(
        appCtx.getResources("classpath:com/test/chj/mapper/*Mapper.xml"));
    
    return sqlSessionFactoryBean.getObject();
  }
}






