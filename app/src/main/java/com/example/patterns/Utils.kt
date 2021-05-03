package com.example.patterns

import com.github.javafaker.Faker

private val faker = Faker()

fun getRandomName(): String =
    faker.funnyName().name()

fun getRandomAge(): Int =
    faker.number().numberBetween(18, 99)

fun getRandomNumber(): Int =
    faker.number().numberBetween(1, 100)