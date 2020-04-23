package com.example.curso.boot.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public abstract class AbstractDao<T, PK extends Serializable> {
    
    @SuppressWarnings("unchecked")
    private final Class<T> entityClass = (Class<T>) 
        ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    
    @PersistenceContext
    private EntityManager entityManager;
 
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    public void save(T entity) {     
        this.entityManager.persist(entity);
    }
    
    public void update(T entity) {            
        this.entityManager.merge(entity);
    }
    
    public void delete(PK id) {            
        this.entityManager.remove(this.entityManager.getReference(entityClass, id));
    }
    
    public T findById(PK id) {            
        return this.entityManager.find(entityClass, id);
    }
    
    public List<T> findAll() {
        return this.entityManager
        		.createQuery("from " + this.entityClass.getSimpleName(), this.entityClass)
        		.getResultList();
    }    
    
    protected List<T> createQuery(String jpql, Object... params) {            
        TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
        for(int i = 0; i < params.length; i++) {
        	query.setParameter(i+1,  params[1]);
        }
        return query.getResultList();
    }
}