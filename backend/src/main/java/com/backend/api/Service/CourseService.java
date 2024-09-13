package com.backend.api.Service;

import com.backend.api.Entity.Course;
import com.backend.api.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {


    /**
     * Service class for managing Course entities.
     */


    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository CourseRepository) {
        this.courseRepository = CourseRepository;
    }

    /**
     * Save a Course.
     *
     * @param Course the entity to save
     * @return the persisted entity
     */
    public Course saveCourse(Course Course) {
        return courseRepository.save(Course);
    }

    /**
     * Get all the Courses.
     *
     * @return the list of entities
     */
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /**
     * Get one Course by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    /**
     * Update a Course.
     *
     * @param id             the ID of the entity
     * @param updatedCourse the updated entity
     * @return the updated entity
     */
    public Course updateCourse(Long id, Course updatedCourse) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course Course = existingCourse.get();
            Course.setCourseCode(updatedCourse.getCourseCode());
            Course.setCourseName(updatedCourse.getCourseName());
            Course.setDescription(updatedCourse.getDescription());
            return courseRepository.save(Course);
        } else {
            throw new RuntimeException("Course not found");
        }
    }

    /**
     * Delete the Course by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
