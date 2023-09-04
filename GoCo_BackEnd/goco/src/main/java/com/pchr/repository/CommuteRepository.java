package com.pchr.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.NamedStoredProcedureQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pchr.dto.CommuteDTO;
import com.pchr.entity.Commute;
import com.pchr.entity.Employee;

@Repository
public interface CommuteRepository extends JpaRepository<Commute, Long> {

	@Query(value = "select * " + "from commute c " + "left join employee e " + "on e.emp_num = c.emp_num "
			+ "where clock_in >= :clock_in " + "and clock_out <= :clock_out " + "and e.unit_id = " + "(select unit_id "
			+ "from employee " + "where emp_id = :emp_id) ",

			nativeQuery = true)
	public List<Commute> findAllCommute(@Param("emp_id") String emp_id, @Param("clock_in") LocalDateTime clock_in,
			@Param("clock_out") LocalDateTime clock_out);
	
	@Query(value = "select count(commute_status) " + "from commute c " + "left join employee e " + "on e.emp_num = c.emp_num "
			+ "where clock_in >= :clock_in " + "and clock_out <= :clock_out " + "and e.unit_id = " + "(select unit_id "
			+ "from employee " + "where emp_id = :emp_id) group by commute_status ",

			nativeQuery = true)
	public List<Integer> findAllCommuteCount(@Param("emp_id") String emp_id, @Param("clock_in") LocalDateTime clock_in,
			@Param("clock_out") LocalDateTime clock_out);

	public List<Commute> findAllByEmployeeEmpNum(Long empnum);

	@Query(value = "CALL commute_procedure(:PARAM_emp_id )", nativeQuery = true)
	public Map<String,Object> findAllCommuteTime(@Param("PARAM_emp_id") String paramEmpId);

	@Query(value = "CALL commute_vacation_business(:PARAM_emp_id)", nativeQuery = true)
	public List<Map<String, Object>> findAllCommuteAndVacationAndBusiness(@Param("PARAM_emp_id") String empId);
	
	
	@Query(value = "select * " + "from commute c " + "left join employee e " + "on e.emp_num = c.emp_num "
			+ "where clock_in >= :clock_in " + "and clock_out <= :clock_out ",nativeQuery = true)
	public List<Commute> findAllCommuteAdmin(@Param("clock_in") LocalDateTime clock_in,
			@Param("clock_out") LocalDateTime clock_out);
	
	
	@Query(value = "CALL myteam_detail(:PARAM_emp_id)", nativeQuery = true)
	public List<Map<String, Object>> findAllMyTeamWorkTime(@Param("PARAM_emp_id") String empId);
	
	@Query(value = "select * "
			+ "from commute "
			+ "where emp_num = (select emp_num from employee where emp_id = :currentMemberId) "
			+ "and clock_in >= date_format(now(), '%Y-%m-%d 00:00:00') "
			+ "and clock_out <= date_format(now(), '%Y-%m-%d 23:59:00') ", nativeQuery = true)
	public List<Commute> findMenuCommuteStatus(@Param("currentMemberId") String currentMemberId);

	
	@Modifying
	@Query(value = "delete from commute where emp_num = :empNum", nativeQuery = true)
	public void deleteByEmpNum(@Param("empNum") Long empNum);
	
}
