package org.sopt.flickclone.presentation

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import org.sopt.flickclone.repository.MainRepository
import javax.inject.Inject


class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    var textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {

        }
    }
}