package com.example.data.mapper

import com.example.data.datasource.remote.dtos.res.CharacterDto
import com.example.data.datasource.remote.dtos.res.LocationDto
import com.example.data.datasource.remote.dtos.res.OriginDto
import com.example.domain.models.Character
import com.example.domain.models.Location
import com.example.domain.models.Origin

fun CharacterDto.toDomain(): Character =
    Character(
        id = id,
        name = name,
        created = created,
        episode = episode,
        gender = gender,
        image = image,
        location = location?.toDomain(),
        origin = origin?.toDomain(),
        species = species,
        status = status,
        type = type,
        url = url,
    )

fun LocationDto.toDomain(): Location =
    Location(
        name = name,
        url = url
    )

fun OriginDto.toDomain(): Origin =
    Origin(
        name = name,
        url = url
    )

