package com.demoProject.Scinema.repository;

import com.demoProject.Scinema.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepositry extends JpaRepository<InvalidatedToken, String> {
}
