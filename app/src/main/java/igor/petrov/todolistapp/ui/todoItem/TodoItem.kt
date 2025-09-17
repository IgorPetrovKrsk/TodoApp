package igor.petrov.todolistapp.ui.todoItem

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import igor.petrov.todolistapp.Todo

@Composable
fun TodoItemRoot(modifier: Modifier = Modifier) {
    var todo by rememberSaveable { mutableStateOf<Todo>(Todo("Test", "This is a test todo", false)) }
    TodoItem(todo, onCheckedChanged = { it -> todo = todo.copy(isChecked = it) },{}, modifier = modifier)
}

@Composable
fun TodoItem(todo: Todo, onCheckedChanged: ((Boolean) -> Unit),onDeleteButtonClick: ((Todo) -> Unit), modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween


        ) {
            Column {
                Text(text = todo.title,
                    textDecoration = if (todo.isChecked) TextDecoration.LineThrough else TextDecoration.None, fontWeight = FontWeight.Bold

                )
                Text(text = todo.description,
                    textDecoration = if (todo.isChecked) TextDecoration.LineThrough else TextDecoration.None)

            }
            Row {
                Checkbox(modifier = Modifier
                    .align(Alignment.Top),
                    checked = todo.isChecked,
                    onCheckedChange = { isChecked -> onCheckedChanged(isChecked) })
                IconButton(onClick = {onDeleteButtonClick(todo)}) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                }

            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun TodoItemPreview() {
    TodoItem(Todo("Preview", "Description Preview", false), {},{})
}