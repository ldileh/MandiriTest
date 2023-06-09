package com.mandiri.test.domain.local

import android.content.Context
import android.os.Bundle
import com.mandiri.test.config.AppDatabase
import com.mandiri.test.config.SessionManager
import javax.inject.Inject

@Suppress("unused")
class LocalDataSource @Inject constructor(private val context: Context) {

    private val database by lazy { AppDatabase.getAppDatabase(context) }
    private val sessionManager by lazy { SessionManager(context) }

    fun getTokenSession() = sessionManager.getToken()

    fun setSession(data: Bundle) = sessionManager.setSession(data)

    fun clearSession(callback: () -> Unit) = sessionManager.clearSession(callback)
}