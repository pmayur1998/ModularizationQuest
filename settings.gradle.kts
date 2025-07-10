pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "quest"
include(":app")
include(":core:models")
include(":core:analytics")
include(":core:network")
include(":core:serialization")
include(":core:theme")
include(":core:config:api")
include(":core:config:impl")
include(":core:logging:api")
include(":core:logging:impl")
include(":core:lifecycle:api")
include(":core:lifecycle:impl")
include(":core:time:api")
include(":core:time:impl")

include(":feature:share:api")
include(":feature:share:impl")
include(":feature:posts:api")
include(":feature:posts:impl")

