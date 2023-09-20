package uzb.tuyliyev.springwebfluxsecurity.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
//RO'YXATDAN O'TISH SO'ROVI
public class AuthRequestDto {

    private String username;
    private String password;
}
