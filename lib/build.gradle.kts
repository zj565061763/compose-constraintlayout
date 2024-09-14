plugins {
   alias(libs.plugins.android.library)
   alias(libs.plugins.kotlin.android)
   `maven-publish`
}

val libGroupId = "com.sd.lib.android"
val libArtifactId = "compose-constraintlayout"
val libVersion = "1.0.0-alpha01"

android {
   namespace = "com.sd.lib.compose.constraintlayout"
   compileSdk = libs.versions.androidCompileSdk.get().toInt()
   defaultConfig {
      minSdk = 21
   }

   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   kotlinOptions {
      jvmTarget = "1.8"
      freeCompilerArgs += "-module-name=$libGroupId.$libArtifactId"
   }

   buildFeatures {
      compose = true
   }

   composeOptions {
      kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
   }

   publishing {
      singleVariant("release") {
         withSourcesJar()
      }
   }
}

dependencies {
   implementation(libs.androidx.compose.foundation)
   api(libs.androidx.constraintlayout.compose)
}

publishing {
   publications {
      create<MavenPublication>("release") {
         groupId = libGroupId
         artifactId = libArtifactId
         version = libVersion

         afterEvaluate {
            from(components["release"])
         }
      }
   }
}