package com.demo.rps.controllers

import com.demo.rps.model.Action
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlayControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert that player actions are required`() {
        val response = restTemplate.getForEntity<String>("/api/play")
        Assertions.assertThat(response.statusCode).isNotEqualTo(HttpStatus.OK)
    }

    @Test
    fun `Assert api returns string with expected winner player two and winning action`() {
        val response =
            restTemplate.getForEntity<String>(
                "/api/play?playerOneAction={playerOneAction}&playerTwoAction={playerTwoAction}",
                mapOf("playerOneAction" to "ROCK", "playerTwoAction" to "PAPER")
            )
        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(response.body)
            .isEqualTo("Player Two won with action ${Action.PAPER} against ${Action.ROCK}")
    }

    @Test
    fun `Assert api returns an error if actions are misspelled`() {
        val response =
            restTemplate.getForEntity<String>(
                "/api/play?playerOneAction={playerOneAction}&playerTwoAction={playerTwoAction}",
                mapOf("playerOneAction" to "ROCKS", "playerTwoAction" to "PAPER")
            )
        Assertions.assertThat(response.statusCode).isNotEqualTo(HttpStatus.OK)
    }

}