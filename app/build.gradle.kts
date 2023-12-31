plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.sonntagsfreitagsproject"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.sonntagsfreitagsproject"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //moschi konvertiert von json in was verständliches
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    //retrofit erlaubt downlload
    implementation ("com.squareup.moshi:moshi-kotlin:1.13.0")
    implementation ("com.squareup.moshi:moshi-adapters:1.13.0")

    //coil
    implementation("io.coil-kt:coil:1.3.0")

    //lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    //livedata
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}