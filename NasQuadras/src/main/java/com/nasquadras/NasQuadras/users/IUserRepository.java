package com.nasquadras.NasQuadras.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByUsername(String username);
}
