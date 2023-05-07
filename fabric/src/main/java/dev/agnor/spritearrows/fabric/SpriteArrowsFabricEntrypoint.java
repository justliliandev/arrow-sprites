package dev.agnor.spritearrows.fabric;

import dev.agnor.spritearrows.SpriteArrowsCommonEntrypoint;
import net.fabricmc.api.ClientModInitializer;

public class SpriteArrowsFabricEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        SpriteArrowsCommonEntrypoint.replace();
    }
}
