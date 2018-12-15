package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.entity.Customer;

@SpringBootApplication
public class Jdbc01Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Jdbc01Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Jdbc01Application.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Customer> findAllCustomer() {
		return this.jdbcTemplate.query("select first_name, last_name from customers", new CustomerMapper());
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setFirstName(rs.getString("first_name"));
			customer.setLastName(rs.getString("last_name"));
			return customer;
		}
	}

	@Autowired
	DataSource data;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {

//		查询
		String sql = "select count(*) from customers where first_name = :first_name";
		SqlParameterSource namedParameters = new MapSqlParameterSource("first_name", "John");
		System.out.println(this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class));
//		
//		存储过程
//		int i=this.jdbcTemplate.update("call SUPPORT.REFRESH_ACTORS_SUMMARY(?)",Long.valueOf(1));
//		log.info("i="+i);
//		
//		创建新表
//		this.jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");

		// 通过id删除一条数据
//		int num = this.jdbcTemplate.update("delete from customers where id = ?", Long.valueOf(2));
//		log.info("delete " + num);

		// 通过id修改信息
//		int num = this.jdbcTemplate.update("update customers set last_name = ? where id = ?", "Banjo", 3);
//		log.info("update " + num);
//		
//		插入信息
//		int num = this.jdbcTemplate.update("insert into customers (first_name, last_name) values (?, ?)", "Leonor",
//				"Watling");
//		log.info("update "+num);

		// 查找所有信息
//		List<Customer> list=this.findAllCustomer();
//		log.info(list.toString());

		// 通过查询返回一个对象
//		Customer customer = this.jdbcTemplate.queryForObject("select id,first_name, last_name from customers where id = ? and first_name=?",
//				new Object[] {2,"Jeff" }, new RowMapper<Customer>() {
//					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Customer customer = new Customer();
//						customer.setId(rs.getLong("id"));
//						customer.setFirstName(rs.getString("first_name"));
//						customer.setLastName(rs.getString("last_name"));
//						return customer;
//					}
//				});
//		log.info(customer.toString());

		// 通过查询返回至少一个对象
//		List<Customer> customer = this.jdbcTemplate.query("select first_name, last_name from customers",
//				new RowMapper<Customer>() {
//					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Customer customer = new Customer();
//						customer.setFirstName(rs.getString("first_name"));
//						customer.setLastName(rs.getString("last_name"));
//						return customer;
//					}
//				});
//		log.info(customer.toString());

//		查询数据个数
//		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from customers", Integer.class);
//		log.info("the count of customers is " + rowCount);
//		
//		查询指定条件的个数
//		int countOfActorsNamedJoe = this.jdbcTemplate
//				.queryForObject("select count(*) from customers where first_name = ?", Integer.class, "Josh");
//		log.info("the count of Actors Named Joe is " + countOfActorsNamedJoe);
//
//		
//		String lastName = this.jdbcTemplate.queryForObject("select last_name from customers where id = ?", String.class,1);
//		log.info("the lastName is " + lastName);

//		String lastName1 = this.jdbcTemplate.queryForObject(
//				"select last_name from customers where id=? and first_name=?", String.class,
//				new Object[] { 1, "John" });// 使用数组可以传递多值，对应的sql语句需要有相同个数的占位符？
//		log.info("the lastName is " + lastName1);
//
//		List<String> lastName2 = this.jdbcTemplate.queryForList("select last_name from customers where first_name=?",
//				String.class, new Object[] { "Josh" });
//		log.info("the lastName is " + lastName2);

//		创建数据表并插入数据
//
//		log.info("Creating tables");
//
//		jdbcTemplate.execute("DROP TABLE IF EXISTS customers ");
//		jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
//
//		// Split up the array of whole names into an array of first/last names
//		List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//				.map(name -> name.split(" ")).collect(Collectors.toList());
//
//		// Use a Java 8 stream to print out each tuple of the list
//		splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//		// Uses JdbcTemplate's batchUpdate operation to bulk load data
//		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
//
//		log.info("Querying for customer records where first_name = 'Josh':");
//		jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
//				new Object[] { "Josh" },
//				(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
//				.forEach(customer -> log.info(customer.toString()));
	}
}
