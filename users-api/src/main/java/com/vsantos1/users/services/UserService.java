package com.vsantos1.users.services;

import com.vsantos1.users.dtos.UserDTO;
import com.vsantos1.users.models.User;
import com.vsantos1.users.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    public UserService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    public User findById(Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        // Todo: implement custom exception
        throw new RuntimeException("User not found");
    }

    public User execute(UserDTO userDTO) {
        User user = new User();

        user = mapper.map(userDTO, User.class);
        return this.userRepository.save(user);

    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User update(Long id, UserDTO userDTO) {
        User user = this.findById(id);

        mapper.map(userDTO, user);

        return this.userRepository.save(user);
    }

    public void delete(Long id) {
        User user = this.findById(id);

        this.userRepository.deleteById(user.getId());
    }
}
