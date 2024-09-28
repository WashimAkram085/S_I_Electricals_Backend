package com.washim.S.I.Electricals.repository;

import com.washim.S.I.Electricals.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
