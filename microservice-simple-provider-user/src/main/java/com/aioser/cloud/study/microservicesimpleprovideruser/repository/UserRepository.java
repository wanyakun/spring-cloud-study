package com.aioser.cloud.study.microservicesimpleprovideruser.repository;

import com.aioser.cloud.study.microservicesimpleprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
