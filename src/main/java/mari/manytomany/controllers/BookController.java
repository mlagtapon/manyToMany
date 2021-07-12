package mari.manytomany.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mari.manytomany.models.Book;
import mari.manytomany.services.AuthorService;
import mari.manytomany.services.BookService;
import mari.manytomany.services.PublisherService;

@Controller
public class BookController {
	
	private final AuthorService authorService;
	private final BookService bookService;
	
	public BookController(AuthorService authorService, BookService bookService) {
		this.authorService = authorService;
		this.bookService = bookService;
	}
	
	@PostMapping("/books")
	
	public String createB(@Validated @ModelAttribute("book") Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "authors.jsp";
        } else {
        	//Author author = authorService.findAuthor(book.author);
           bookService.createBook(book);
            return "redirect:/";
        }
		
	}

}