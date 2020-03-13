package spring.cassandra.example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import spring.cassandra.example.entity.Book;

@Configuration
@EnableCassandraRepositories
@EntityScan(basePackageClasses = Book.class)
public class CassandraConfig extends AbstractCassandraConfiguration {

	private static final String KEYSPACE = "spring";
	private static final String USERNAME = "cassandra";
	private static final String PASSWORD = "cassandra";
	private static final String CONTACT_POINTS = "127.0.0.1";
	private static final Integer PORT = 9042;

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(CONTACT_POINTS);
		cluster.setPort(PORT);
		cluster.setUsername(USERNAME);
		cluster.setPassword(PASSWORD);
		cluster.setKeyspaceCreations(getKeyspaceCreations());
		return cluster;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		List<CreateKeyspaceSpecification> createKeyspaceSpecifications = new ArrayList<>();
		createKeyspaceSpecifications.add(getKeySpaceSpecification());
		return createKeyspaceSpecifications;
	}

	private CreateKeyspaceSpecification getKeySpaceSpecification() {
		CreateKeyspaceSpecification keyspaceSpecification = CreateKeyspaceSpecification.createKeyspace(KEYSPACE)
				.ifNotExists();
		return keyspaceSpecification;
	}

	@Override
	protected String getKeyspaceName() {
		return KEYSPACE;
	}

 	@Override
	public String[] getEntityBasePackages() {
		return new String[] { "spring.cassandra.example.entity" };
	}

}
