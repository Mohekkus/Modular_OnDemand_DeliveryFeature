plugins {
    alias(libs.plugins.android.dynamic.feature)
    alias(libs.plugins.kotlin.android)
}
android {
    namespace = "id.mohekkus.dynamicfeature"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":app"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.feature.delivery)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


//    implementation ("com.google.android.play:core:1.10.3")  // Use the latest versio
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.4.2")
}