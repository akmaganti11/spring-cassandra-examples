package spring.cassandra.example.util;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public interface BooksUtil {

	static List<String[]> readCSVRecords() throws IOException, URISyntaxException, CsvException {
		Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("books.csv").toURI()));
		CSVReader csvReader = new CSVReader(reader);
		List<String[]> records = new ArrayList<>();
		try {
			records = csvReader.readAll();
		} finally {
			reader.close();
			csvReader.close();
		}
		return records;
	}
}
