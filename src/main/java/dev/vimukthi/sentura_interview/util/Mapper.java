package dev.vimukthi.sentura_interview.util;

import dev.vimukthi.sentura_interview.dto.UserDTO;
import dev.vimukthi.sentura_interview.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper mapper;

    //User Mapping
    public UserEntity toUserEntity(UserDTO userDTO){
        return mapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }

}
