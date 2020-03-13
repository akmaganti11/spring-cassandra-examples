package spring.cassandra.example.resource;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.cassandra.example.entity.Book;
import spring.cassandra.example.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/book")
	public List<Book> books() {
		return bookRepository.findAll();
	}

	@PostMapping("/book")
	public void addBook(@RequestParam String bookName, @RequestParam String publisher, @RequestParam Set<String> tags) {
		bookRepository.save(new Book(bookName, publisher, tags));
	}

	@GetMapping("/book/id")
	public Book getBook(@RequestParam UUID id) {
		Optional<Book> book = bookRepository.findById(id);
		return book.get();
	}
}
