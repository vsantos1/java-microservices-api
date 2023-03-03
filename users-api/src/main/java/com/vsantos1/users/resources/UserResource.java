package com.vsantos1.users.resources;

import com.vsantos1.users.dtos.UserDTO;
import com.vsantos1.users.models.User;
import com.vsantos1.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.execute(userDTO));
    }

    @PutMapping(value = "/users/{user_id}")
    public ResponseEntity<User> update(@RequestBody @Valid UserDTO userDTO, @PathVariable("user_id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(id, userDTO));
    }

    @DeleteMapping(value = "/users/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable("user_id") Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
