package com.demo.rps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RpsApplication

fun main(args: Array<String>) {
	runApplication<RpsApplication>(*args)
}
