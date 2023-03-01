package com.vsantos1.users.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueCpfValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCpf {

    String message() default "Cpf already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
