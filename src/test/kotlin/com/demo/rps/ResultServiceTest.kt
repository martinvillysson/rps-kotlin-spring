package com.demo.rps

import com.demo.rps.model.Action
import com.demo.rps.services.ResultService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ResultServiceTest(@Autowired val resultService: ResultService) {

    @Test
    fun `Assert that rock beats scissors`() {
        var result = this.resultService.getResult(Action.ROCK, Action.SCISSORS);
        assertThat(result.winningAction).isEqualTo(Action.ROCK)
    }

    @Test
    fun `Assert that scissors beats paper`() {
        var result = this.resultService.getResult(Action.PAPER, Action.SCISSORS);
        assertThat(result.winningAction).isEqualTo(Action.SCISSORS)
    }

    @Test
    fun `Assert that paper beats rock`() {
        var result = this.resultService.getResult(Action.PAPER, Action.ROCK);
        assertThat(result.winningAction).isEqualTo(Action.PAPER)
    }

}
