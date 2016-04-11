package com.eis.portal.service;

/**
 * Created by Александр on 17.10.2015.
 */
public interface BasicUserService {
    public void createUser(String name, String password);
    public int checkPassword(String password);
}
