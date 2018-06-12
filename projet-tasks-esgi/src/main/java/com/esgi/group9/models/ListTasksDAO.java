package com.esgi.group9.models;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.stereotype.Repository;

import com.esgi.group9.business.Task;
import com.esgi.group9.business.Task_;


/**
 * The Class ListTasksDAO.
 */
@Repository
public class ListTasksDAO implements IListTasksDAO {
	
	/** The entity manager. */
	@PersistenceContext
    private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IListTasksDAO#searchTasks(boolean, javax.persistence.metamodel.SingularAttribute)
	 */
	public <T> List<Task> searchTasks(boolean ascending, SingularAttribute<Task, T> attribute) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Task> lCriteriaQuery = lCriteriaBuilder.createQuery(Task.class);
        final Root<Task> lRoot = lCriteriaQuery.from(Task.class);
        if(ascending) {
        	lCriteriaQuery.orderBy(lCriteriaBuilder.asc(lRoot.get(attribute)));
        }
        else {
        	lCriteriaQuery.orderBy(lCriteriaBuilder.desc(lRoot.get(attribute)));
        }
        
        List<Task> tasks = entityManager.createQuery(lCriteriaQuery).getResultList();
        
        return tasks;
	}

	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IListTasksDAO#createTask(com.esgi.group9.business.Task)
	 */
	public void createTask(Task pTask) {
		entityManager.persist(pTask);
	}
	
	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IListTasksDAO#deleteTask(com.esgi.group9.business.Task)
	 */
	public void deleteTask(final Task pTask) {
		final Task lTask = entityManager.getReference(Task.class, pTask.getId());
        entityManager.remove(lTask);
	}
	
	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IListTasksDAO#modifyTask(com.esgi.group9.business.Task)
	 */
	public void modifyTask(final Task pTask) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Task> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Task.class);
        final Root<Task> lRoot = lCriteriaUpdate.from(Task.class);
        final Path<Task> lPath = lRoot.get("id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pTask.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("description", pTask.getDescription());
        lCriteriaUpdate.set("priority", pTask.getPriority());
        final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
        final int lRowCount = lQuery.executeUpdate();

        if (lRowCount != 1) {
            final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
            final String lSql = lHQuery.getQueryString();
            throw new RuntimeException("Nombre d'occurences (" + lRowCount + 
                    ") modifiés différent de 1 pour " + lSql);
        }
	}

	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IListTasksDAO#searchUrgentTasks()
	 */
	public List<Task> searchUrgentTasks() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Task> lCriteriaQuery = lCriteriaBuilder.createQuery(Task.class);
        final Root<Task> lRoot = lCriteriaQuery.from(Task.class);
        lCriteriaQuery.where(lCriteriaBuilder.equal(lRoot.get(Task_.priority), 4));
        
        List<Task> tasks = entityManager.createQuery(lCriteriaQuery).getResultList();
        
        return tasks;
	}

}
