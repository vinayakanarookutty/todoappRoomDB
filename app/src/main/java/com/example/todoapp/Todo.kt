package com.example.todoapp
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date

data class Todo(
    var id:Int,
    var title:String,
    var createdAt:Date
)


@RequiresApi(Build.VERSION_CODES.O)
fun fakeTodo():List<Todo>{
    return listOf<Todo>(
        Todo(1,"First Todo",Date.from(Instant.now())),
        Todo(1,"Second Todo",Date.from(Instant.now())),
        Todo(1,"First Todo",Date.from(Instant.now())),
        Todo(1,"First Todo",Date.from(Instant.now())),
    )
}