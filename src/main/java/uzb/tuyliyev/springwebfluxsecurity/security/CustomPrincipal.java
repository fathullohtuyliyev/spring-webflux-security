package uzb.tuyliyev.springwebfluxsecurity.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomPrincipal implements Principal {

    private Long id;
    private String name;
}

/**
 * tizimda foydalanuvchilar yoki tashqi xodimlar bilan ishlashda-
 * xodimning kimligini (identifikatsiyasini) ifodalaydi.
 */