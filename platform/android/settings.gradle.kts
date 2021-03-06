rootProject.name = "Corona Android"
include(":App")
project(":App").projectDir = file("app")

if (file("sdk").exists()) {
    include(":Corona")
    project(":Corona").projectDir = file("sdk")
}

val coronaExpansionFileName: String? by settings
if(!coronaExpansionFileName.isNullOrBlank()) {
    include(":preloadedAssets")
}
