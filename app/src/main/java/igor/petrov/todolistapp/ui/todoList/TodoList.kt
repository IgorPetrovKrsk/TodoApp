package igor.petrov.todolistapp.ui.todoList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import igor.petrov.simplecomposecheckbox.ui.todoList.ToDoListAction
import igor.petrov.simplecomposecheckbox.ui.todoList.TodoListState
import igor.petrov.simplecomposecheckbox.ui.todoList.TodoListViewModel
import igor.petrov.todolistapp.Todo
import igor.petrov.todolistapp.ui.todoItem.TodoItem


@Composable
fun TodoListRoot(modifier: Modifier = Modifier) {

    val viewModel = viewModel<TodoListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    TodoList(
        state = state,
        onAction = viewModel::onAction,
        modifier = modifier)
}

@Composable
fun TodoList(state: TodoListState,
    onAction: (ToDoListAction) -> Unit,
    modifier: Modifier = Modifier) {
    Column(modifier = modifier
        //.padding(0.dp)
        .fillMaxSize()
        .imePadding()
        ,
        verticalArrangement = Arrangement.SpaceBetween) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {
            item { TodoItem(Todo("Test", "Test", false), {}) }
            items(state.todoList) { todo ->
                TodoItem(Todo(todo.title, todo.description, todo.isChecked), onCheckedChanged = {onAction(ToDoListAction.OnTodoCheckedChanged(todo))})
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .padding(0.dp),
                verticalArrangement = Arrangement.Bottom,

                ) {
                OutlinedTextField(value = state.titleText, label = { Text("Title") }, singleLine = true, onValueChange = { newTitle -> onAction(ToDoListAction.OnTitleTextChange(newTitle)) })
                //Spacer(modifier = modifier.height(1.dp))
                OutlinedTextField(value = state.descriptionText, label = { Text("Description") }, singleLine = true, onValueChange = { newDescription -> onAction(ToDoListAction.OnDescriptionTextChange(newDescription)) })
            }
            Button(modifier = Modifier
                .height(128.dp)
                .padding(4.dp), onClick = { onAction(ToDoListAction.OnAddTodoClick) }) {
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
    TodoList(TodoListState(), {})
}