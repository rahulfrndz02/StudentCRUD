package com.studentcrud.responseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponseDto {
    private long id;
    private String name;
    private String city;
    private String mobile;
}
