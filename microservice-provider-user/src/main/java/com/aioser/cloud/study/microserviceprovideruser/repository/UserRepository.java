package com.aioser.cloud.study.microserviceprovideruser.repository;

import com.aioser.cloud.study.microserviceprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
