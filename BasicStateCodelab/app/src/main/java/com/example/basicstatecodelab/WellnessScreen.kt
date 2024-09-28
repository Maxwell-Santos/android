package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


//MutableList é observável pelo compose e daí ele consegue atualizar a tela caso algo mude nessa lista
//toMutableStateList() transforma uma Collecion (exemplo List) e uma Lista observável MutableList

// para utilizar esse viewModel não pode esquecer de implementar o arquivo app/build.gradle.kts
//implementation("androidx.lifecycle:lifecycle-viewmodel-compose:{latest_version}")
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel() // é passado como parâmetro para que possa facilitar nos testes do composable
) {
    Column(modifier = modifier) {
        StateFullCounter()

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCheckedTask = {task, checked ->
                wellnessViewModel.changedTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
            )
    }
}