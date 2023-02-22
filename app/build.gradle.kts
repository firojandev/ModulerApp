plugins {
    id(Build.androidGradlePlugin)
    id(Build.kotlinGradlePlugin)
    kotlin("kapt")
    id(Hilt.hiltAndroid)
}

android {
    namespace = AppConfig.appId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = false
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.versionJVM
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
        resources.excludes.add("META-INF/LICENSE.md")
        resources.excludes.add("META-INF/LICENSE-notice.md")
    }
}

dependencies {

    implementation(AndroidX.coreKtx)
    implementation(LifeCycle.runtimeKtx)

    implementation(Compose.activityCompose)

    implementation(Compose.composeUi)
    implementation(Compose.uiToolingPreview)

    implementation(Compose.composeMaterial)

    implementation(AndroidX.appCompat)
    implementation(Google.material)
    implementation(AndroidX.constraintlayout)

    implementation(Hilt.hiltAndroidVersion)
    kapt(Hilt.hiltCompiler)

    testImplementation(Testing.junit4)
    androidTestImplementation(Testing.junitAndroidExt)
    androidTestImplementation(Testing.espressoCore)

    androidTestImplementation(Testing.composeUiTest)
    debugImplementation(Compose.uiTooling)
    debugImplementation(Testing.composeUiTestManifest)

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}