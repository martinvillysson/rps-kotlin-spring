package com.demo.rps.services

import com.demo.rps.model.Action
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ResultServiceTest(@Autowired val resultService: ResultService) {

    @Test
    fun `Assert that rock beats scissors`() {
        val result = this.resultService.getResult(Action.ROCK, Action.SCISSORS)
        Assertions.assertThat(result.winningAction).isEqualTo(Action.ROCK)
    }

    @Test
    fun `Assert that scissors beats paper`() {
        val result = this.resultService.getResult(Action.PAPER, Action.SCISSORS)
        Assertions.assertThat(result.winningAction).isEqualTo(Action.SCISSORS)
    }

    @Test
    fun `Assert that paper beats rock`() {
        val result = this.resultService.getResult(Action.PAPER, Action.ROCK)
        Assertions.assertThat(result.winningAction).isEqualTo(Action.PAPER)
    }

    @Test
    fun `Assert that same actions results in draw`() {
        val result = this.resultService.getResult(Action.PAPER, Action.PAPER)
        Assertions.assertThat(result.winner).isEqualTo("No one")
    }

}