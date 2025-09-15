package igor.petrov.simplecomposecheckbox

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Todo(
    val title: String,
    val description: String,
    val isChecked: Boolean
) : Parcelable