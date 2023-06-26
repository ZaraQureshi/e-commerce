package com.xoriant.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xoriant.springboot.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
