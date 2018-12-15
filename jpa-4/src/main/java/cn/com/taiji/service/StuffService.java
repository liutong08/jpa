package cn.com.taiji.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.com.taiji.domain.Stuff;
import cn.com.taiji.domain.StuffRepository;

@Service
public class StuffService {
	@Inject
	private StuffRepository stuffRepository;

	public Stuff add(Stuff stuff) {
		return stuffRepository.save(stuff);
	}

	public List<Stuff> query() {
		return stuffRepository.findAll();
	}

	public Stuff findbyid(int id) {
		return stuffRepository.findById(id);
	}

	public Stuff findByDept(String dept) {
		return stuffRepository.findByDept(dept);
	}

	public String name(String dept) {
		return stuffRepository.name(dept);
	}

	public void delete(Integer id) {
		stuffRepository.deleteById(id);
	}

	public Stuff update(Stuff stuff) {
		return stuffRepository.saveAndFlush(stuff);
	}

	public List<Stuff> findAll() {
		return stuffRepository.findAll();
	}

	public Map showPage() {
		Map map = new HashMap<>();
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		PageRequest pageable = new PageRequest(0, 3, sort);
		Page<Stuff> pageList;

		Specification<Stuff> spec = new Specification<Stuff>() {
			@Override
			public Predicate toPredicate(Root<Stuff> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				List<Predicate> list = new ArrayList<Predicate>();
				// 通过状态查询
				list.add(criteriaBuilder.equal(root.<Integer>get("status"), 1));

				// 通过id限定范围
				// list.add(criteriaBuilder.between(root.<Integer>get("id"), 4,7));

				// 模糊查询
				list.add(criteriaBuilder.like(root.<String>get("dept"), "%" + "部"));

				return criteriaBuilder.and(list.toArray(new Predicate[0]));
			}
		};

		pageList = stuffRepository.findAll(spec, pageable);
		map.put("total", pageList.getTotalElements());
		List<Stuff> list = pageList.getContent();
		map.put("stuffs", list);
		return map;
	}
}
