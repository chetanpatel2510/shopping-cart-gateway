/**
 * 
 */
package com.shoppingcart.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * @author root
 *
 */
@Configuration
@EnableCassandraRepositories(basePackages="com.shoppingcart.gateway.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

	/**
	 * Cassandra keyspace name for product service.
	 */
	@Value("${cassandra.keyspace.name}")
	private String keySpaceName;
	
	/**
	 * IP Address of the cassandra host
	 */
	@Value("${cassandra.host.ip}")
	private String hostIp;
	
	/**
	 * Port number of cassandra.
	 */
	@Value("${cassandra.port}")
	private int port;
	
	/**
	 * Get key space name for the product service.
	 */
	@Override
	protected String getKeyspaceName() {
		return keySpaceName;
	}
	
	@Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = 
          new CassandraClusterFactoryBean();
        cluster.setContactPoints(hostIp);
        cluster.setPort(port);
        cluster.setJmxReportingEnabled(false);
        return cluster;
    }
 
    @Bean
    public CassandraMappingContext cassandraMapping() 
      throws ClassNotFoundException {
        return new CassandraMappingContext();
    }
}
