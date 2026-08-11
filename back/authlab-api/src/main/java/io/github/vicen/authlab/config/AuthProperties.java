package io.github.vicen.authlab.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.util.List;

@Validated
@ConfigurationProperties(prefix = "auth")
public record AuthProperties (
        @NotNull @Valid Jwt jwt,
        @NotNull @Valid Refresh refresh,
        @NotNull @Valid Cors cors,
        @NotNull BootstrapAdmin bootstrapAdmin
){

    public record Jwt(
            @NotBlank String issuer,
            @NotBlank String audience,
            @NotNull Duration acessTokenTtl,
            @NotNull Resource privateKey,
            @NotNull Resource publicKey

    ){
    }

    public record Refresh(
            @NotNull Duration tokenTtl,
            @NotNull @Valid Cookie cookie

    ){
    }

    public record Cookie(
            @NotBlank String name,
            @NotBlank String path,
            boolean secure,
            @NotBlank String sameSite
    ){
    }

    public record Cors(
            @NotEmpty List<@NotBlank String> allowedOrigins
    ){
    }

    public record BootstrapAdmin(
          String name,
          String email,
          String password
    ){
    }
}
