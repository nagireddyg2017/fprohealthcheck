package com.dbs.fpro.healthcheck.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dbs.fpro.healthcheck.model.FprohealthcheckResponse;
@Repository
@Component
public interface FprohealthcheckRepo extends JpaRepository<FprohealthcheckResponse, Integer>{

}
