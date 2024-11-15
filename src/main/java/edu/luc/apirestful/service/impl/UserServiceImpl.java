package edu.luc.apirestful.service.impl;

import edu.luc.apirestful.model.User;
import edu.luc.apirestful.repository.UserRepository;
import edu.luc.apirestful.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreated) {
        if(userRepository.existsByAccountNumber(userToCreated.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreated);
    }
}
