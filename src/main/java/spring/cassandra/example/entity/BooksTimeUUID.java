package spring.cassandra.example.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table
public class BooksTimeUUID {
	@PrimaryKey
	private BooksTimeUUIDKey booksTimeUUID;
	@Column
	private String author;
	@Column
	private String genre;
	@Column
	private String height;
	@Column
	private String publisher;

	public BooksTimeUUID(BooksTimeUUIDKey booksTimeUUID, String author, String genre, String height, String publisher) {
		super();
		this.booksTimeUUID = booksTimeUUID;
		this.author = author;
		this.genre = genre;
		this.height = height;
		this.publisher = publisher;
	}

	public BooksTimeUUIDKey getBooksTimeUUID() {
		return booksTimeUUID;
	}

	public void setBooksTimeUUID(BooksTimeUUIDKey booksTimeUUID) {
		this.booksTimeUUID = booksTimeUUID;
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