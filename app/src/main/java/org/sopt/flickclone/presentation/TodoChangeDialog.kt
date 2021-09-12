package org.sopt.flickclone.presentation

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import org.sopt.flickclone.databinding.FragmentTodoDialogBinding
import org.sopt.flickclone.model.TodoData

class TodoChangeDialog(
    private val todoItem: TodoData,
    private val updateTodo: (TodoData, String) -> Unit,
    private val deleteTodo: (TodoData) -> Unit
) : DialogFragment() {
    private lateinit var binding: FragmentTodoDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentTodoDialogBinding.inflate(LayoutInflater.from(context))
        initView()
        return AlertDialog.Builder(requireActivity()).setView(binding.root).create()
    }

    private fun initView() {
        binding.btnDialogEdit.setOnClickListener {
            val newContent = binding.edittextDialog.text.toString()
            updateTodo(todoItem, newContent)
            Log.d("태그", "update to $newContent")
            dismiss()
        }
        binding.btnDialogDelete.setOnClickListener {
            deleteTodo(todoItem)
            Log.d("태그", "delete ${todoItem.content}")
            dismiss()
        }
    }
}