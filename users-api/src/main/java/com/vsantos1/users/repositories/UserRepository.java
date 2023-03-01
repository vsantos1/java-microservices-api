package com.vsantos1.users.repositories;

import com.vsantos1.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

}
