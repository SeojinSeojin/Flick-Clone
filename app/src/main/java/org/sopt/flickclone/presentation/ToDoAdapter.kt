package org.sopt.flickclone.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.internal.managers.ViewComponentManager
import org.sopt.flickclone.databinding.ItemTodoFeedBinding
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.presentation.util.showToast


class ToDoAdapter(
    private val completeTodo: (TodoData) -> Unit,
    private val updateTodo: (TodoData, String) -> Unit,
    private val deleteTodo: (TodoData) -> Unit
) :
    RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {

    private val todoList = mutableListOf<TodoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder =
        TodoViewHolder(
            ItemTodoFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            completeTodo
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

    inner class TodoViewHolder(
        private val binding: ItemTodoFeedBinding,
        private val completeTodo: (TodoData) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todoItem: TodoData) {
            binding.data = todoItem
            binding.root.setOnLongClickListener {
                completeTodo(todoItem)
                binding.root.context.showToast("${todoItem.content}를 완료했습니다!")
                true
            }
            binding.root.setOnClickListener {
                TodoChangeDialog(todoItem,
                    { todo, string -> updateTodo(todo, string) },
                    { todo -> deleteTodo(todo) }
                ).show(
                    ((binding.root.context as ViewComponentManager.FragmentContextWrapper).baseContext as AppCompatActivity).supportFragmentManager,
                    "Dialog"
                )
            }
        }
    }

}