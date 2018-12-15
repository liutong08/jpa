package cn.com.taiji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.domain.Classes;
import cn.com.taiji.domain.ClassesRespository;

@Service
public class ClassesService {

	@Autowired
	ClassesRespository cr;

	public Classes findByName(String name) {
		return cr.findByName(name);
	}

	public Classes findById(Integer id) {
		return cr.getOne(id);
	}
}
