package com.esgi.group9;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class ListTasksDAO implements IListTasksDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	public List<Task> searchTasks() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Task> lCriteriaQuery = lCriteriaBuilder.createQuery(Task.class);
        final Root<Task> lRoot = lCriteriaQuery.from(Task.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Task> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}

	public void createTask(Task pTask) {
		entityManager.persist(pTask);
	}
	
	public void deleteTask(final Task pTask) {
		final Task lTask = entityManager.getReference(Task.class, pTask.getId());
        entityManager.remove(lTask);
	}

}
