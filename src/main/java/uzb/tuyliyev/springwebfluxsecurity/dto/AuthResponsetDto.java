package uzb.tuyliyev.springwebfluxsecurity.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

////RO'YXATDAN O'TISHDA QAYTADIGAN JAVOB
public class AuthResponsetDto {

    private Long id;
    private String token;
    private Date issuedAt;
    private Date expiresAt;


}
