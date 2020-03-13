package spring.cassandra.example.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Book {
	@PrimaryKey
	private UUID id;
	@Column
	private String title;
	@Column
	private String publisher;
	@Column
	private Set<String> tags = new HashSet<>();

	public Book(String title, String publisher, Set<String> tags) {
		super();
		this.id = UUID.randomUUID();
		this.title = title;
		this.publisher = publisher;
		this.tags = tags;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

}