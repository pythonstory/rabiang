package net.rabiang.repositories.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import net.rabiang.repositories.custom.CategoryRepositoryCustom;

@Repository
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

}
