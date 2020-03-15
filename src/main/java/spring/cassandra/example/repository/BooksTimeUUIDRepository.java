package spring.cassandra.example.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import spring.cassandra.example.entity.BooksTimeUUID;
import spring.cassandra.example.entity.BooksTimeUUIDKey;

public interface BooksTimeUUIDRepository extends CassandraRepository<BooksTimeUUID, BooksTimeUUIDKey>{

}
