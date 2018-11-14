package com.keranjangkita.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class BaseRepository<T> {

    public static final String ACTIVE = "active";
    public static final String SEQUENCE = "sequenceNumber";

    @PersistenceContext
    protected EntityManager em;

    public <T> List<T> getAll(Class<T> clazz) throws Exception {
        CriteriaBuilder criteriaBuilderObj = em.getCriteriaBuilder();
        // Making The Query Object From The 'CriteriaBuilder' Instance
        CriteriaQuery<Object> queryObj = criteriaBuilderObj.createQuery();
        Root<T> from = queryObj.from(clazz);

        // Step #1 - Displaying All Records
        System.out.println("\n! Display All Records For The 'Employee' Table !\n");
        CriteriaQuery<Object> selectQuery = queryObj.select(from);
        TypedQuery<Object> typedQuery = em.createQuery(selectQuery);
        List<T> list = (List<T>) typedQuery.getResultList();
        return list;
    }

    public <T> List<T> getSearchBy(Class<T> clazz, List<String> searchBy, List<Object> keywords,
                                   String orderBy, String orderType) {
        try {
            StringBuffer query = new StringBuffer("SELECT ");
            query.append("x FROM " + clazz.getName() + " x ");
            query.append("WHERE 1=1 ");
            for (int i = 0; i < searchBy.size(); i++) {
                if (!searchBy.get(i).equals("") && !keywords.get(i).equals("")) {
                    if (searchBy.get(i).equals(ACTIVE)) {
                        query.append(" AND x." + searchBy.get(i) + " = ?" + i);
                    } else {
                        query.append(" AND LOWER(x." + searchBy.get(i) + ") like ?" + i);
                    }
                }
            }
            if (!orderBy.equals("")) {
                query.append(" ORDER BY x." + orderBy + " ");
            } else {
                query.append(" ORDER BY x." + SEQUENCE + " ");
            }

            if (!orderType.equals("")) {
                query.append(orderType);
            } else {
                query.append(" ASC");
            }

            Query que = em.createQuery(query.toString());

            for (int i = 0; i < searchBy.size(); i++) {
                if (!searchBy.get(i).equals("") && !keywords.get(i).equals("")) {
                    if (searchBy.get(i).equals(ACTIVE)) {
                        que.setParameter(i, Integer.parseInt((String) keywords.get(i)));
                    } else {
                        que.setParameter(i, "%" + ((String) keywords.get(i)).toLowerCase() + "%");
                    }
                }
            }

            return que.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveOrUpdate(T t) throws Exception{
        this.em.merge(t);
    }

}
