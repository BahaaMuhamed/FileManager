package stc.assigment.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stc.assigment.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long>{
	
	public Item findByName(String name);

}
