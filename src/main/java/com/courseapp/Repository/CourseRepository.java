package com.courseapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courseapp.entity.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long>{

}
