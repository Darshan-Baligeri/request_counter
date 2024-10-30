package com.easycom.requestcounter.repository;

import com.easycom.requestcounter.model.RequestCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestCountRepository extends JpaRepository<RequestCount, Long> {}
