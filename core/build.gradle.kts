plugins {
    id(Build.libraryGradlePlugin)
    id(Build.kotlinGradlePlugin)
}
apply {
    from("$rootDir/base-module.gradle")
}

android {
    namespace = "com.test.core"
}

dependencies {

}