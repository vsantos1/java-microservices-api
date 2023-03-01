package com.vsantos1.users.annotations;

import com.vsantos1.users.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueCpfValidator implements ConstraintValidator<UniqueCpf, String> {

    private final UserRepository userRepository;

    public UniqueCpfValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return !this.userRepository.existsByCpf(cpf);
    }
}
