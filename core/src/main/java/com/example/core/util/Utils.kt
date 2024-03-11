package com.example.core.util

import com.example.core.base.BaseResponse
import com.example.core.base.Info

fun <T, R> BaseResponse<T>.toDomainModel(convertData: (T?) -> R?): BaseResponse<R> = BaseResponse(
    results = results?.let { convertData(it) },
    info = Info(
        count = info?.count,
        pages = info?.pages,
        next = info?.next,
        prev = info?.prev
    )
)