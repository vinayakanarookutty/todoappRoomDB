package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private val _todoList = MutableLiveData<List<Todo>>() // Initialize _todoList
    val todoList: LiveData<List<Todo>> = _todoList // Assign _todoList to todoList

    fun getAllTodo(){
_todoList.value=TodoManager.getAllTodo().reversed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String){
TodoManager.addTodo(title)
        getAllTodo()
    }
    fun deleteTodo(id:Int){
TodoManager.deleteTodo(id)
        getAllTodo()
    }
}
