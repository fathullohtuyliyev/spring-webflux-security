package uzb.tuyliyev.springwebfluxsecurity.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;
import uzb.tuyliyev.springwebfluxsecurity.entity.User;

public interface UserRepository extends R2dbcRepository<User, Long> {
    Mono<User> findByUsername(String username);
}
