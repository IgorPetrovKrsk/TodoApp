package igor.petrov.todolistapp.ui.todoList

import androidx.lifecycle.ViewModel
import igor.petrov.todolistapp.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoListViewModel : ViewModel() {
    private val _state = MutableStateFlow<TodoListState>(TodoListState())
    val state = _state.asStateFlow()

    fun onAction(action: ToDoListAction) {
        when (action) {
            ToDoListAction.OnAddTodoClick -> _state.update {
                it.copy(
                    todoList = it.todoList + Todo(title = it.titleText, description = it.descriptionText, isChecked = false),
                    titleText = "",
                    descriptionText = ""
                )
            }
            is ToDoListAction.OnTitleTextChange -> _state.update {
                it.copy(
                    titleText = action.titleText
                )
            }

            is ToDoListAction.OnDescriptionTextChange -> _state.update {
                it.copy(
                    descriptionText = action.descriptionText
                )
            }

            is ToDoListAction.OnTodoCheckedChanged -> _state.update{
                it.copy(
                    todoList = it.todoList.map { if (it == action.todo) Todo(it.title,it.description,!it.isChecked) else it}
                )
            }
            is ToDoListAction.OnTodoDeleteButtonClick -> _state.update {
                it.copy(
                    todoList = it.todoList.filter { it!=action.todo }
                )
            }
        }
    }
}