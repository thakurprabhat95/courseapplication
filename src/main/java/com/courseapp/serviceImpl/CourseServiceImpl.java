package com.courseapp.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.Repository.CourseRepository;
import com.courseapp.entity.Courses;
import com.courseapp.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	
	List<Courses> listOfCourses;
	
	@Autowired
	private CourseRepository courseRepository;
	
	CourseServiceImpl(){
//		listOfCourses=new ArrayList<>();
//		listOfCourses.add(new Courses(121, "Java Core", "Java core is very important"));
//		listOfCourses.add(new Courses(122, "Java Spring", "Spring is a java framework"));
//		
	}
	@Override
	public List<Courses> getAllCourses() {
		return courseRepository.findAll();
	
	}
	
	
	@Override
	public Courses getCourseById(long courseId) {
//		Courses c=null;
//		for(Courses courses:listOfCourses) {
//			if(courses.getCourseId()==courseId) {
//				c=courses;
//				break;
//			}
//		}
//		return c;
		return courseRepository.getOne(courseId);
	}
	
	
	@Override
	public Courses addCourses(Courses courses) {
//		listOfCourses.add(courses);
		return courseRepository.save(courses);
	}
	@Override
	public Courses updateCourses(Courses courses) {
		
//		listOfCourses.forEach(e->{
//			if(e.getCourseId() == courses.getCourseId())
//			{
//				e.setDescription(courses.getDescription());
//				e.setTitle(courses.getTitle());
//			}
//		});
//		return courses;
		return courseRepository.save(courses);
	
	}
	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourses(long parseLong) {
		
	//	listOfCourses=this.listOfCourses.stream().filter(e->e.getCourseId()!=parseLong).collect(Collectors.toList());
		
		Courses entity = courseRepository.getOne(parseLong);
		courseRepository.delete(entity);
		
		
	}

}
