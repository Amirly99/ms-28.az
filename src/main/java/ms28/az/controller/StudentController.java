package ms28.az.controller;

import lombok.RequiredArgsConstructor;
import ms28.az.dto.StudentDto;
import ms28.az.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/students")
public class StudentController {
    private final StudentService studentService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody StudentDto studentDto) {

        studentService.create(studentDto);

    }

    @GetMapping(value = "/{id}")
    public StudentDto getById(@PathVariable Long id) {

        return studentService.getById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)

    public void update(@PathVariable Long id, @RequestBody StudentDto studentDto) {

        studentService.update(studentDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

}


