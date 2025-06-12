package com.demo.rps.services

import com.demo.rps.model.Action
import com.demo.rps.model.Result
import org.springframework.stereotype.Service

@Service
class ResultService {

    fun getResult(playerOneAction: Action, playerTwoAction: Action): Result {
        if (playerOneAction == playerTwoAction) {
            return Result("No one", playerOneAction, playerTwoAction);
        } else if (playerOneAction == Action.ROCK && playerTwoAction == Action.SCISSORS ||
            playerOneAction == Action.SCISSORS && playerTwoAction == Action.PAPER ||
            playerOneAction == Action.PAPER && playerTwoAction == Action.ROCK
        ) {
            return Result("Player One", playerOneAction, playerTwoAction);
        } else {
            return Result("Player Two", playerTwoAction, playerOneAction);
        }
    }
}