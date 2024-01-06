package com.studentcrud.service.impl;

import com.studentcrud.converter.StudentConverter;
import com.studentcrud.entity.Student;
import com.studentcrud.payload.StudentRequestDto;
import com.studentcrud.responseDto.StudentResponseDto;
import com.studentcrud.respository.StudentRepository;
import com.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        Student student = StudentConverter.toEntity(studentRequestDto);
        Student savedStudent = studentRepository.save(student);
        return StudentConverter.toDto(savedStudent);
    }

    @Override
    public StudentResponseDto getById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            Student student1 = student.get();
            return StudentConverter.toDto(student1);
        }else{
            throw new RuntimeException("Student not found with id : " + id);
        }
    }

    @Override
    public List<StudentResponseDto> getAll() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentResponseDto> responseDtoList = new ArrayList<>();
        for(Student s : studentList){
            StudentResponseDto studentResponseDto = StudentConverter.toDto(s);
            responseDtoList.add(studentResponseDto);
        }
        return responseDtoList;
    }

    @Override
    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}
