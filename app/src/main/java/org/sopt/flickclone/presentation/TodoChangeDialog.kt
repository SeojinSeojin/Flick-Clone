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

    private var _binding: FragmentTodoDialogBinding? = null
    private val binding: FragmentTodoDialogBinding
        get() = requireNotNull(_binding)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentTodoDialogBinding.inflate(LayoutInflater.from(context))
        initView()
        return AlertDialog.Builder(requireActivity()).setView(binding.root).create()
    }

    private fun initView() {
        binding.btnDialogEdit.setOnClickListener {
            val newContent = binding.edittextDialog.text.toString()
            updateTodo(todoItem, newContent)
            dismiss()
        }
        binding.btnDialogDelete.setOnClickListener {
            deleteTodo(todoItem)
            dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}