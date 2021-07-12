package mari.manytomany.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import mari.manytomany.models.Author;
import mari.manytomany.repositories.AuthorRepository;


@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    // returns all the books
//    public List<Author> allAuthors() {
//        return authorRepository.findAll(JpaSort.by(JpaSort.Direction.ASC, "name"));
//    }
    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }
    
    public Author createAuthor(@Validated Author author) {
    	return authorRepository.save(author);
    }
}