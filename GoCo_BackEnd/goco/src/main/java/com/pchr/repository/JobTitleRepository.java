package com.pchr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pchr.entity.JobTitle;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Long>{

}
