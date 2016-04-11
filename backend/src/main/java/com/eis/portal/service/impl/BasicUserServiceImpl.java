package com.eis.portal.service.impl;

import com.eis.portal.dao.repository.*;
import com.eis.portal.model.entity.Authority;
import com.eis.portal.model.entity.User;
import com.eis.portal.service.BasicUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Александр on 17.10.2015.
 */
@Service
public class BasicUserServiceImpl implements BasicUserService{

    @Resource
    private UserDAO userDao;

    @Resource
    private AuthorityDao authorityDao;

    @Override
    public void createUser(String name, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDao.save(new User(name,encoder.encode(password),true));
        authorityDao.save(new Authority(name,"ROLE_USER"));
    }

    @Override
    public int checkPassword(String password) {
        if (password.length() > 14)
            return 2;
        else if (password.length() > 6)
            return 1;
        else
            return 0;
    }
}
