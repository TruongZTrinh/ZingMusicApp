plugins {
    id("com.android.application")
}

android {
    namespace = "com.dmt.phuctruong.appnhaczing"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dmt.phuctruong.appnhaczing"
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.picasso:picasso:2.71828")

    implementation("me.relex:circleindicator:2.1.6")
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    implementation("androidx.cardview:cardview:1.0.0")

    implementation("androidx.recyclerview:recyclerview:1.4.0-alpha01")
    // For control over item selection of both touch and mouse driven selection
    implementation("androidx.recyclerview:recyclerview-selection:1.2.0-alpha01")

    implementation("com.google.android.material:material:1.11.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation("javax.annotation:javax.annotation-api:1.3.2")
}