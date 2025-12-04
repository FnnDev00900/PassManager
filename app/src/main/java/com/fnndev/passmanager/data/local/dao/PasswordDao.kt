package com.fnndev.passmanager.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.fnndev.passmanager.data.model.Password
import kotlinx.coroutines.flow.Flow

@Dao
interface PasswordDao {
    @Query("SELECT * FROM userAccounts")
    fun getPasswords(): Flow<List<Password>>

    @Query("SELECT * FROM userAccounts WHERE id = :id")
    fun getPasswordById(id: Int): Flow<Password?>

    @Query("SELECT * FROM userAccounts WHERE LOWER(title) LIKE '%' || LOWER(:searchText) || '%' OR LOWER(account) LIKE '%' || LOWER(:searchText) || '%' OR LOWER(userName) LIKE '%' || LOWER(:searchText) || '%'")
    fun getPasswordBySearchText(searchText: String): Flow<List<Password>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPassword(password: Password)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePassword(password: Password)

    @Delete
    suspend fun deletePassword(password: Password)
}
