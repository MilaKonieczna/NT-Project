package com.example.nt_l2.infrastucture.repository;

import com.example.nt_l2.infrastucture.entity.BookDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetailEntity, Long> {
}
