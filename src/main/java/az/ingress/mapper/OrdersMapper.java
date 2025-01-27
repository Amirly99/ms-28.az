package az.ingress.mapper;

import az.ingress.entity.OrdersEntity;
import az.ingress.entity.ProfileEntity;
import az.ingress.entity.UsersEntity;

public class OrdersMapper {

    public static ProfileEntity buildProfileEntity(UsersEntity users , String bio){

        return ProfileEntity.builder()
                .bio(bio)
                .build();

    }
}
