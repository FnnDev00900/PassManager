package com.fnndev.passmanager.domain.model

data class Password(
    val id: Int,
    val title: String,
    val account: String,
    val userName: String,
    val password: String,
    val website: String? = null,
    val notes: String? = null
)
