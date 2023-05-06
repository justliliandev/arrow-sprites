package dev.agnor.spritearrows.forge;

import dev.agnor.spritearrows.SpriteArrowsCommonEntrypoint;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(SpriteArrowsCommonEntrypoint.MOD_ID)
public class SpriteArrowsForgeEntrypoint {
    public SpriteArrowsForgeEntrypoint() {

        EventBuses.registerModEventBus(SpriteArrowsCommonEntrypoint.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        if (FMLEnvironment.dist.isClient()) {
            SpriteArrowsCommonEntrypoint.init();
        }
    }
}
