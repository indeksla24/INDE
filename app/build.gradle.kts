plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")

}

android {
    namespace = "com.inde"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.inde"
        minSdk = 24
        targetSdk = 34
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
    buildFeatures {
        viewBinding = true
    }
}
//
//dependencies {
//
//    implementation(libs.appcompat)
//    implementation(libs.material)
//    implementation(libs.activity)
//    implementation(libs.constraintlayout)
//    implementation(libs.filament.android)
//    implementation(libs.recyclerview)
//    implementation(libs.lifecycle.livedata.ktx)
//    implementation(libs.lifecycle.viewmodel.ktx)
//    implementation(libs.navigation.fragment)
//    implementation(libs.navigation.ui)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.ext.junit)
//    androidTestImplementation(libs.espresso.core)
//
//    implementation 'com.google.android.filament:filament-android:1.9.9'
//    implementation 'com.google.android.filament:gltfio-android:1.9.9'
//    implementation 'com.google.android.filament:filament-utils-android:1.9.9'
//
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
//}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.filament.android)
    implementation(libs.recyclerview)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

//    implementation ("com.google.ar.sceneform.ux:sceneform-ux:1.6.0")

//
//////  FILAMENT
////    implementation("com.google.android.filament:filament-android:1.9.9")
////    implementation("com.google.android.filament:gltfio-android:1.9.9")
////    implementation("com.google.android.filament:filament-utils-android:1.9.9")
////
//////  FIREBASE
//    implementation("com.google.firebase:firebase-database:21.0.0")
////    // Import the BoM for the Firebase platform
//    implementation(platform("com.google.firebase:firebase-bom:33.2.0"))
////    // Add the dependency for the Realtime Database library
////    // When using the BoM, you don't specify versions in Firebase library dependencies
//    implementation("com.google.firebase:firebase-database")
}

