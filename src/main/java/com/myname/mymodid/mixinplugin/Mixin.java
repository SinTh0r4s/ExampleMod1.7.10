package com.myname.mymodid.mixinplugin;

import java.util.Arrays;
import java.util.List;

import static com.myname.mymodid.mixinplugin.TargetedMod.*;

public enum Mixin {

    //
    // IMPORTANT: Do not make any references to any mod from this file. This file is loaded quite early on and if
    // you refer to other mods you load them as well. The consequence is: You can't inject any previously loaded classes!
    // Exception: Tags.java, as long as it is used for Strings only!
    //

    // Replace with your own mixins:
    ItemEditableBookMixin("minecraft.ItemEditableBookMixin", VANILLA),
    // You may also require multiple mods to be loaded if your mixin requires both
    GT_Block_Ores_AbstractMixin("gregtech.GT_Block_Ores_AbstractMixin", GREGTECH, VANILLA);

    public final String mixinClass;
    public final List<TargetedMod> targetedMods;

    Mixin(String mixinClass, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
    }
}
