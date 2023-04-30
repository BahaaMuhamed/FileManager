package stc.assigment.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stc.assigment.model.PermissionGroup;

@Repository
public interface PermissionGroupRepository extends CrudRepository<PermissionGroup,Long>{
	
	public PermissionGroup findByGroupName(String groupName);

}
