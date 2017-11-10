package com.cloud.CloudDemo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.cloud.CloudDemo.model.User;

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

    @Query("from User t where sex = :sex")
    List<User> findMaleList(@Param("sex") String sex, Pageable pageable);
    

}