package spring.cassandra.example.repository;

import java.util.Collection;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import spring.cassandra.example.entity.BooksByCompositeKey;
import spring.cassandra.example.entity.BooksCompositeKey;

public interface BooksByCompositeKeyRepository extends CassandraRepository<BooksByCompositeKey, BooksCompositeKey> {

	@Query("Select * from booksbycompositekey")
	Collection<BooksByCompositeKey> findAllBooks();
}
