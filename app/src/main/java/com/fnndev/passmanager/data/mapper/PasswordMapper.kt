package com.fnndev.passmanager.data.mapper

import com.fnndev.passmanager.data.model.Password as DataPassword
import com.fnndev.passmanager.domain.model.Password as DomainPassword

fun DataPassword.toDomain(): DomainPassword {
    return DomainPassword(
        id = id,
        title = title,
        account = account,
        userName = userName,
        password = password,
        website = website,
        notes = notes
    )
}

fun DomainPassword.toData(): DataPassword {
    return DataPassword(
        id = id,
        title = title,
        account = account,
        userName = userName,
        password = password,
        website = website,
        notes = notes
    )
}
