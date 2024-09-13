package com.backend.api.Controller;

import com.backend.api.Entity.Student;
import com.backend.api.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Create a new student.
     *
     * @param student the student to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new student
     */
    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student newStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    /**
     * Get all students.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of students
     */
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Get a student by ID.
     *
     * @param id the ID of the student to get
     * @return the ResponseEntity with status 200 (OK) and with body of the student, or with status 404 (Not Found) if the student does not exist
     */
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a student by ID.
     *
     * @param id      the ID of the student to update
     * @param student the updated student
     * @return the ResponseEntity with status 200 (OK) and with body of the updated student, or with status 404 (Not Found) if the student does not exist
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * Delete a student by ID.
     *
     * @param id the ID of the student to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Student deleted successfully"
     */
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}