package com.example.demo.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/*
 * 配置会话工厂
 */
@Configuration
public class SessionFactoryConfiguration {
	// mybatis-config.xml 配置文件路径
	@Value("${mybatis_config_file}")
	private String mybatisConfigFilePath;
	
	//mybatis mapper 文件所在路径
	@Value("${mapper_path}")
	private String mapperPath;
	
	//实体类package 所在路径
	@Value("${entity_package}")
	private String entityPackage;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean(name="SqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
		return sqlSessionFactoryBean;
	}
}
