package com.courseapp.service;

import java.util.List;

import com.courseapp.entity.Courses;

public interface CourseService {

	List<Courses> getAllCourses();

	Courses getCourseById(long courseId);

	Courses addCourses(Courses courses);

	Courses updateCourses(Courses courses);

	void deleteCourses(long parseLong);


}
