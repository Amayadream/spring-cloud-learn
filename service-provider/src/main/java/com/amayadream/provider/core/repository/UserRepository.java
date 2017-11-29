package com.amayadream.provider.core.repository;

import com.amayadream.provider.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : xjding
 * @date :   2017-11-29 19:49
 */
public interface UserRepository extends JpaRepository<User, Long> {



}
