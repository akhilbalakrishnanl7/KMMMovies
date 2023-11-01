import com.android.build.api.variant.BuildConfigField

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)

    alias(libs.plugins.kotlinxSerialization)
    id("maven-publish")
    alias(libs.plugins.swiftPackageBuilder)
}

group = "com.litmus7.kmmmovies"
version = "0.0.1"

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        publishLibraryVariants("release", "debug")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "movies"
        }
    }

    multiplatformSwiftPackage {
        swiftToolsVersion("5.3")
        targetPlatforms {
            iOS { v("13") }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)

                //Use api so that the android app can use it as well
                api(libs.koin.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.android)

                api(libs.koin.android)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "com.litmus7.kmmmovies"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
