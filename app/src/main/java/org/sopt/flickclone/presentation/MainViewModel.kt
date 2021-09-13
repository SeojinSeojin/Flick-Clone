package org.sopt.flickclone.presentation

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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
        val newTodoContent = inputTodo.value
        inputTodo.value = ""
        CoroutineScope(Dispatchers.IO).launch {
            mainRepository.insertTodo(requireNotNull(newTodoContent))
        }
    }

    fun completeTodo(todo: TodoData): Unit {
        CoroutineScope(Dispatchers.IO).launch {
            mainRepository.completeTodo(todo)
        }
    }

    fun updateTodo(todo: TodoData, newContent: String) {
        CoroutineScope(Dispatchers.IO).launch {
            mainRepository.updateTodo(todo, newContent)
        }
    }

    fun deleteTodo(todo: TodoData) {
        CoroutineScope(Dispatchers.IO).launch {
            mainRepository.deleteTodo(todo)
        }
    }
}