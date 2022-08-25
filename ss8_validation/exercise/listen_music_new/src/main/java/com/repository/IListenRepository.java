package com.repository;

import com.model.Listen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IListenRepository extends JpaRepository<Listen,Integer> {
}
