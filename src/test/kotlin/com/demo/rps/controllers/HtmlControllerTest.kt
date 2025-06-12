package com.demo.rps.controllers

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HtmlControllerTest(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `Assert that home responds with correct title and status code`() {
        val response = restTemplate.getForEntity<String>("/");
        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.body).contains("<h1>Play Rock-Paper-Scissors!</h1>")
    }

}