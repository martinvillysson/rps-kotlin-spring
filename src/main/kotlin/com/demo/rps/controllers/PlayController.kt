package com.demo.rps.controllers

import com.demo.rps.model.Action
import com.demo.rps.services.ResultService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController()
class PlayController(private val resultService: ResultService) {

    @GetMapping("/api/play")
    fun play(@RequestParam(name = "playerOneAction", required = true) playerOneAction: Action, @RequestParam(name = "playerTwoAction", required = true) playerTwoAction: Action): String {
        val result = resultService.getResult(playerOneAction, playerTwoAction)
        return "${result.winner} won with action ${result.winningAction} against ${result.losingAction}"
    }
}