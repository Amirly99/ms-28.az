package az.ingress.service;

import az.ingress.dto.SaveUsersDto;
import az.ingress.dto.UsersDto;
import az.ingress.mapper.UsersMapper;
import az.ingress.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static az.ingress.mapper.OrdersMapper.buildProfileEntity;
import static az.ingress.mapper.UsersMapper.buildUsersEntity;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public void saveUsers(SaveUsersDto request) {
        var users = buildUsersEntity(request);
        var profile = buildProfileEntity(users, request.getBio());
        users.setProfile(profile);
        usersRepository.save(users);

    }

    public List<UsersDto> getUsers() {
        var users = usersRepository.findAll();
        return users.stream()
                .map(UsersMapper::mapEntityToDto)
                .collect(Collectors.toList());

    }
}
