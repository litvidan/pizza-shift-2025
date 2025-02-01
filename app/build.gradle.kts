plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
	namespace = "com.example.pizzashift2025"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.example.pizzashift2025"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.14"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)

	// Compose
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)

	// Навигация с Compose
	implementation(libs.androidx.navigation.compose)

	// Работа с сетью
	implementation(libs.retrofit.core)
	implementation(libs.retrofit.converter.kotlinxserialization)
	implementation(libs.okhttp.logginginterceptor)

	// Coil для загрузки изображений в Compose
	implementation(libs.coil.compose)

	// Koin Core
	implementation(libs.koin.core)
	// Koin для Android
	implementation(libs.koin.android)
	// Koin для Jetpack Compose
	implementation(libs.koin.compose)

	// Сериализация JSON
	implementation(libs.kotlinx.serialization.json)

	// Асинхронное программирование
	implementation(libs.kotlinx.coroutines.android)

	// Unit-тестирование
	testImplementation(libs.junit)
	implementation(libs.kotlinx.coroutines.test)

	// UI-тестирование
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)

	// Превью для Compose
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
}