pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }

    val resolutionStrategyConfig: String? by extra
    resolutionStrategy.eachPlugin {
        val property = "plugin.${requested.id.id}"
        if (extra.has(property) && resolutionStrategyConfig != "false") {
            val version = extra.get(property) as String
            if (resolutionStrategyConfig == "verbose") println("ResolutionStrategy selected version=$version from property=$property")
            useVersion(version)
        }
    }
}
rootProject.name = "legacy-android-project"
include(":app")
