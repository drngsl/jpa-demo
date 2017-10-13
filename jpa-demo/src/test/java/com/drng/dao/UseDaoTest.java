package com.drng.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.drngsl.dao.model.User;

public class UseDaoTest {

	@Test
	public void save(){  
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistentUnit");  
        EntityManager em = factory.createEntityManager();  
        em.getTransaction().begin();  
        User user = new User();
        user.setId("idforstring");
        user.setUserName("zhang san");  
        em.persist(user);
        em.getTransaction().commit();  
        em.close();  
        factory.close();  
    } 
}
