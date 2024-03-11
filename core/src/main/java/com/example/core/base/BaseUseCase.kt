package com.example.core.base

interface BaseUseCase<IN, OUT> {
    operator fun invoke(input: IN): OUT
}