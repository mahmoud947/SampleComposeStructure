package com.example.sampleprojectstructurejetpackcompose.ui.shared
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun LoadingDialog(
    showDialog: Boolean,
    title: String = "Loading",
    message: String = "Please wait..."
) {
    if (showDialog) {
        Dialog(onDismissRequest = { /* Dialog cannot be dismissed by clicking outside */ }) {
            // Custom container for the dialog
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Use MaterialTheme's styling for consistency
                AlertDialog(
                    onDismissRequest = { },
                    title = {
                        Text(text = title, style = MaterialTheme.typography.titleLarge)
                    },
                    text = {
                        Text(text = message, style = MaterialTheme.typography.bodyLarge)
                    },
                    confirmButton = { },
                    dismissButton = { },
                    icon = {
                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    },
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                    textContentColor = MaterialTheme.colorScheme.onBackground,
                    iconContentColor = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
