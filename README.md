# ExampleMod1.7.10

[![](https://jitpack.io/v/SinTh0r4s/ExampleMod1.7.10.svg)](https://jitpack.io/#SinTh0r4s/ExampleMod1.7.10)
[![](https://github.com/SinTh0r4s/ExampleMod1.7.10/actions/workflows/gradle.yml/badge.svg)](https://github.com/SinTh0r4s/ExampleMod1.7.10/actions/workflows/gradle.yml)

An example mod for Minecraft 1.7.10 with Forge focussed on a stable, updatable setup.

### Features

 - Updatable: Replace [`build.gradle`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/build.gradle) with a newer version
 - Optional API artifact (.jar)
 - Optional version replacement in Java files
 - Optional shadowing of dependencies
 - Simplified setup of Mixin and example
 - Optional named developer account for consistent player progression during testing
 - Boilerplate forge mod as starting point
 - Improved warnings for pitfalls
 - Git Tags integration for versioning
 - GitHub CI
 - [Jitpack](https://jitpack.io) CI

### Motivation

We had our fair share in struggles with build scripts for Minecraft Forge. There are quite a few pitfalls from non-obvious error messages. This Example Project provides you a build system you can adapt to over 90% of Minecraft Forge mods and can easily be updated if need be.

### Files
 - [`build.gradle`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/build.gradle): This is the core script of the build process. You should not need to tamper with it, unless you are trying to accomplish something out of the ordinary. __Do not touch this file! You will make a future update near impossible if you do so!__
 - [`gradle.properties`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/gradle.properties): The core configuration file. It includes 
 - [`dependencies.gradle`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/dependencies.gradle): Add your mod's dependencies in this file. This is separate from the main build script, so you may replace the [`build.gradle`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/build.gradle) if an update is available.
 - [`repositories.gradle`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/repositories.gradle): Add your dependencies' repositories. This is separate from the main build script, so you may replace the [`build.gradle`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/build.gradle) if an update is available.
 - [`jitpack.yml`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/jitpack.yml): Ensures that your mod is available as import over [Jitpack](https://jitpack.io).
 - [`.github/workflows/gradle.yml`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/.github/workflows/gradle.yml): A simple CI script that will build your mod any time it is pushed to `master` or `main` and publish the result as release in your repository. This feature is free with GitHub if your repository is public.

### Feedback wanted

If you tried out this build script we would love to head your opinion! Is there any feature missing for you? Did something not work? Please open an issue and we will try to resolve it asap!

### For Advanced Modders: Mixins

You may activate Mixin in 'gradle.properties'. In that case a mixin configuration (usually named `mixins.mymodid.json`) will be generated automatically, and you only have to write the mixins itself. Dependencies are handled as well.
Take a look at the examples in [`com.myname.mymodid.mixinplugin.MixinPlugin`](https://github.com/SinTh0r4s/ExampleMod1.7.10/blob/main/src/main/java/com/myname/mymodid/mixinplugin/MixinPlugin.java) and [`com.myname.mymodid.mixins.*`](https://github.com/SinTh0r4s/ExampleMod1.7.10/tree/main/src/main/java/com/myname/mymodid/mixins). The use of a MixinPlugin allows the injection into any mod and not just vanilla Minecraft.

Happy modding, \
[SinTh0r4s](https://github.com/SinTh0r4s), [TheElan](https://github.com/TheElan) and [basdxz](https://github.com/basdxz)
