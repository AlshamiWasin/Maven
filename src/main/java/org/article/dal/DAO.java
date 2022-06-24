package org.article.dal;

import java.util.List;

public interface DAO <T>{

 public void insert(T data) throws DalException;
 public void delete(T data) throws DalException;
 public void update(T data) throws DalException;
 public T selectById(long id) throws DalException;
 public List<T> selectAll() throws DalException;


}
