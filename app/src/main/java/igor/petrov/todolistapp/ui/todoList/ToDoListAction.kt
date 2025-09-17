package igor.petrov.todolistapp.ui.todoList

import igor.petrov.todolistapp.Todo

sealed interface ToDoListAction {
    data object OnAddTodoClick : ToDoListAction
    data class OnTitleTextChange(val titleText: String) : ToDoListAction
    data class OnDescriptionTextChange(val descriptionText: String) : ToDoListAction
    data class OnTodoCheckedChanged (val todo: Todo) : ToDoListAction
    data class OnTodoDeleteButtonClick (val todo: Todo) : ToDoListAction
}
