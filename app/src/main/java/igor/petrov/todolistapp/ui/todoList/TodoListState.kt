package igor.petrov.simplecomposecheckbox.ui.todoList

import igor.petrov.todolistapp.Todo

data class TodoListState(
    val todoList : List<Todo> = listOf<Todo>(),
    val titleText : String = "",
    val descriptionText : String = ""

)
