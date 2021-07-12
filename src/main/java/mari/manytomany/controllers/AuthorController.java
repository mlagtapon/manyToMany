package mari.manytomany.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mari.manytomany.models.Author;
import mari.manytomany.models.Book;
import mari.manytomany.models.Publication;
import mari.manytomany.models.Publisher;
import mari.manytomany.services.AuthorService;
import mari.manytomany.services.BookService;
import mari.manytomany.services.PublisherService;

@Controller
public class AuthorController {
	private final AuthorService authorService;
	private final BookService bookService;
	private final PublisherService pService;
	
	public AuthorController(AuthorService authorService, BookService bookService, PublisherService pService) {
		this.authorService = authorService;
		this.bookService = bookService;
		this.pService = pService;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("author") Author author, @ModelAttribute("book") Book book, @ModelAttribute("publisher") Publisher publisher, @ModelAttribute("publication") Publication publication, Model model) {
		model.addAttribute("authorsall", authorService.allAuthors());
		model.addAttribute("books", bookService.allBooks());
		model.addAttribute("publishers", pService.allPublishers());
		model.addAttribute("publications", pService.allPublishers());
		return "authors.jsp";
	}
	
	@PostMapping("/authors")
	public String createA(@Valid @ModelAttribute("author") Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "authors.jsp";
        } else {
            authorService.createAuthor(author);
            return "redirect:/";
        }
	} 
}