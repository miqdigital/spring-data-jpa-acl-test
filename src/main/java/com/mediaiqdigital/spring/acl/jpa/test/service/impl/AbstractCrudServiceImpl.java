package com.mediaiqdigital.spring.acl.jpa.test.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mediaiqdigital.spring.acl.jpa.test.service.AbstractCrudService;

public abstract class AbstractCrudServiceImpl<T, ID extends Serializable, R extends JpaRepository<T, ID>>
		implements AbstractCrudService<T, ID> {

	@Override
	public Page<T> get(Integer page, Integer size) {
		return getRepository().findAll(new PageRequest(page, size));
	}

	@Override
	public T save(T t) {
		return getRepository().save(t);
	}

	@Override
	public void deleteAll() {
		getRepository().deleteAll();
	}

	@Override
	public T getById(ID id) {
		return getRepository().findOne(id);
	}

	@Override
	public void deleteById(ID id) {
		getRepository().delete(id);
	}

	@Override
	public List<T> saveAll(List<T> list) {
		return getRepository().save(list);
	}

	public abstract R getRepository();
}
