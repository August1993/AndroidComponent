object BuildConfig {
    const val compileSdk = 30
    const val applicationId = "com.example.androidcomponent"
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
}

private object LibVersions {
    const val ktx_version = "1.3.2"
    const val ktx_viewmodel = "2.4.0-alpha03"
    const val ktx_liveData = "2.4.0-alpha03"
    const val ktx_lifeCycle = "2.4.0-alpha03"
    const val androidX_appcompat_version = "1.2.0"
    const val materialDesignVersion = "1.3.0"
    const val constraintlayout_version = "2.0.4"
    const val ARoute_version = "1.5.1"

}

object Libs {
    const val core_ktx = "androidx.core:core-ktx:${LibVersions.ktx_version}"

    const val androidX_appcompat =
        "androidx.appcompat:appcompat:${LibVersions.androidX_appcompat_version}"

    const val material =
        "com.google.android.material:material:${LibVersions.materialDesignVersion}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${LibVersions.constraintlayout_version}"

    const val arouter = "com.alibaba:arouter-api:${LibVersions.ARoute_version}"

    const val kapt_arouter = "com.alibaba:arouter-compiler:${LibVersions.ARoute_version}"

    const val ktx_videModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibVersions.ktx_viewmodel}"

    const val ktx_liveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${LibVersions.ktx_liveData}"
    const val ktx_lifeCycle =
        "androidx.lifecycle:lifecycle-runtime-ktx:${LibVersions.ktx_lifeCycle}"
}