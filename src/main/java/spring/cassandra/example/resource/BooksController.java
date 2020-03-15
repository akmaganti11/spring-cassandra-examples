package spring.cassandra.example.resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvException;

import spring.cassandra.example.entity.Books;
import spring.cassandra.example.repository.BooksRepository;
import spring.cassandra.example.util.BooksUtil;

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
		List<String[]> records = BooksUtil.readCSVRecords();
		records.stream().forEach(r -> booksRepo.save(new Books(r[0], r[1], r[2], r[3], r[4])));
	}

	@DeleteMapping("/books")
	public void truncateBooks() {
		booksRepo.deleteAll();
	}

}
