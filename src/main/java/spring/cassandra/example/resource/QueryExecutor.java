package spring.cassandra.example.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.cassandra.example.entity.TableData;
import spring.cassandra.example.service.BooksService;

@RestController
public class QueryExecutor {

	@Autowired
	private BooksService booksService;
	
	@PostMapping("/query")
	public List<TableData> executeQueryOverBooksByCompisteKetTable(String query) {
		return booksService.QueryBooksByCompositeKey(query);
	}
}
