package dev.agnor.spritearrows.forge;

import dev.agnor.spritearrows.SpriteArrowsCommonEntrypoint;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(SpriteArrowsCommonEntrypoint.MOD_ID)
public class SpriteArrowsForgeEntrypoint {
    public SpriteArrowsForgeEntrypoint() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(EventPriority.LOWEST, ClassLoadingProtection::listen);
        }
    }

    private static class ClassLoadingProtection {

        private static void listen(FMLClientSetupEvent event) {
            SpriteArrowsCommonEntrypoint.replace();
        }
    }
}
