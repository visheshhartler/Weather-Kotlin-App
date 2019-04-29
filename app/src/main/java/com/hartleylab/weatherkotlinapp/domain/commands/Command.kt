package com.hartleylab.weatherkotlinapp.domain.commands

public interface Command<out T> {
    fun execute(): T
}