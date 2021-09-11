package org.sopt.flickclone.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.flickclone.databinding.ItemTodoFeedBinding
import org.sopt.flickclone.model.TodoData

class ToDoAdapter : RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {

    private val todoList = mutableListOf<TodoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder =
        TodoViewHolder(
            ItemTodoFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int = todoList.size

    fun setItem(item: List<TodoData>) {
        todoList.clear()
        todoList.addAll(item.toMutableList())
        notifyDataSetChanged()
    }

    class TodoViewHolder(private val binding: ItemTodoFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todoItem: TodoData) {
            binding.data = todoItem
        }
    }

}