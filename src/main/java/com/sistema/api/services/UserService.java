package com.sistema.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.api.entities.User;
import com.sistema.api.repositories.UserRepository;
import com.sistema.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {    	
        try {
			return userRepository.findById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("User not found with id: " + id);
		}
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
    	try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }        
    }

    public User update(User newUser, Long id) {
    	try {
	        return userRepository.findById(id)
	                .map(user -> {
	                    user.setNome(newUser.getNome());
	                    user.setEmail(newUser.getEmail());
	                    user.setPassword(newUser.getPassword());
	                    user.setTelefone(newUser.getTelefone());
	                    return userRepository.save(user);
	                })
	                .orElseGet(() -> {
	                    newUser.setId(id);
	                    return userRepository.save(newUser);
	                });
    	} catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }	        
    } 
}
