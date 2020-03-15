package spring.cassandra.example.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.datastax.driver.core.Row;

import spring.cassandra.example.entity.BooksByCompositeKey;
import spring.cassandra.example.entity.TableData;

@Service
public interface BooksService {
	Collection<BooksByCompositeKey> findAllBooksByCompositeKey();
	
	List<TableData> QueryBooksByCompositeKey(String query);
}
