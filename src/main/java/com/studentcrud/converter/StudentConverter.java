package com.studentcrud.converter;

import com.studentcrud.entity.Student;
import com.studentcrud.payload.StudentRequestDto;
import com.studentcrud.responseDto.StudentResponseDto;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    //Dto to Entity
    public static Student toEntity(StudentRequestDto studentRequestDto){
        return Student.builder()
                .name(studentRequestDto.getName())
                .city(studentRequestDto.getCity())
                .mobile((studentRequestDto.getMobile()))
                .build();
    }

    //Entity to Dto
    public static StudentResponseDto toDto(Student student){
        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .city(student.getCity())
                .mobile(student.getMobile())
                .build();
    }
}
