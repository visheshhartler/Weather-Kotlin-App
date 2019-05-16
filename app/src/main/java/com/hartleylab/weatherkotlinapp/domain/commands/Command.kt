package com.hartleylab.weatherkotlinapp.domain.commands

interface Command<out T> {
    fun execute(): T
}