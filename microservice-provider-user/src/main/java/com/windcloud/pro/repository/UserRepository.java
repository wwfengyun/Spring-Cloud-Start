package com.windcloud.pro.repository;

import com.windcloud.pro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
