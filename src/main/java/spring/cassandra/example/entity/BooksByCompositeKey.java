package spring.cassandra.example.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class BooksByCompositeKey {

	@PrimaryKey
	private BooksCompositeKey bookCompositeKey;
	@Column
	private String title;
	@Column
	private String height;
	@Column
	private String publisher;

	public BooksByCompositeKey(BooksCompositeKey bookCompositeKey, String title, String height, String publisher) {
		super();
		this.bookCompositeKey = bookCompositeKey;
		this.title = title;
		this.height = height;
		this.publisher = publisher;
	}

	public BooksCompositeKey getBookCompositeKey() {
		return bookCompositeKey;
	}

	public void setBookCompositeKey(BooksCompositeKey bookCompositeKey) {
		this.bookCompositeKey = bookCompositeKey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
