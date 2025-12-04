package com.fnndev.passmanager.domain.repository

import com.fnndev.passmanager.domain.model.Password
import kotlinx.coroutines.flow.Flow

interface PasswordRepository {
    fun getPasswords(): Flow<List<Password>>
    fun getPasswordById(id: Int): Flow<Password?>
    fun getPasswordBySearchText(searchText: String): Flow<List<Password>>
    suspend fun insertPassword(password: Password)
    suspend fun updatePassword(password: Password)
    suspend fun deletePassword(password: Password)
}
