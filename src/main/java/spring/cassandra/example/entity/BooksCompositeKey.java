package spring.cassandra.example.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class BooksCompositeKey {

	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordinal = 0)
	private UUID id;
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 0)
	private String author;
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 1)
	private String genre;

	public BooksCompositeKey(UUID id, String author, String genre) {
		super();
		this.id = id;
		this.author = author;
		this.genre = genre;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
