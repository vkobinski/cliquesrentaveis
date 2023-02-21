package com.kobinski.CliquesRentaveis.repository;

import com.kobinski.CliquesRentaveis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
