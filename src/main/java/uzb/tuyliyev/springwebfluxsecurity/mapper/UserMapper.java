package uzb.tuyliyev.springwebfluxsecurity.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import uzb.tuyliyev.springwebfluxsecurity.dto.UserDto;
import uzb.tuyliyev.springwebfluxsecurity.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto map(User user);

    @InheritInverseConfiguration
    User map(UserDto dto);
}
