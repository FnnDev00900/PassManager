package com.fnndev.passmanager.data.repository

import com.fnndev.passmanager.data.local.dao.PasswordDao
import com.fnndev.passmanager.data.mapper.toData
import com.fnndev.passmanager.data.mapper.toDomain
import com.fnndev.passmanager.domain.model.Password
import com.fnndev.passmanager.domain.repository.PasswordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PasswordRepositoryImpl @Inject constructor(private val passwordDao: PasswordDao) :
    PasswordRepository {
    override fun getPasswords(): Flow<List<Password>> {
        return passwordDao.getPasswords().map { passwords ->
            passwords.map { it.toDomain() }
        }
    }

    override fun getPasswordById(id: Int): Flow<Password?> {
        return passwordDao.getPasswordById(id).map { it?.toDomain() }
    }

    override fun getPasswordBySearchText(searchText: String): Flow<List<Password>> {
        return passwordDao.getPasswordBySearchText(searchText).map { passwords ->
            passwords.map { it.toDomain() }
        }
    }

    override suspend fun insertPassword(password: Password) {
        passwordDao.insertPassword(password.toData())
    }

    override suspend fun updatePassword(password: Password) {
        passwordDao.updatePassword(password.toData())
    }

    override suspend fun deletePassword(password: Password) {
        passwordDao.deletePassword(password.toData())
    }
}
