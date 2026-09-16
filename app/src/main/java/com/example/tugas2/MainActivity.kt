package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

const val NAMA = "Ihsan Ramadhan"
const val NIM = "245150407111063"
const val EXTRA_TEKS = "com.example.duaactivity.EXTRA_TEKS"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                var teks by rememberSaveable {
                    mutableStateOf("")
                }
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .safeDrawingPadding()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(text = "Nama: $NAMA")
                        Text(text = "NIM: $NIM")

                        OutlinedTextField(
                            value = teks,
                            onValueChange = { teks = it },
                            label = { Text("Masukkan teks") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Button(
                            onClick = {
                                val tujuan = Intent(
                                    this@MainActivity,
                                    SecondActivity::class.java
                                )
                                tujuan.putExtra(EXTRA_TEKS, teks)
                                startActivity(tujuan)
                            },
                            enabled = teks.isNotBlank()
                        ) {
                            Text(text = "Tampilkan")
                        }
                    }
                }
            }
        }
    }
}