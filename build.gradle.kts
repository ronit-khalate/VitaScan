import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version "1.5.0-dev1114"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)


    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")



    // Material 3 {1.3.0 working}
    implementation("org.jetbrains.compose.material3:material3-desktop:1.3.0")

    // Exposed
    val exposedVersion = "0.44.0"
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.xerial:sqlite-jdbc:3.30.1")

    // Navigation
    val decomposeVersion="2.1.2"
        // Extension module for desktop
    implementation ("com.arkivanov.decompose:extensions-compose-jetbrains:$decomposeVersion")
        //  Decompose dependency
    implementation ("com.arkivanov.decompose:decompose:$decomposeVersion")

    // Model Kotlin DL
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-tensorflow:0.6.0-alpha-1")
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-dataset:0.6.0-alpha-1")
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-impl:0.6.0-alpha-1")
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-api:0.6.0-alpha-1")

}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "vita scan"
            packageVersion = "1.0.0"
        }
    }
}
