package com.fnndev.passmanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userAccounts")
data class Password(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val account: String,
    val userName: String,
    val password: String,
    val website: String? = null,
    val notes: String? = null
)
