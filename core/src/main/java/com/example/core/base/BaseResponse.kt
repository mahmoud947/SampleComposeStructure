package com.example.core.base

data class BaseResponse<T>(
    val `data`: T?,
    val isSuccess: Boolean?,
    val message: String?,
    val statusCode: String?
)

