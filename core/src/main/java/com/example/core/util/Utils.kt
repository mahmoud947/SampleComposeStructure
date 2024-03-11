package com.example.core.util

import com.example.core.base.BaseResponse

fun <T, R> BaseResponse<T>.toDomainModel(convertData: (T?) -> R?): BaseResponse<R> = BaseResponse(
    data = data?.let { convertData(it) },
    isSuccess = isSuccess,
    message = message,
    statusCode = statusCode
)