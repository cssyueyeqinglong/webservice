package com.cy.export.service;

import com.cy.export.domain.Export;
import com.cy.export.pagination.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * @Description: ExportService接口
 * @Author: 传智播客 java学院	传智宋江
 * @Company: http://java.itcast.cn
 * @CreateDate: 2016-7-6 19:46:34
 */

public interface ExportService {

    public List<Export> find(String hql, Class<Export> entityClass, Object[] params);

    public Export get(Class<Export> entityClass, Serializable id);

    public Page<Export> findPage(String hql, Page<Export> page, Class<Export> entityClass, Object[] params);

    public void saveOrUpdate(Export entity);

    public void saveOrUpdateAll(Collection<Export> entitys);

    public void deleteById(Class<Export> entityClass, Serializable id);

    public void delete(Class<Export> entityClass, Serializable[] ids);
}
