pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ModulerApp"
include(":app")
include(":core")
include(":network")
include(":common:common_data")
include(":common:common_domain")
include(":auth:auth_data")
include(":auth:auth_domain")
include(":auth:auth_presentation")
