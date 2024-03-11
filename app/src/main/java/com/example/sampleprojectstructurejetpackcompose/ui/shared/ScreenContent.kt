package com.example.sampleprojectstructurejetpackcompose.ui.shared

import androidx.compose.runtime.Composable
import com.example.sampleprojectstructurejetpackcompose.ui.shared.ErrorDialog
import com.example.sampleprojectstructurejetpackcompose.ui.shared.LoadingDialog

@Composable
fun ScreenContent(
    isLoading: Boolean,
    loadingTitle: String = "Loading",
    loadingMessage: String = "Please wait...",
    isError: Boolean,
    errorMessage: String = "",
    onDismissError: () -> Unit = {},
    onConfirmError: () -> Unit = {},
    content: @Composable () -> Unit
) {
    LoadingDialog(showDialog = isLoading, title = loadingTitle, message = loadingMessage)
    ErrorDialog(
        showDialog = isError,
        message = errorMessage,
        onDismiss = onDismissError,
        onConfirm = onConfirmError
    )

    content()
}
