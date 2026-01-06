package com.yeditepe.finalexam.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeditepe.finalexam.model.Task
import com.yeditepe.finalexam.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repository: TaskRepository
) : ViewModel() {

    // TODO 1: Create a mutable state list of Task objects
    // Initially add at least 2 tasks
    private val _taskList = mutableStateListOf(
        Task(1, "Task 1", false),
        Task(2, "Task 2", false)
    )
    val taskList: List<Task> = _taskList

    init {
        viewModelScope.launch {
            val tasks = repository.fetchTasks()
            _taskList.addAll(tasks)
        }
    }

    fun toggleTask(taskId: Int) {
        // TODO 2: Update isCompleted for the given task
        val res = taskList.get(taskId)
        if(!res.isCompleted) {
            res.isCompleted == true
        }
    }
}
