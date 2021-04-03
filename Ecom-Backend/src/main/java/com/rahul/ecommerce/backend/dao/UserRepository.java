package com.rahul.ecommerce.backend.dao;

import com.rahul.ecommerce.backend.dto.UserLoginDto;
import com.rahul.ecommerce.backend.dto.UserProfileDto;
import com.rahul.ecommerce.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public UserProfileDto addUser(Users user){
        em.persist(user);
        UserProfileDto userProfileDto = new UserProfileDto(user.getId(), user.getName(), user.getEmail());

        return userProfileDto;
    }

    public UserProfileDto loginUser(UserLoginDto user){
        String username=user.getEmail();
        String passwordu=user.getPassword();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
        Root<Users> from = criteria.from(Users.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("email"),username));
        Users userList = null;
        TypedQuery<Users> typed = em.createQuery(criteria);
        try {
             userList=typed.getSingleResult();

        } catch (final NoResultException nre) {
            return null;
        }
        if(userList.getPassword().equals(passwordu)){
            UserProfileDto userProfileDto= new UserProfileDto();
            userProfileDto.setId(userList.getId());
            userProfileDto.setName(userList.getName());
            userProfileDto.setEmail(userList.getEmail());
            return userProfileDto;
        }
        else
            return null;

    }




}
