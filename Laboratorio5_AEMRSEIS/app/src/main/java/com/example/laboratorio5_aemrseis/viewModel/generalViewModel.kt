package com.example.laboratorio5_aemrseis.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio5_aemrseis.model.TaskDao
import com.example.laboratorio5_aemrseis.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GeneralViewModel(
    private val taskDao: TaskDao
) : ViewModel() {

    val tasks: Flow<List<Task>> = taskDao.getAllTasks()

    fun addTask(task: Task) {
        viewModelScope.launch {
            taskDao.insertTask(task)
        }
    }
}