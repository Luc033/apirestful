package edu.luc.apirestful.service;

import edu.luc.apirestful.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreated);
}
