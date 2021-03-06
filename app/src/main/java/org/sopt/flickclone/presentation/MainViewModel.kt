package org.sopt.flickclone.presentation

import androidx.lifecycle.*
import androidx.paging.PagedList
import androidx.paging.toLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.repository.MainRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepositoryImpl) :
    ViewModel() {

    val currentFragmentPage: LiveData<Int>
        get() = _currentFragmentPage
    private val _currentFragmentPage = MutableLiveData<Int>()
    fun setCurrentFragmentPage(pageIndex: Int) {
        _currentFragmentPage.postValue(pageIndex)
    }

    val historyTodos: LiveData<PagedList<TodoData>> =
        mainRepository.getHistoryTodos().toLiveData(pageSize = 20)

    val feedTodos: LiveData<PagedList<TodoData>> =
        mainRepository.getFeedTodos().toLiveData(pageSize = 20)


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