package cn.com.taiji.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRespository extends JpaRepository<Classes, Integer>, CrudRepository<Classes, Integer> {
//
//	@Query("select c from Classes where c.name = ?1")
	Classes findByName(String name);

}
