package cn.com.taiji;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.domain.Classes;
import cn.com.taiji.service.ClassesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Jpa3Test {
//	private static EntityManagerFactory factory = null;
//	private static EntityManager entityManager = null;
//	private static EntityTransaction transaction = null;
//
//	@Before
//	@Ignore
//	public void create() {
//		// 1. 创建EntityManagerFactory
//		factory = Persistence.createEntityManagerFactory("jpa-3");
//
//		// 2. 创建EntityManager
//		entityManager = factory.createEntityManager();
//
//		// 3.开启事务
//		transaction = entityManager.getTransaction();
//		transaction.begin();
//	}
//
//	@After
//	@Ignore
//	public void close() {
//		// 5. 提交事务
//		transaction.commit();
//
//		// 6. 关闭EntityManager
//		entityManager.close();
//
//		// 7. 关闭EntityManagerFactory
//		factory.close();
//	}
//
//	@Test
//	@Ignore
//	public void testClasses() {
//
//		Classes c1 = new Classes();
//		c1.setName("cc02");
//		c1.setNum(50);
//		entityManager.persist(c1);
//
//	}
//
//	// @PersistenceContext
//	// EntityManager em;
//
//	@Test
//	@Ignore
//	public void test() {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Classes> c = cb.createQuery(Classes.class);
//		Root<Classes> classes = c.from(Classes.class);
//		// 条件查询
//		CriteriaQuery query2 = c.select(classes).where(cb.equal(classes.get("name"), "cc01"));
//		TypedQuery query4 = entityManager.createQuery(query2);
//		System.out.println(query4.getSingleResult().toString());
//
//		// 查询所有
//		CriteriaQuery query1 = c.select(classes);
//		TypedQuery query3 = entityManager.createQuery(query1);
//		System.out.println(query3.getResultList().toString());
//	}
//
//	@PersistenceContext
//	EntityManager em;
	
	@Autowired
	ClassesService cs;

	@Test
	public void test1() {
		Classes findByName = cs.findByName("cc01");
		System.out.println(findByName.toString());
	}
}
