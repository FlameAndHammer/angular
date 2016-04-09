package com.nikulin.testtask.server.dao.repository;

import com.nikulin.testtask.server.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Александр on 17.10.2015.
 */
public interface UserDAO extends JpaRepository<User, Integer> {
}
