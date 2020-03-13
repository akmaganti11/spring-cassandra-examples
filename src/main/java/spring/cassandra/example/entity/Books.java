package spring.cassandra.example.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Books {

	@PrimaryKey
	private UUID id;
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private String genre;
	@Column
	private String height;
	@Column
	private String publisher;

	public Books(String title, String author, String genre, String height, String publisher) {
		super();
		this.id = UUID.randomUUID();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.height = height;
		this.publisher = publisher;
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

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
