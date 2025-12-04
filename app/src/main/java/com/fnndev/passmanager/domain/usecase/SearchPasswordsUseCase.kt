package com.fnndev.passmanager.domain.usecase

import com.fnndev.passmanager.domain.model.Password
import com.fnndev.passmanager.domain.repository.PasswordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchPasswordsUseCase @Inject constructor(
    private val repository: PasswordRepository
) {
    operator fun invoke(searchText: String): Flow<List<Password>> {
        return repository.getPasswordBySearchText(searchText)
    }
}
