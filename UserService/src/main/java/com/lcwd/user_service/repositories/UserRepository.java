package com.lcwd.user_service.repositories;
import com.lcwd.user_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.lcwd.user_service.entities.User;

public interface UserRepository extends JpaRepository<User,String>
{
    public User findByuserId(String userId);
}
