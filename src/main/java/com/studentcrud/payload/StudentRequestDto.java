package com.studentcrud.payload;

import lombok.Data;

@Data
public class StudentRequestDto {
    private String name;
    private String city;
    private String mobile;
}
