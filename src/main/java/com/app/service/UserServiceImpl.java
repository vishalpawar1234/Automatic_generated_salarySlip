package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@org.springframework.transaction.annotation.Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

	@Override
	public User saveEmployee(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}
	
}
