package com.backend.api.Service;

import com.backend.api.Entity.Student;
import com.backend.api.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements CommandLineRunner {

    /**
     * Service class for managing Student entities.
     */

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Save a Student.
     *
     * @param student the entity to save
     * @return the persisted entity
     */
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Get all the Students.
     *
     * @return the list of entities
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Get one Student by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Update a Student.
     *
     * @param id             the ID of the entity
     * @param updatedStudent the updated entity
     * @return the updated entity
     */
    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    /**
     * Delete the Student by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    /**
     * Add random students when the application starts.
     */
    @Override
    public void run(String... args) throws Exception {
        // Adding some random initial data
        if (studentRepository.count() == 0) {
            studentRepository.save(new Student(1L, "John", "Doe", new Date(2000, 1, 15), "Male", "john.doe@example.com", "1234567890", "123 Main St", "New York", "NY", "10001", new Date(), "Active", "https://example.com/photo/johndoe"));
                            studentRepository.save(new Student(2L, "Jane", "Smith", new Date(1999, 5, 20), "Female", "jane.smith@example.com", "2345678901", "456 Maple St", "Los Angeles", "CA", "90001", new Date(), "Active", "https://example.com/photo/janesmith"));
                            studentRepository.save(new Student(3L, "Michael", "Johnson", new Date(2001, 10, 10), "Male", "michael.johnson@example.com", "3456789012", "789 Oak St", "Chicago", "IL", "60007", new Date(), "Active", "https://example.com/photo/michaeljohnson"));
                            studentRepository.save(new Student(4L, "Emily", "Davis", new Date(2002, 3, 25), "Female", "emily.davis@example.com", "4567890123", "321 Pine St", "Houston", "TX", "77001", new Date(), "Active", "https://example.com/photo/emilydavis"));
                            studentRepository.save(new Student(5L, "Daniel", "Williams", new Date(2001, 7, 30), "Male", "daniel.williams@example.com", "5678901234", "654 Cedar St", "Phoenix", "AZ", "85001", new Date(), "Inactive", "https://example.com/photo/danielwilliams"));
                            studentRepository.save(new Student(6L, "Sophia", "Martinez", new Date(1998, 11, 5), "Female", "sophia.martinez@example.com", "6789012345", "987 Birch St", "Philadelphia", "PA", "19019", new Date(), "Active", "https://example.com/photo/sophiamartinez"));
                            studentRepository.save(new Student(7L, "David", "Brown", new Date(2000, 8, 18), "Male", "david.brown@example.com", "7890123456", "159 Walnut St", "San Antonio", "TX", "78201", new Date(), "Active", "https://example.com/photo/davidbrown"));
                            studentRepository.save(new Student(8L, "Olivia", "Jones", new Date(2002, 6, 12), "Female", "olivia.jones@example.com", "8901234567", "753 Spruce St", "San Diego", "CA", "92101", new Date(), "Inactive", "https://example.com/photo/oliviajones"));
                            studentRepository.save(new Student(9L, "James", "Garcia", new Date(1999, 9, 3), "Male", "james.garcia@example.com", "9012345678", "951 Poplar St", "Dallas", "TX", "75001", new Date(), "Active", "https://example.com/photo/jamesgarcia"));
                            studentRepository.save(new Student(10L, "Isabella", "Wilson", new Date(2001, 4, 22), "Female", "isabella.wilson@example.com", "0123456789", "123 Ash St", "San Francisco", "CA", "94101", new Date(), "Inactive", "https://example.com/photo/isabellawilson"));
                    
            
        }
    }
}
