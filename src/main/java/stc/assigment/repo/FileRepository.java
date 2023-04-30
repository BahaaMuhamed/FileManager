package stc.assigment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stc.assigment.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long>{

}
