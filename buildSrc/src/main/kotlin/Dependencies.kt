

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.3.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${SharedVersions.kotlin}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

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
}

private object SharedVersions {
    const val coroutines = "1.3.2"
    const val kotlin = "1.3.60"
}

object Libraries {
    private object Versions {
        const val appCompat = "1.0.0-beta01"
        const val constraintLayout = "1.1.3"
        const val navigation = "2.1.0"
        const val ktx = "2.1.0"
        const val fragment = "1.1.0"
        const val lifecycle = "1.1.0"
        const val material = "1.0.0"
        const val moshi = "1.9.2"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${SharedVersions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktx}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ktx}"
    const val lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${SharedVersions.coroutines}"
}

object RetrofitLibraries {
    private object Versions {
        const val retrofit = "2.6.2"
        const val okhttp = "3.14.0"
    }

    const val retrofit = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshiAdapter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
}

object KoinLibraries {
    private object Versions {
        const val koin = "2.0.1"
    }

    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinLifeCycle = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val mockk = "1.9.3"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${SharedVersions.coroutines}"
    const val junitKotlin = "org.jetbrains.kotlin:kotlin-test-junit:${SharedVersions.kotlin}"
}
