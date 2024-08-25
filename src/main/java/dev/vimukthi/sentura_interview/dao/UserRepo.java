package dev.vimukthi.sentura_interview.dao;

import dev.vimukthi.sentura_interview.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {
}
