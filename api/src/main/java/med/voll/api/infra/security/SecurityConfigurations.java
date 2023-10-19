package med.voll.api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().build();

    }


    //http.csrf().disable(). Serve para desabilitarmos proteção contra-ataques do tipo CSRF (Cross-Site Request Forgery).
    //Estamos desabilitando esse tipo de ataque porque vamos trabalhar com autenticação via tokens.
    // Nesse cenário, o próprio token é uma proteção contra esses tipos de ataques e ficaria repetitivo.

    //deixa a autenticação Stateless pq é uma api rest

}
