package com.intelygenz.domain.repository;

import com.intelygenz.domain.entity.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Long> {
}
