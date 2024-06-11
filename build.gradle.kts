// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlinVersion by extra("1.6.21")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        // Add other classpath dependencies here if needed
    }
}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
}

val activityVersion by extra("1.4.0")
val appCompatVersion by extra("1.4.0")
val constraintLayoutVersion by extra("2.1.2")
val coreTestingVersion by extra("2.1.0")
val coroutinesVersion by extra("1.5.2")
val lifecycleVersion by extra("2.4.0")
val materialVersion by extra("1.4.0")
val roomVersion by extra("2.6.1")
val junitVersion by extra("4.13.2")
val espressoVersion by extra("3.4.0")
val androidxJunitVersion by extra("1.1.3")

//allprojects {
//    repositories {
//        google()
//        mavenCentral()
//    }
//}