package ms28.az.service;

import ms28.az.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void create(StudentDto studentDto);//Post

    void update(StudentDto studentDto, Long id);//PUT

    void delete(Long id);//Deleted

    StudentDto getById(Long id);//GET




}
