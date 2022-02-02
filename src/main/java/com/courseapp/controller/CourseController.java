package com.courseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.entity.Courses;
import com.courseapp.service.CourseService;

@RestController
@CrossOrigin
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/test")
	public String testController()
	{
		return "testing";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Courses> getAllCourses()
	{
		return courseService.getAllCourses();
	}
	
	//get single courses by courseId
	@GetMapping("/getcourses/{courseId}")
	public Courses getCourse(@PathVariable long courseId)
	{
		return courseService.getCourseById(courseId);
	}
	
	//add courses
	@PostMapping("/addcourses")
	public Courses addCourses(@RequestBody Courses courses)
	{
		return courseService.addCourses(courses);
	}
	
	//update courses
	@PutMapping("/updatecourses")
	public Courses updateCourse(@RequestBody Courses courses)
	{
		return courseService.updateCourses(courses);
	}
	
	@DeleteMapping("/deletecourses/{id}")
	public ResponseEntity<HttpStatus> deleteCourses(@PathVariable String id)
	{
		try {
		courseService.deleteCourses(Long.parseLong(id));
		return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
