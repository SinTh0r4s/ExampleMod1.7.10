package com.myname.mymodid.mixins.minecraft;

import com.myname.mymodid.MyMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = ItemEditableBook.class)
public class ItemEditableBookMixin {

    @Inject(method = "onItemRightClick",
            at = @At("HEAD"),
            require = 1,
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer, CallbackInfoReturnable<ItemStack> callbackInfoReturnable) {
        MyMod.info("You are reading a book");
    }
}