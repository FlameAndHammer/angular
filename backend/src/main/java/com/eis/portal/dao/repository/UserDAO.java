package com.eis.portal.dao.repository;

import com.eis.portal.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Александр on 17.10.2015.
 */
public interface UserDAO extends JpaRepository<User, Integer> {
}
