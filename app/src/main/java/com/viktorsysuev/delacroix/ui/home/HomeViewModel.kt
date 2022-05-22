package com.viktorsysuev.delacroix.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.viktorsysuev.delacroix.data.api.UpsplashService
import com.viktorsysuev.delacroix.data.model.Photo
import com.viktorsysuev.delacroix.data.repository.PhotosRepository
import com.viktorsysuev.delacroix.data.repository.PhotosRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(private val repository: PhotosRepository) : ViewModel() {

    private val _photos = MutableStateFlow<UIState>(Loading)
    val photos: StateFlow<UIState> = _photos.asStateFlow()

    fun fetchPopularPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val photo = repository.getPopularPhotos()
                _photos.emit(Success(photo))
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    companion object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val repository = PhotosRepositoryImpl(UpsplashService.create())
            return HomeViewModel(repository) as T
        }
    }
}

sealed class UIState
class Success(val data: List<Photo>) : UIState()
object Loading : UIState()
object Error : UIState()