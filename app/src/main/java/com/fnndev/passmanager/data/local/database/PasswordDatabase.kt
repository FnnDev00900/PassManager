package com.fnndev.passmanager.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fnndev.passmanager.data.local.dao.PasswordDao
import com.fnndev.passmanager.data.model.Password

@Database(entities = [Password::class], version = 1, exportSchema = false)
abstract class PasswordDatabase : RoomDatabase() {
    abstract fun passwordDao(): PasswordDao
}