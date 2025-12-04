package com.fnndev.passmanager.domain.usecase

import com.fnndev.passmanager.domain.model.Password
import com.fnndev.passmanager.domain.repository.PasswordRepository
import javax.inject.Inject

class UpdatePasswordUseCase @Inject constructor(
    private val repository: PasswordRepository
) {
    suspend operator fun invoke(password: Password) {
        repository.updatePassword(password)
    }
}
