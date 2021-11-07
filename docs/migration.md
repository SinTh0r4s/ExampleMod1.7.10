# Migration guides

## Generic migration
Migration for the typical mod which doesn't usy anything special but minecraft forge and some library dependencies. 
For core plugin, mixins, shadowing, access transformes, asm or etc. you'll need to do some extra steps. 
If they are missing in this document - we will gladly receive your suggestions/contribution. 

1. Copy and replace all files from template to your repository, but: // TODO: (maybe we should have a task in CI which attaches zip with all files but these, called "migration-bundle.zip" or smth)
   1. `build.gradle`
   2. `src`
   3. `LICENSE`
   4. `README.md`
   5. `build.gradle(.kts)`
2. Copy all repositories from your `build.gradle(.kts)` to `repositories.gradle`
3. Copy all dependencies from your `build.gradle(.kts)` to `dependecies.gradle`
4. replace your `build.gradle(.kts)` with `build.gradle` from template. In case you have written some custom tasks/configurations not present in the template - you'll best to move them to separate file and link it in this, like for example it does this with `dependencies.gradle`
5. Adapt `gradle.properties` to your mod
6. Ensure `src/main/resources/mcmod.info` contains `${modId}`, `${modName}`. `${modVersion}` and `${minecraftVersion}`
7. Run `./gradlew clean setupDecompWorkspace`

## Mixin configuration
For the reference checkout the [example mixin configuration branch](https://github.com/SinTh0r4s/ExampleMod1.7.10/tree/example-mixins) of the template.

1. Extract mixins package and plugin configuration from `mixins.yourModId.json` to `gradle.properties`
2. Implement MixinPlugin according to example from the reference
3. Remove mixins.mymodid.json
