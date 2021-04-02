package com.rahul.ecommerce.backend.dao;

import com.rahul.ecommerce.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    EntityManager em;
    public List<Users> getallUsersDetails(){
        Query query= em.createNamedQuery("get all user details");
        return  query.getResultList();
    }

    @Transactional
    public void addUser(Users user){
        em.persist(user);
    }
}
