/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lecaddyfute.model.dao;

import java.util.List;

/**
 *
 * @author Nono
 * @param <T>
 */
public interface HibernateDao<T> {
    
   public T getById( final Object id,Class<T> type );
   
   public List< T > getAll(String query);
   
    public List<Object[]>  getAllSQL(String query);
    
   public List<T>  search(Class<T> type,String[] fieldnamesearch,String searchword);
   
   public T create( final T entity );
   
   public T update( final T entity );
   
   public T refresh( final T entity );
   
   public void deleteById( final Object entityId,Class<T> type );
   
    
}
