package mari.manytomany.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mari.manytomany.models.Publication;
import mari.manytomany.services.PublicationService;

@Controller
public class PublicationController {
	private final PublicationService pubService;
	
	public PublicationController(PublicationService pubService) {
		this.pubService = pubService;
	}
	
	@PostMapping("/publications")
	public String createPublication(@Valid @ModelAttribute("publication") Publication publication, BindingResult result) {
		if(result.hasErrors()) {
			return "authors.jsp";
		} else {
			pubService.createPublication(publication);
		return "redirect:/";
		}
	}
}
