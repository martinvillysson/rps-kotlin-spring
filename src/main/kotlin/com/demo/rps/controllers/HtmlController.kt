package com.demo.rps.controllers

import com.demo.rps.model.Action
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {
    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = "Play Rock-Paper-Scissors!"
        model["actions"] = Action.entries.toTypedArray();
        return "home"
    }
}