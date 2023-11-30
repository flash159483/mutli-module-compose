@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    kotlin("android")
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.lighthouse.data"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.hilt)
    kapt(libs.hilt.kapt)
    api(libs.bundles.retrofit)
    api(libs.bundles.okhttp)
    api(libs.bundles.gson)

    testImplementation(libs.junit)
    implementation(libs.espresso.core)
}