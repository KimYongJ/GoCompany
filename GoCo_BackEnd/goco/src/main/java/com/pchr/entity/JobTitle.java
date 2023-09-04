package com.pchr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pchr.dto.JobTitleDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobTitle {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_title_id")
	private Long jobTitleId;
	
	@Column(name = "job_title_name",nullable = false)
	private String jobTitleName;

	public JobTitleDTO toDTO(JobTitle jobTitle) {
		JobTitleDTO jobTitleDTO = JobTitleDTO.builder()
								  .jobTitleId(jobTitle.getJobTitleId())
								  .jobTitleName(jobTitle.getJobTitleName())
								  .build();
		return jobTitleDTO;
	}
}
