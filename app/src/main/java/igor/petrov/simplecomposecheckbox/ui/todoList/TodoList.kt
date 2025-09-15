package igor.petrov.todolistapp.ui.theme.todoItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import igor.petrov.todolistapp.Todo

@Composable
fun TodoListRoot(modifier: Modifier = Modifier) {
    //var todo by rememberSaveable { mutableStateOf<Todo>(Todo("Test", "This is a test todo", false)) }
    //TodoItem(todo, onCheckedChanged = { it -> todo = todo.copy(isChecked = it) },modifier = modifier)
}

@Composable
fun TodoList(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()) {
        LazyColumn(modifier = modifier
            .weight(1f)) {
            item { TodoItem(Todo("Test", "Test", false), {}) }
        }
        Row(modifier = modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = modifier
                    .padding(8.dp),


                ) {
                TextField(value = "", label = { Text("Title") }, onValueChange = {})
                Spacer(modifier = modifier.height(8.dp))
                TextField(value = "", label = { Text("Description") }, onValueChange = {})
            }
            Button(modifier = modifier.height(128.dp), onClick = {}) {
                Text(text = "Add")
            }
        }

    }
}

@Preview(
    showBackground = true
)
@Composable
fun TodoListPreview() {
    TodoList()
}