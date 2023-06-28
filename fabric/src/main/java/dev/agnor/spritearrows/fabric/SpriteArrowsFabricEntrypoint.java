package dev.agnor.spritearrows.fabric;

import dev.agnor.spritearrows.SpriteArrowsCommonEntrypoint;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;

public class SpriteArrowsFabricEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(mc -> SpriteArrowsCommonEntrypoint.replace());
        //SpriteArrowsCommonEntrypoint.replace();
    }
}
