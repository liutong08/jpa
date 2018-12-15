package cn.com.taiji.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StuffRepository extends JpaRepository<Stuff, Integer>,JpaSpecificationExecutor<Stuff>, CrudRepository<Stuff, Integer> {
	
	Stuff findById(int id);
	
	Stuff findByDept(String dept);
	
	@Query("select name from Stuff where dept= ?1")
	String name(String dept);
}
