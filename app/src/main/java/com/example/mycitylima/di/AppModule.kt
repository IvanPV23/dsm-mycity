package com.example.mycitylima.di

import com.example.mycitylima.data.repository.PlacesRepositoryImpl
import com.example.mycitylima.domain.repository.PlacesRepository
import com.example.mycitylima.ui.viewmodel.MyCityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Repository
    single<PlacesRepository> { PlacesRepositoryImpl() }

    // ViewModel
    viewModel { MyCityViewModel(get()) }
}