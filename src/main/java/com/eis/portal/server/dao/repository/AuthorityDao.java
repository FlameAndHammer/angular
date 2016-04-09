package com.nikulin.testtask.server.dao.repository;

import com.nikulin.testtask.server.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Александр on 18.10.2015.
 */
public interface AuthorityDao extends JpaRepository<Authority, Integer> {
}
