package com.myname.mymodid.mixinplugin;

import static com.myname.mymodid.mixinplugin.TargetedMod.*;

public enum Mixin {

    //
    // IMPORTANT: Do not make any references to any mod from this file. This file is loaded quite early on and if
    // you refer to other mods you load them as well. The consequence is: You can't inject any previously loaded classes!
    // Exception: Tags.java, as long as it is used for Strings only!
    //

    // Replace with your own mixins:
    ItemEditableBookMixin("minecraft.ItemEditableBookMixin", VANILLA, false),
    GT_Block_Ores_AbstractMixin("gregtech.GT_Block_Ores_AbstractMixin", GREGTECH, false);

    public final String mixinClass;
    public final TargetedMod targetedMod;
    // Injecting into @SideOnly(Side.Client) classes will crash the server. Flag them as clientSideOnly!
    public final boolean clientSideOnly;

    Mixin(String mixinClass, TargetedMod targetedMod, boolean clientSideOnly) {
        this.mixinClass = mixinClass;
        this.targetedMod = targetedMod;
        this.clientSideOnly = clientSideOnly;
    }
}
