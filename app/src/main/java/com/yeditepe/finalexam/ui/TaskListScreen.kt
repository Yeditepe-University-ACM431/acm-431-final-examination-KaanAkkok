package com.yeditepe.finalexam.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yeditepe.finalexam.model.Task
import com.yeditepe.finalexam.viewmodel.TaskViewModel
import kotlin.coroutines.coroutineContext

@Composable
fun TaskListScreen(viewModel: TaskViewModel = viewModel()) {

    // TODO 3: Read task list from ViewModel
    val taskList = viewModel.taskList
    val navController = rememberNavController()

    Column {
        // TODO 4: Display task titles and completion status
        // Use a simple Column or LazyColumn
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) { taskList.forEach { task ->
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    TaskRow(task, navController)
                    Text(
                        text = "Completion status: ${task.isCompleted}"
                    )
                }
            }
        }
        }
    }
}

@Composable
fun TaskRow(task: Task, navController: NavController) {

    Text(
        text = task.title,
        modifier = Modifier.clickable {
            // TODO 3: Navigate to detail screen with task title
            navController.navigate("taskDetail/${task.title}")
        }
    )

}
