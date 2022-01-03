package com.dazz.mytodo

import android.util.Log
import android.widget.*
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dazz.mytodo.adapters.AllTasksViewAdapter
import com.dazz.mytodo.database.Task
import com.dazz.mytodo.models.TodoViewModel
import java.sql.Date

@BindingAdapter("setDate")
fun setDate(textView: TextView,date : LiveData<Date>?){
    textView.setText(date?.value!!.toString())
}

