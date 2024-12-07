package ms28.az.service;

import lombok.RequiredArgsConstructor;
import ms28.az.dto.StudentDto;
import ms28.az.model.Student;
import ms28.az.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void create(StudentDto studentDto) {
        studentRepository.save(Student.builder()
                .name(studentDto.getName())
                .surname((studentDto.getSurname()))
                .address((studentDto.getAddress()))
                .age((studentDto.getAge()))
                .status(studentDto.isStatus())
                .build());
    }

    @Override
    public void update(StudentDto studentDto, Long id) {
        var student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Cannot"));
        student.setName(studentDto.getName());
        student.setSurname((studentDto.getSurname()));
        student.setAddress(studentDto.getAddress());
        student.setAge(studentDto.getAge());
        student.setStatus(studentDto.isStatus());
        studentRepository.save(student);
    }


    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public StudentDto getById(Long id) {
        var student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Cannot"));
        return new StudentDto(student.getName(), student.getSurname(), student.getAddress(), student.getAge(), student.isStatus());
    }


    }

