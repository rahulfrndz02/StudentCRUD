package com.studentcrud.controller;

import com.studentcrud.payload.StudentRequestDto;
import com.studentcrud.responseDto.StudentResponseDto;
import com.studentcrud.respository.StudentRepository;
import com.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto studentResponseDto = studentService.createStudent(studentRequestDto);
        return new ResponseEntity<>(studentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<StudentResponseDto> getById(@PathVariable long id){
        StudentResponseDto studentResponseDto = studentService.getById(id);
        return new ResponseEntity<>(studentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<StudentResponseDto>> getAll(){
        List<StudentResponseDto> list = studentService.getAll();
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        studentService.delete(id);
        return new ResponseEntity<>("Student deleted!", HttpStatus.CREATED);
    }
}
