package cn.com.taiji.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;

import cn.com.taiji.entity.Address;
import cn.com.taiji.entity.People;

class test {
	@PersistenceContext
	EntityManager em;

	@Test
	void test() {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-5");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		
		Address address=new Address();
		address.setAddress("北京市朝阳区");
		People people=new People();
		people.setName("zhangsan");
		people.setAddress(address);
		people.setSex("男");

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(people);
		entityManager.persist(address);

		// 5. 提交事务
		transaction.commit();

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}

}
