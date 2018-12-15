package cn.com.taiji;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.taiji.entity.Article;
import cn.com.taiji.entity.Author;
import cn.com.taiji.entity.Authority;
import cn.com.taiji.entity.User;

public class EntityTest {

	// @PersistenceContext
	// EntityManager em;
	private static EntityManagerFactory factory = null;
	private static EntityManager entityManager = null;
	private static EntityTransaction transaction = null;

	@Before
	public void create() {
		// 1. 创建EntityManagerFactory
		factory = Persistence.createEntityManagerFactory("jpa-2");

		// 2. 创建EntityManager
		entityManager = factory.createEntityManager();

		// 3.开启事务
		transaction = entityManager.getTransaction();
		transaction.begin();
	}

	@After
	public void close() {
		// 5. 提交事务
		transaction.commit();

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}

	@Test
	public void AddressAndPeople() {
		// // 1. 创建EntityManagerFactory
		// EntityManagerFactory factory =
		// Persistence.createEntityManagerFactory("jpa-2");
		//
		// // 2. 创建EntityManager
		// EntityManager entityManager = factory.createEntityManager();
		//
		// // 3.开启事务
		// EntityTransaction transaction = entityManager.getTransaction();
		// transaction.begin();

		// 4. 持久化操作
		//
		// Address address=new Address();
		// address.setAddress("北京市朝阳区");
		// People people=new People();
		// people.setName("zhangsan");
		// people.setAddress(address);
		// people.setSex("男");

		// 添加user到数据库，相当于hibernate的save();
		// entityManager.persist(people);

		// // 5. 提交事务
		// transaction.commit();
		//
		// // 6. 关闭EntityManager
		// entityManager.close();
		//
		// // 7. 关闭EntityManagerFactory
		// factory.close();
	}
	@Test
	public  void UserAndAuthority() {
		
		Authority authority1=new Authority();
		authority1.setName("a-3");
		Authority authority2=new Authority();
		authority2.setName("a-4");
		entityManager.persist(authority1);
		entityManager.persist(authority2);

		
		
		
		Authority a=entityManager.find(Authority.class, 1);
		Authority b=entityManager.find(Authority.class, 2);
		List<Authority> authorityList=new ArrayList<>();
		authorityList.add(b);
		authorityList.add(a);
		
		User user=new User();
		user.setPassword("u-2");
		user.setUsername("u-2");
		user.setAuthorityList(authorityList);
		entityManager.persist(user);
//		transaction.commit();
	}
	
	@Test
	public void deleteAuthority() {
		Authority a=entityManager.find(Authority.class, 3);
		entityManager.remove(a);
	}
	
	@Test
	public void update() {
		
	}
	
	@Test
	public void queryObject() {
//		User singleResult = entityManager.createQuery(
//    			"SELECT o FROM User o WHERE o.id = :oid AND o.username=:ousername", User.class)
//    			.setParameter("oid", 3)
//    			.setParameter("ousername", "u-2")
//    			.getSingleResult();
		
//		通过类查询
//		User singleResult = entityManager.createQuery(
//    			"SELECT o FROM User o WHERE o.id = ?1 AND o.username=?2", User.class)
//    			.setParameter(1, 3)
//    			.setParameter(2, "u-2")
//    			.getSingleResult();
		int i=entityManager.createQuery("delete from  Article where id= ?1").setParameter(1, 3).executeUpdate();
		
//		int i= entityManager.createQuery("update User set username= ?2 where id=?1").setParameter(1, 3).setParameter(2, "u-3").executeUpdate();
		System.out.println(i);
	}
	
	@Test
	public void deleteUser() {
		User u=entityManager.find(User.class, 2);
		entityManager.remove(u);
	}
	
	@Test
	public void query() {
		Query query=entityManager.createNativeQuery("select * from user where id = ? ",User.class).setParameter(1, 3);
//		User u=(User) query.getSingleResult();
		Object result=query.getSingleResult();
		System.out.println(result);
		
//		Query query=entityManager.createQuery("select name from authority where id = ?",Authority.class).setParameter(1, 1);
//		Object singleResult = query.getSingleResult();
//		System.out.println(singleResult);
	}
	
	@Test
	public void oneToMany() {
		Author author=new Author();
		author.setName("aa-2");
		
		Article article1=new Article();
		article1.setName("ar-3");
		article1.setAuthor(author);
		
		Article article2=new Article();
		article2.setName("ar-4");
		article2.setAuthor(author);

		author.getArticleList().add(article1);
		author.getArticleList().add(article2);
		
		entityManager.persist(author);
		entityManager.persist(article1);
		entityManager.persist(article2);
	}
}
