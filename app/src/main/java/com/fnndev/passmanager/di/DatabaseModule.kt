package com.fnndev.passmanager.di

import android.content.Context
import androidx.room.Room
import com.fnndev.passmanager.data.local.dao.PasswordDao
import com.fnndev.passmanager.data.local.database.PasswordDatabase
import com.fnndev.passmanager.data.repository.PasswordRepositoryImpl
import com.fnndev.passmanager.domain.repository.PasswordRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPasswordRepository(impl: PasswordRepositoryImpl): PasswordRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PasswordDatabase = Room.databaseBuilder(
        context,
        PasswordDatabase::class.java,
        "password_database"
    ).build()

    @Provides
    @Singleton
    fun providePasswordDao(database: PasswordDatabase): PasswordDao = database.passwordDao()
}