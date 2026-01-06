package com.yeditepe.finalexam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yeditepe.finalexam.api.TaskApi
import com.yeditepe.finalexam.model.TaskDto
import com.yeditepe.finalexam.repository.TaskRepository
import com.yeditepe.finalexam.ui.TaskDetailScreen
import com.yeditepe.finalexam.ui.TaskListScreen
import com.yeditepe.finalexam.viewmodel.TaskViewModel

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "tasks"
    ) {

        // TODO 1: Add composable for "tasks"
        composable("tasks") {
            val repo = TaskRepository(TaskApi)
            val viewModel = TaskViewModel(repo)
            TaskListScreen(viewModel)
        }

        // TODO 2: Add composable for "taskDetail/{title}"
        composable("taskDetail/{title}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: return@composable
            TaskDetailScreen(title)
        }
    }
}
