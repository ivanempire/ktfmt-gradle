import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    // alias(libs.plugins.kotlin.android)
    id("com.ncorti.ktfmt.gradle")
}

ktfmt { kotlinLangStyle() }

android {
    namespace = "com.ivanempire.debug"
    compileSdk { version = release(33) }

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin { compilerOptions { jvmTarget = JvmTarget.JVM_17 } }
}

dependencies {
    implementation(libs.appcompat.v7)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.runner)
}
