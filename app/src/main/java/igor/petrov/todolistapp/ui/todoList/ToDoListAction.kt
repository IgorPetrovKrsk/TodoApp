package igor.petrov.simplecomposecheckbox.ui.todoList

sealed interface ToDoListAction {
    data object OnAddTodoClick : ToDoListAction
    data class OnTitleTextChange(val titleText: String) : ToDoListAction
    data class OnDescriptionTextChange(val descriptionText: String) : ToDoListAction
}
