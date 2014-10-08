package com.mediaiqdigital.spring.acl.jpa.test.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * "http://springinpractice.com/2012/05/11/pagination-and-sorting-with-spring-data-jpa"
 * 
 * @author sowdri
 * 
 * @param <T>
 * @param <ID>
 */
public interface AbstractCrudService<T, ID extends Serializable> {

	Page<T> get(Integer page, Integer size);

	T save(T t);

	List<T> saveAll(List<T> list);

	void deleteAll();

	T getById(ID id);

	void deleteById(ID id);

}
