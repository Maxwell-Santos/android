package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

// a ViewModel serve para receber os dados da camada de negócios e refletir na cada UI, ex (fazer um pagamento ou armazenar preferências do usuário)
// guarda estado porém não faz parte da composição da UI
class WellnessViewModel: ViewModel() {
    // _tasks é privada porque ela não deve ser mutavel fora da viewModel, por isso expõe o tasks como List e ele recebe o valor de _tasks
    private val _tasks =  getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changedTaskChecked(item: WellnessTask, checked: Boolean) {
        // o it nesse escopo representa cada item que está sendo iterado pelo método find
        // o let recebe a task que satifaz a condição e retorna no callback
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task $i")}
