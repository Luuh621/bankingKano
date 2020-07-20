package br.com.lucaskano.KanoBanking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KanoBankingApplication

fun main(args: Array<String>) {
	runApplication<KanoBankingApplication>(*args)
}
