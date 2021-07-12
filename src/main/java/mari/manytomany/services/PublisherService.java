package mari.manytomany.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import mari.manytomany.models.Publisher;
import mari.manytomany.repositories.PublisherRepository;



@Service
public class PublisherService {
    private final PublisherRepository pRepo;
    
    public PublisherService(PublisherRepository pRepo) {
        this.pRepo = pRepo;
    }
    // returns all the books
    public List<Publisher> allPublishers() {
        return pRepo.findAll();
    }
    
    public Publisher createP(@Valid Publisher publisher) {
    	return pRepo.save(publisher);
    }
}