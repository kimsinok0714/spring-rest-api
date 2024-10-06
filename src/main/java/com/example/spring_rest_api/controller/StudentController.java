package com.example.spring_rest_api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.spring_rest_api.entity.Student;
import com.example.spring_rest_api.service.StudentService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    /*
     * 전체 학생 목록 조회
     * GET /api/v1/students
     * 200 OK
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        //return ResponseEntity.ok(studentService.getStudentAll());
        return new ResponseEntity<>(studentService.getStudentAll(), HttpStatus.OK);
    }

    /*
     * 학생 정보 등록
     * POST /api/v1/students
     * 201 CREATE
     */
    @PostMapping("/students")
    public ResponseEntity<Student> createStuent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }


    /*
     * 학생 상세 조회
     * GET /api/v1/students/{id}
     * 200 OK
     */
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long id) {
        Student student = studentService.getStudentByStudntId(id);
        if (student == null) {
            throw new RuntimeException("해당 학생이 존재하지 않습니다.");
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
       

    /*
     * 학생 정보 수정
     * PUT /api/v1/students/{id}
     * 204 No Content
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long id, @RequestBody Student student) {
        student.setStudentId(id);
        Student updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.NO_CONTENT);
    }

    /*
     * 학생 정보 삭제
     * DELETE /api/v1/students/{id}
     * 204 No Content
     */
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> postMethodName(@PathVariable(value = "id") Long id) {
        studentService.deleteStudent(id);   
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
    

}

