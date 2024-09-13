package com.backend.api.Controller;

import com.backend.api.Entity.Course;
import com.backend.api.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {


    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * Create a new course.
     *
     * @param course the course to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new course
     */
    @PostMapping("/course")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        Course newCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    /**
     * Get all courses.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of courses
     */
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    /**
     * Get a course by ID.
     *
     * @param id the ID of the course to get
     * @return the ResponseEntity with status 200 (OK) and with body of the course, or with status 404 (Not Found) if the course does not exist
     */
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a course by ID.
     *
     * @param id      the ID of the course to update
     * @param course the updated course
     * @return the ResponseEntity with status 200 (OK) and with body of the updated course, or with status 404 (Not Found) if the course does not exist
     */
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        return ResponseEntity.ok(updatedCourse);
    }

    /**
     * Delete a course by ID.
     *
     * @param id the ID of the course to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Course deleted successfully"
     */
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}