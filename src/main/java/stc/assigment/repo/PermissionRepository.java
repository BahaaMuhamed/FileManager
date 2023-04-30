package stc.assigment.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stc.assigment.model.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission,Long>{
	
	public Permission findByUserEmail(String userEmail);

}
