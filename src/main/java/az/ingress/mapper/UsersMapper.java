package az.ingress.mapper;

import az.ingress.dto.SaveUsersDto;
import az.ingress.dto.UsersDto;
import az.ingress.entity.UsersEntity;

public class UsersMapper {

    public static UsersDto mapEntityToDto(UsersEntity entity){
      return  new UsersDto(entity.getId(), entity.getName());

    }

    public static UsersEntity buildUsersEntity(SaveUsersDto saveUsersDto){
        return  UsersEntity.builder()
                .name(saveUsersDto.getName())
                .build();

    }
}
