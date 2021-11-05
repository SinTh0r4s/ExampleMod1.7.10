package com.myname.mymodid.mixinplugin;

import com.myname.mymodid.Tags;
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
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.myname.mymodid.mixinplugin.TargetedMod.VANILLA;

public class MixinPlugin implements IMixinConfigPlugin {

    private static final Logger LOG = LogManager.getLogger(Tags.MODID + " mixins");

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
        final boolean isDevelopmentEnvironment = (boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");

        List<TargetedMod> loadedMods = Arrays.stream(TargetedMod.values())
                .filter(mod -> mod == VANILLA
                        || (mod.loadInDevelopment && isDevelopmentEnvironment)
                        || loadJar(mod.jarNameBeginsWith))
                .collect(Collectors.toList());
        for (TargetedMod mod : TargetedMod.values()) {
            if(loadedMods.contains(mod)) {
                LOG.info("Found " + mod.modName + "! Integrating now...");
            }
            else {
                LOG.info("Could not find " + mod.modName + "! Skipping integration....");
            }
        }

        List<String> mixins = new ArrayList<>();
        for (Mixin mixin : Mixin.values()) {
            if (loadedMods.containsAll(mixin.targetedMods)) {
                mixins.add(mixin.mixinClass);
                LOG.debug("Loading mixin: " + mixin.mixinClass);
            }
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

            LOG.info("Attempting to add " + jar + " to the URL Class Path");
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