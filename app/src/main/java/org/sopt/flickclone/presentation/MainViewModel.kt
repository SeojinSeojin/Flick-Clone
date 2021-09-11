package org.sopt.flickclone.presentation

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    val historyTodos: LiveData<List<TodoData>> = mainRepository.historyTodos.asLiveData()
    val feedTodos: LiveData<List<TodoData>> = mainRepository.feedTodos.asLiveData()
    val inputTodo = MutableLiveData("")
    fun createTodo() {
        viewModelScope.launch {
            Log.d("태그", "insert ${inputTodo.value}")
            mainRepository.insertTodo(requireNotNull(inputTodo.value))
        }
    }
}