package spring.cassandra.example.resource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.cassandra.example.entity.BooksByCompositeKey;
import spring.cassandra.example.entity.BooksCompositeKey;
import spring.cassandra.example.repository.BooksByCompositeKeyRepository;
import spring.cassandra.example.service.BooksService;

@RestController
public class BooksByCompositeKeyController {

	@Autowired
	private BooksByCompositeKeyRepository booksByCompositeKeyRepo;
	
	@Autowired
	private BooksService booksService;

	@GetMapping("/booksByCompositeKey")
	public List<BooksByCompositeKey> getBooksByCompositeKey() {
		return booksByCompositeKeyRepo.findAll();
	}
	
	@GetMapping("/booksByCompositeKey/query")
	public Collection<BooksByCompositeKey> getAllBooks() {
		return booksService.findAllBooksByCompositeKey();
	}

	@GetMapping("/booksByCompositeKey/id")
	public BooksByCompositeKey getBook(@RequestParam UUID id, @RequestParam String author, @RequestParam String genre) {
		Optional<BooksByCompositeKey> books = booksByCompositeKeyRepo
				.findById(new BooksCompositeKey(id, author, genre));
		return books.get();
	}

	@PostMapping("/booksByCompositeKey")
	public void createBookByCompositeKey() {
		booksByCompositeKeyRepo.save(new BooksByCompositeKey(new BooksCompositeKey(UUID.randomUUID(), "AK", "Fiction"),
				"Title", "123", "Pub123"));
	}

//	@PostMapping("/booksByCompositeKey")
//	public void addBooksByCompositeKey() throws IOException, URISyntaxException, CsvException {
//		List<String[]> records = BooksUtil.readCSVRecords();
//		records.stream()
//				.forEach(r -> booksByCompositeKeyRepo.save(new BooksByCompositeKey(r[0], r[1], r[2], r[3], r[4])));
//	}

}
