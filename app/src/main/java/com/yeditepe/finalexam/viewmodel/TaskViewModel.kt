package com.yeditepe.finalexam.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.yeditepe.finalexam.model.Task

class TaskViewModel : ViewModel() {

    // TODO 1: Create a mutable state list of Task objects
    // Initially add at least 2 tasks
    val taskList = mutableStateListOf(
        Task(1, "Task 1", false),
        Task(2, "Task 2", false)
    )

    fun toggleTask(taskId: Int) {
        // TODO 2: Update isCompleted for the given task
        val res = taskList.get(taskId)
        if(!res.isCompleted) {
            res.isCompleted == true
        }
    }
}
