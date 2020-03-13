package spring.cassandra.example.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import spring.cassandra.example.entity.Books;

@Repository
public interface BooksRepository extends CassandraRepository<Books, UUID>{

}
