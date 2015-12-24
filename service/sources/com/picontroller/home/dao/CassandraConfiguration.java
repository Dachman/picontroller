package com.picontroller.home.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.picontroller.home.properties.DatabaseProperties;

/**
 * Cassandra database initialization.
 * 
 * @author dcharles
 */
@Configuration
@EnableCassandraRepositories(basePackages = { "com.picontroller.home.dao" })
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	@Autowired
	DatabaseProperties databaseProperties;

	@Bean
	@Override
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(databaseProperties.getHost());
		cluster.setPort(databaseProperties.getPort());
		return cluster;
	}

	@Override
	protected String getKeyspaceName() {
		return databaseProperties.getKeyspace();
	}

	@Bean
	@Override
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}

}