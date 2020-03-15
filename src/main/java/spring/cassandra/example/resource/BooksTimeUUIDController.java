package spring.cassandra.example.resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvException;

import spring.cassandra.example.entity.BooksTimeUUID;
import spring.cassandra.example.entity.BooksTimeUUIDKey;
import spring.cassandra.example.repository.BooksTimeUUIDRepository;
import spring.cassandra.example.util.BooksUtil;

@RestController
public class BooksTimeUUIDController {

	@Autowired
	private BooksTimeUUIDRepository booksTimeUUIDRepo;

	@PostMapping("/timeUUID/books")
	public void addBooks() throws IOException, URISyntaxException, CsvException {
		List<String[]> records = BooksUtil.readCSVRecords();
		records.stream().forEach(
				r -> booksTimeUUIDRepo.save(new BooksTimeUUID(new BooksTimeUUIDKey(r[0]), r[1], r[2], r[3], r[4])));
	}

	// Title,Author,Genre,Height,Publisher

	@PutMapping("/timeUUID/books/")
	public void updateBooks(@RequestParam String title, @RequestParam String author, @RequestParam String genre,
			@RequestParam String height, @RequestParam String publisher) {
		booksTimeUUIDRepo.save(new BooksTimeUUID(new BooksTimeUUIDKey(title), author, genre, height, publisher));
	}

}
