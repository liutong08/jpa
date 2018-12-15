package cn.com.taiji;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.domain.Stuff;
import cn.com.taiji.service.StuffService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Jpa4ApplicationTests {
	@Inject
	private StuffService stuffService;

	@Test
	@Ignore
	public void test() {

	}

	@Test
	@Ignore
	public void testAdd() {
		Stuff stuff = new Stuff();
		stuff.setName("wangwu");
		stuff.setDept("fff");

		Stuff stuff1 = stuffService.add(stuff);
		System.out.println(stuff1.toString());
	}

	@Test
	@Ignore
	public void testQuery() {
		List<Stuff> stuff = stuffService.query();
		System.out.println(stuff.toString());
	}

	@Test
	@Ignore
	public void testQuery1() {
		Stuff stuff = stuffService.findbyid(1);
		System.out.println(stuff.toString());
	}

	@Test
	@Ignore
	public void testQuery2() {
		Stuff stuff = stuffService.findByDept("ddd");
		System.out.println(stuff.toString());
	}

	@Test
	@Ignore
	public void testQuery3() {
		String stuff = stuffService.name("fff");
		System.out.println(stuff);
	}

	@Test
	@Ignore
	public void delete() {
		stuffService.delete(1);
	}

	@Test
//	@Ignore
	public void update() {
		Stuff stuff = stuffService.findbyid(2);
		stuff.setName("刘达");
//		stuff.setDept("lll");
		Stuff stu = stuffService.update(stuff);
		System.out.println(stu.toString());
	}

	@Test
	@Ignore
	public void findAll() {
		List<Stuff> stuffList = stuffService.findAll();
		System.out.println(stuffList);
	}

	@Test
	public void showPage() {
		Map page = stuffService.showPage();
		System.out.println(page.toString());
	}
}
