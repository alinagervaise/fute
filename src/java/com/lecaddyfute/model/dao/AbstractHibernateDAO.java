/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nono
 * @param <T>
 */
@Transactional
public abstract class AbstractHibernateDAO< T> implements HibernateDao<T> {

    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public T getById(final Object id, Class<T> type) {
        return (T) this.getCurrentSession().get(type, (Serializable) id);
    }

    @Override
    public List<Object[]> getAllSQL(String query) {
        return this.getCurrentSession().createSQLQuery(query).list();
    }

    @Override
    public List< T> getAll(String query) {
        Session s = this.getCurrentSession();
        List result = s.createQuery(query).list();
        return result;
    }

    @Override
    public T create(final T entity) {
        this.getCurrentSession().persist(entity);
        return entity;
    }

    @Override
    public T update(final T entity) {
        this.getCurrentSession().merge(entity);
        return entity;
    }

    @Override
    public T refresh(final T entity) {
        this.getCurrentSession().refresh(entity);
        return entity;
    }

    public void delete(final T entity) {
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(final Object entityId, Class<T> type) {
        final T entity = this.getById(entityId, type);
        this.delete(entity);
    }

    protected final Session getCurrentSession() {
        Session s = this.sessionFactory.getCurrentSession();
        s.setFlushMode(FlushMode.COMMIT);
        return s;
    }

    @Override
    public List<T> search(Class<T> type, String[] fieldnamesearch, String searchword) {
        FullTextSession fullTextSession = Search.getFullTextSession(this.getCurrentSession());

     // create native Lucene query unsing the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(type).get();
        org.apache.lucene.search.Query query = qb
                .keyword()
                .onFields(fieldnamesearch)
                .matching(searchword)
                .createQuery();

        // wrap Lucene query in a org.hibernate.Query
        org.hibernate.Query hibQuery
                = fullTextSession.createFullTextQuery(query, type);
//  logger.info("Execution of Search  query  "+hibQuery.getQueryString());
        // execute search
        List result = hibQuery.list();
        // fullTextSession.close();
        return result;
    }
}
