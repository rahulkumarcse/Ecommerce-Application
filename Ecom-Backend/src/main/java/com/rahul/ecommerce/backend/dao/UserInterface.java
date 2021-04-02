package com.rahul.ecommerce.backend.dao;

import com.rahul.ecommerce.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterface extends JpaRepository<Users,Integer> {
}
