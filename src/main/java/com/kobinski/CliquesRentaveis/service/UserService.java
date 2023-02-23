package com.kobinski.CliquesRentaveis.service;

import com.kobinski.CliquesRentaveis.models.User;
import com.kobinski.CliquesRentaveis.repository.UserRepository;
import com.kobinski.CliquesRentaveis.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private final PasswordConfig passwordConfig;

    @Autowired
    public UserService(UserRepository userRepository, PasswordConfig passwordConfig) {
        this.userRepository = userRepository;
        this.passwordConfig = passwordConfig;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() { return userRepository.findAll();}

    public User saveUser(User user) {
        user.setSenha(passwordConfig.passwordEncoder().encode(user.getSenha()));
        return userRepository.save(user);
    }

    public Boolean getUserByCpf(String cpf, String senha) {
        User user = userRepository.findUserByCpf(cpf);

        if(user == null) return false;

        if(!passwordConfig.passwordEncoder().matches(senha, user.getSenha())) {
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