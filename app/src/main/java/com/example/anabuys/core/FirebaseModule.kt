package com.example.anabuys.core

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        // El manejo de errores de autenticación debe hacerse en los repositorios o ViewModels
        return FirebaseAuth.getInstance()
    }
}