package util;

import entity.Masina;
import entity.Motor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class HibernateUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("oneToOne");

    public static EntityManager getEM(){
        return emf.createEntityManager();
    }

    public static <Entity extends Serializable> void save(Entity e){
        EntityManager em = getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(e);
        t.commit();
        em.close();
    }

    public static <Entity extends Serializable> List <Entity> readAll(Class<Entity> entityClass){
        List<Entity> entities = null;
        EntityManager manager = getEM();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();
        Root<javax.persistence.Entity> root = query.from(entityClass);
        query.select(root);
        entities = manager.createQuery(query).getResultList();
        manager.close();
        return entities;

    }

    public static void closeEMF(){
        emf.close();
    }
}
