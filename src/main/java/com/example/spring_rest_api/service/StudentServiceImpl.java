package com.example.spring_rest_api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.spring_rest_api.entity.Student;
import com.example.spring_rest_api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getStudentAll() {
       return studentRepository.findAll();
    }


    @Override
    public Student addStudent(Student student) {
       return studentRepository.save(student);       
    }


    @Override
    public void deleteStudent(Long studentId) {
       studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentByStudntId(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }       
    }


    @Override
    public Student updateStudent(Student student) {
        Optional<Student> optional = studentRepository.findById(student.getStudentId());
        if (optional.isPresent()) {
            // 기존 회원 정보를 수정한다.
            Student exitedStudent = optional.get();
            exitedStudent.setStudentName(student.getStudentName());
            // 수정된 회원 정보를 저장한다.
            return studentRepository.save(exitedStudent);            
        } else {
            throw new RuntimeException("회원 정보를 찾을 수 없습니다.");
        }
    }

}
