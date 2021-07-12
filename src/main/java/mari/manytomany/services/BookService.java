package mari.manytomany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mari.manytomany.models.Book;
import mari.manytomany.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

}
