package com.myname.mymodid.mixinplugin;

import com.myname.mymodid.Tags;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraft.launchwrapper.Launch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import ru.timeconqueror.spongemixins.MinecraftURLClassPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {

    private static Logger LOG = LogManager.getLogger(Tags.MODID);

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    // This method return a List<String> of mixins. Every mixins in this list will be loaded.
    @Override
    public List<String> getMixins() {
        final boolean loadClientSideOnlyClasses = FMLLaunchHandler.side().isClient();
        final boolean isDevelopmentEnvironment = (boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");

        //
        // IMPORTANT: Do not make any references to any mod from this file. This file is loaded quite early on and if
        // you refer to other mods you load them as well. The consequence is: You can't inject any previously loaded classes!
        //

        List<String> mixins = new ArrayList<>();
        // We may add vanilla mixins at all times. Vanilla Minecraft is guaranteed to be on the class path
        mixins.add("minecraft.ItemEditableBookMixin");

        // If we inject into another mod we need to ensure it is available on the classpath. Some mods are, some are not.
        // loadJar() will ensure it is available and return false if a mod is not installed.

        // Additionally, we don't have the other mod in /mods during development runs. If you want a mixin to be applied
        // at development you should allow its addition with an additional check to isDevelopmentEnvironment. If your
        // dependency is optional, eg added as compileOnly dependency, you must skip the test against isDevelopmentEnvironment!
        if(isDevelopmentEnvironment || loadJar("gregtech")) {
            LOG.info("Found GregTech! Integrating now...");
            //mixins.add("gregtech.SOMEGTMIXINEXAMPLE");
        }
        else {
            LOG.info("Could not find GregTech! Skipping integration....");
        }

        return mixins;
    }

    private boolean loadJar(final String jarNameBeginsWith) {
        try {
            File jar = MinecraftURLClassPath.getJarInModPath(jarNameBeginsWith);
            if(jar == null) {
                LOG.info("Jar not found: " + jarNameBeginsWith);
                return false;
            }

            LOG.info("Attempting to add " + jar.toString() + " to the URL Class Path");
            if(!jar.exists()) {
                throw new FileNotFoundException(jar.toString());
            }
            MinecraftURLClassPath.addJar(jar);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}