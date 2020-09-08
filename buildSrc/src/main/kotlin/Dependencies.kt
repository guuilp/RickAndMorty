object GradlePlugins {
    object Versions {
        const val buildToolsVersion = "4.1.0-rc02"
        const val navigation = "2.1.0"
        const val junit5 = "1.6.2.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${SharedVersions.kotlin}"
    const val navigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5}"
}

object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val junit5 = "de.mannodermaus.android-junit5"
}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
}

object AppVersion {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Modules {
    const val character = ":character"
    const val location = ":location"
    const val episode = ":episode"
    const val data = ":data"
    const val dataModel = ":data-model"
    const val domain = ":domain"
    const val domainModel = ":domain-model"
    const val remote = ":remote"
    const val testCore = ":test-core"
    const val testCoreAndroid = ":test-core-android"
}

object SharedVersions {
    const val coroutines = "1.3.9"
    const val kotlin = "1.4.0"
    const val koin = "2.0.1"
}

object Libraries {
    private object Versions {
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val navigation = "2.2.0-rc04"
        const val lifecycle = "2.2.0-rc03"
        const val fragment = "1.2.0-rc04"
        const val material = "1.0.0"
        const val moshi = "1.9.2"
        const val coil = "0.9.1"
        const val lottie = "3.3.1"
        const val recyclerView = "1.1.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${SharedVersions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.lifecycle}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${SharedVersions.coroutines}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
}

object RetrofitLibraries {
    private object Versions {
        const val retrofit = "2.7.1"
        const val okhttp = "3.14.4"
    }

    const val retrofit = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshiAdapter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
}

object KoinLibraries {
    const val koinCore = "org.koin:koin-core:${SharedVersions.koin}"
    const val koinAndroid = "org.koin:koin-android:${SharedVersions.koin}"
    const val koinLifeCycle = "org.koin:koin-androidx-scope:${SharedVersions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${SharedVersions.koin}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val mockk = "1.9.3"
        const val lifecycle = "2.1.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${SharedVersions.coroutines}"
    const val junitKotlin = "org.jetbrains.kotlin:kotlin-test-junit:${SharedVersions.kotlin}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    const val koin = "org.koin:koin-test:${SharedVersions.koin}"
}

object Junit5 {
    private object Versions {
        const val junit5 = "5.5.2"
    }

    const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
    const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
    const val jupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junit5}"
    const val junitVintage = "org.junit.vintage:junit-vintage-engine:${Versions.junit5}"
}