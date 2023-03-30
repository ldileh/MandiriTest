package com.mandiri.test.domain.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.mandiri.test.domain.local.database.AuthUser

@Dao
interface AuthUserDao {

    @Insert
    fun insertUser(authUser: AuthUser)
}