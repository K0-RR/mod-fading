package net.darktree.fading.mixin;

import net.darktree.fading.Fading;
import net.minecraft.block.CandleCakeBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CandleCakeBlock.class)
public class CakeMixin {

	/**
	 * Needed since 1.18 to make custom flint&steels work with the new candle cake block
	 */
	@Redirect(method="onUse", at=@At(value="INVOKE", target="Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
	boolean isOf(ItemStack stack, Item item) {
		if(stack.isOf(Fading.FLINT_AND_GOLD)) return true;
		if(stack.isOf(Fading.FLINT_AND_DIAMOND)) return true;
		if(stack.isOf(Fading.FLINT_AND_FLINT)) return true;
		return stack.isOf(item);
	}

}
