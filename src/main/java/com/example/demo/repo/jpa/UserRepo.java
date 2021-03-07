package com.example.demo.repo.jpa;

import com.example.demo.entity.Tmp;
import com.example.demo.entity.UserMst;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserMst, Integer> {

}
