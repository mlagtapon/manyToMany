package mari.manytomany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mari.manytomany.models.Publication;
import mari.manytomany.repositories.PublicationRepository;

@Service
public class PublicationService {
	private final PublicationRepository pubRepo;
	
	public PublicationService(PublicationRepository pubRepo) {
		this.pubRepo = pubRepo;
	}
	
	public List<Publication> allPublication(){
		return pubRepo.findAll();
	}
	public void createPublication(Publication pub) {
		pubRepo.save(pub);
	}
}
