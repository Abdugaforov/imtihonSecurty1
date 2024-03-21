package com.example.spring_security_core.loaders;

import com.example.spring_security_core.entity.Role;
import com.example.spring_security_core.repo.Role_repo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class Loader implements CommandLineRunner {
    private final Role_repo role_repo;

    @Override
    public void run(String... args) throws Exception {
        List<Role> all = role_repo.findAll();
        if(all.isEmpty()){
            List<Role> roles=List.of(
                    Role.builder()
                            .name("ROLE_ADMIN")
                            .build(),
                    Role.builder()
                            .name("ROLE_USER")
                            .build()
            );
            role_repo.saveAll(roles);
        }
    }
}
