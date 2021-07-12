package mari.manytomany.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mari.manytomany.models.Publisher;
import mari.manytomany.services.PublisherService;

@Controller
public class PublisherController {
	private final PublisherService pService;
	
	public PublisherController(PublisherService pService) {
		this.pService=pService;
	}
	
	@PostMapping("/publisher")
	
	public String createPub(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "authors.jsp";
        } else {
        	//Author author = authorService.findAuthor(book.author);
           pService.createP(publisher);
            return "redirect:/";
        }
		
	}
}
