package com.vdias.demo_park_api;

import com.vdias.demo_park_api.web.dto.UserCreateDto;
import com.vdias.demo_park_api.web.dto.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/sql/users/user-insert.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/sql/users/user-delete.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserIT {

    @Autowired
    WebTestClient testClient;

    @Test
    public void creatreUser_WithUsernameEPasswordValided_ReturnCreateUserWithStatus201() {
       UserResponseDto responseDto =  testClient
                .post()
                .uri("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new UserCreateDto("teaste@teste.com","123456"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(UserResponseDto.class)
                .returnResult().getResponseBody();

       org.assertj.core.api.Assertions.assertThat(responseDto).isNotNull();
        org.assertj.core.api.Assertions.assertThat(responseDto.getId()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(responseDto.getUsername()).isEqualTo("teaste@teste.com");
    }
}

