package com.example.shiftintensivelivecoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shiftintensivelivecoding.details.data.converter.LoanConverter
import com.example.shiftintensivelivecoding.details.data.network.LoanApi
import com.example.shiftintensivelivecoding.details.data.repository.LoanRepositoryImpl
import com.example.shiftintensivelivecoding.details.domain.usecase.GetLoanUseCase
import com.example.shiftintensivelivecoding.history.data.converter.LoanHistoryItemConverter
import com.example.shiftintensivelivecoding.history.data.network.LoanHistoryApi
import com.example.shiftintensivelivecoding.history.data.repository.LoanHistoryRepositoryImpl
import com.example.shiftintensivelivecoding.history.domain.repository.LoanHistoryRepository
import com.example.shiftintensivelivecoding.history.domain.usecase.GetLoanHistoryItemsUseCase
import com.example.shiftintensivelivecoding.ui.theme.ShiftIntensiveLiveCodingTheme

class MainActivity : ComponentActivity() {

	private val networkModule = NetworkModule()

	private val loanHistoryApi = networkModule.retrofit.create(LoanHistoryApi::class.java)
	private val loanHistoryItemConverter = LoanHistoryItemConverter()
	private val loanHistoryRepository: LoanHistoryRepository = LoanHistoryRepositoryImpl(loanHistoryApi, loanHistoryItemConverter)
	private val getLoanHistoryItemsUseCase = GetLoanHistoryItemsUseCase(loanHistoryRepository)

	private val loanApi = networkModule.retrofit.create(LoanApi::class.java)
	private val loanConverter = LoanConverter()
	private val loanRepository = LoanRepositoryImpl(loanApi, loanConverter)
	private val getLoanUseCase = GetLoanUseCase(loanRepository)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ShiftIntensiveLiveCodingTheme {
				MainScreen(
					getLoanHistoryItemsUseCase = getLoanHistoryItemsUseCase,
					getLoanUseCase = getLoanUseCase,
				)
			}
		}
	}
}