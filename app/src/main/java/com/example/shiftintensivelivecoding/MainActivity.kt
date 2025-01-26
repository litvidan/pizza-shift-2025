package com.example.shiftintensivelivecoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shiftintensivelivecoding.data.LoanRepository
import com.example.shiftintensivelivecoding.ui.theme.ShiftIntensiveLiveCodingTheme

class MainActivity : ComponentActivity() {

	val repository = LoanRepository()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ShiftIntensiveLiveCodingTheme {
				MainScreen(repository = repository)
			}
		}
	}
}