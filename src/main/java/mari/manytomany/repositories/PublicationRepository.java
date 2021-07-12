package mari.manytomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mari.manytomany.models.Publication;

@Repository
public interface PublicationRepository extends CrudRepository <Publication, Long>{
	List<Publication> findAll();
}
