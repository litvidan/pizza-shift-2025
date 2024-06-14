package com.example.shiftintensivelivecoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shiftintensivelivecoding.ui.theme.ShiftIntensiveLiveCodingTheme

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ShiftIntensiveLiveCodingTheme {
				// TODO()
			}
		}
	}
}