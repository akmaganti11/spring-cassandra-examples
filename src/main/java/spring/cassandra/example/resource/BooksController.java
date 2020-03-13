package spring.cassandra.example.resource;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import spring.cassandra.example.entity.Books;
import spring.cassandra.example.repository.BooksRepository;

@RestController
public class BooksController {

	@Autowired
	private BooksRepository booksRepo;

	@GetMapping("/books")
	public List<Books> books() {
		return booksRepo.findAll();
	}

	@GetMapping("/books/id")
	public Books getBook(@RequestParam UUID id) {
		Optional<Books> books = booksRepo.findById(id);
		return books.get();
	}

	@PostMapping("/books")
	public void addBooks() throws IOException, URISyntaxException, CsvException {
		Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("books.csv").toURI()));
		CSVReader csvReader = new CSVReader(reader);
		String[] line;
		try {
			while ((line = csvReader.readNext()) != null) {
				booksRepo.save(new Books(line[0], line[1], line[2], line[3], line[4]));
			}
		} finally {
			reader.close();
			csvReader.close();
		}

	}

	@DeleteMapping("/books")
	public void truncateBooks() {
		booksRepo.deleteAll();
	}

}
