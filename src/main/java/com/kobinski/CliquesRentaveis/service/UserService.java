package com.kobinski.CliquesRentaveis.service;

import com.kobinski.CliquesRentaveis.models.User;
import com.kobinski.CliquesRentaveis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() { return userRepository.findAll();}

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Boolean getUserByCpf(String cpf, String senha) {
        User user = userRepository.findUserByCpf(cpf);

        if(!user.getSenha().equals(senha)) {
            return false;
        }

        if(!user.getCpf().equals(cpf)) {
            return false;
        }

        return true;

    }

    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setCpf(updatedUser.getCpf());
            user.setSenha(updatedUser.getSenha());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}