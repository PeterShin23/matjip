import java.util.*

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.pscshin.matjip"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pscshin.matjip"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    val localProps = Properties()
    val localPropsFile = rootProject.file("local.properties")

    if (localPropsFile.exists()) {
        localPropsFile.inputStream().use { localProps.load(it) }
    }

    val googleServicesFile = rootProject.file("app/google-services.json")
    val googleServicesTemplate = rootProject.file("app/google-services.json.template")

    val processedJson = googleServicesTemplate.readText()
        .replace("\${PROJECT_ID}", localProps["PROJECT_ID"] as String)
        .replace("\${STORAGE_BUCKET}", localProps["STORAGE_BUCKET"] as String)
        .replace("\${MOBILESDK_APP_ID}", localProps["MOBILESDK_APP_ID"] as String)
        .replace("\${GOOGLE_SERVICES_API_KEY}", localProps["GOOGLE_SERVICES_API_KEY"] as String)

    googleServicesFile.writeText(processedJson)

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}