package com.rara.app;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan("com.rara.app.model.mapper")
public class RaraApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaraApplication.class, args);

    }

    @Bean
    SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("/mybatis/mapper/**/*.xml");
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }

}