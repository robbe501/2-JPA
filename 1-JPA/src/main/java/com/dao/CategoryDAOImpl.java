package com.dao;

import java.util.List;

import com.entity.Category;
import com.provider.ProviderManager;
import com.vo.CategoryVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class CategoryDAOImpl implements CategoryDAO {
	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public void insertCategory(Category category) {
		initRoutine();

		em.persist(category);

		closingRoutine();

	}

	@Override
	public void updateCategory(Category category) {
		initRoutine();

		em.merge(category);

		closingRoutine();

	}

	@Override
	public void deleteCategory(Integer categoryId) {
		initRoutine();

		em.remove(em.find(Category.class, categoryId));

		closingRoutine();

	}

	@Override
	public List<CategoryVO> getCategories() {
		initRoutine();

		List<CategoryVO> categories = em.createNamedQuery("Category.findAll", CategoryVO.class).getResultList();

		closingRoutine();

		return categories;
	}

	private void closingRoutine() {
		try {
			ProviderManager.commitTransaction(em);
			System.out.println("Transazione Completata");
		} catch (RollbackException rbe) {
			rbe.printStackTrace();
			System.err.println("Transazione Fallita");
			ProviderManager.rollbackTransaction(em);
		}

		ProviderManager.closeTransaction(em);
		ProviderManager.closeEntityManagerFactory(emf);
	}

	private void initRoutine() {
		emf = ProviderManager.getEntityManagerFactory();
		em = ProviderManager.getEntityManager(emf);

		ProviderManager.beginTransaction(em);
	}

}
