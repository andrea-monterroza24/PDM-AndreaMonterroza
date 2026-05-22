package com.example.laboratorio4_aemrseis.viewModel

import androidx.lifecycle.ViewModel
import com.example.laboratorio4_aemrseis.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GeneralViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())

    val tasks = _tasks.asStateFlow()

    fun addTask(task: Task) {

        _tasks.value = _tasks.value + task
    }
}