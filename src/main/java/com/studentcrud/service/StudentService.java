package com.studentcrud.service;

import com.studentcrud.entity.Student;
import com.studentcrud.payload.StudentRequestDto;
import com.studentcrud.responseDto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    StudentResponseDto createStudent(StudentRequestDto studentRequestDto);

    StudentResponseDto getById(long id);

    List<StudentResponseDto> getAll();

    void delete(long id);
}
