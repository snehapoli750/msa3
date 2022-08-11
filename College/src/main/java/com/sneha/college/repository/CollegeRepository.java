package com.sneha.college.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sneha.college.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

	College findById(long id);

//	@Query(value="SELECT c.* FROM college c WHERE c.clg_id=:id ", nativeQuery = true)
//	List<College> stdByClg(@Param("id") long id);
}


