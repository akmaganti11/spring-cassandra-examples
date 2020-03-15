package spring.cassandra.example.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import spring.cassandra.example.entity.BooksByCompositeKey;
import spring.cassandra.example.entity.TableData;
import spring.cassandra.example.repository.BooksByCompositeKeyRepository;
import spring.cassandra.example.service.BooksService;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksByCompositeKeyRepository booksByCompositeKeyRepo;

	@Autowired
	private Session clusterSession;

	@Override
	public Collection<BooksByCompositeKey> findAllBooksByCompositeKey() {
		return booksByCompositeKeyRepo.findAllBooks();
	}

	@Override
	public List<TableData> QueryBooksByCompositeKey(String query) {
		List<TableData> tableDataList = new ArrayList<>();

		ResultSet rs = clusterSession.execute(query);
		Set<String> columns = new HashSet<>();

		rs.getColumnDefinitions().forEach(rd -> {
			columns.add(rd.getName());
		});

		rs.all().stream().forEach(row -> {
			TableData tableData = new TableData();
			Map<String, Object> dataMap = new HashMap<>();
			columns.forEach(k -> {
				dataMap.put(k, row.getObject(k));
			});
			tableData.setData(dataMap);
			tableDataList.add(tableData);
		});

		return tableDataList;
	}

}
