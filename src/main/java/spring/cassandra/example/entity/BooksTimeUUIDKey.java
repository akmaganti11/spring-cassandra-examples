package spring.cassandra.example.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import com.datastax.driver.core.utils.UUIDs;

@PrimaryKeyClass
public class BooksTimeUUIDKey {
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private UUID id;
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private String title;

	public BooksTimeUUIDKey(String title) {
		super();
		this.id = UUIDs.timeBased();
		this.title = title;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
