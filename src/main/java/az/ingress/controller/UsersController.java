package az.ingress.controller;

import az.ingress.dto.SaveUsersDto;
import az.ingress.dto.UsersDto;
import az.ingress.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "v1/users")
@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void  saveUsers(@RequestBody SaveUsersDto saveUsersDto){
        usersService.saveUsers(saveUsersDto);
    }
    @GetMapping(value = "/findAll")
    public List<UsersDto> getUsers(){

        return usersService.getUsers();
    }


}
