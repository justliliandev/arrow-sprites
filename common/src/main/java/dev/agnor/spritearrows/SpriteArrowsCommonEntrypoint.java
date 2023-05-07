package dev.agnor.spritearrows;


import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SpriteArrowsCommonEntrypoint {
    public static final String MOD_ID = "spritearrows";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void replace() {
        Minecraft instance = Minecraft.getInstance();
        List<EntityType<?>> replaceable = new ArrayList<>();
        EntityRendererProvider.Context ctx = new EntityRendererProvider.Context(instance.getEntityRenderDispatcher(), instance.getItemRenderer(), instance.getBlockRenderer(), null, instance.getResourceManager(), new EntityModelSet(), instance.font);
        for (var entry : EntityRenderers.PROVIDERS.entrySet()) {
            try {
                if (entry.getKey() == EntityType.TRIDENT || entry.getValue().create(ctx) instanceof ArrowRenderer<?>) {
                    replaceable.add(entry.getKey());
                }
            } catch (Exception ignored) {
            }
        }
        for (EntityType type: replaceable) {
            SpriteArrowsCommonEntrypoint.LOGGER.warn("at replace: " + BuiltInRegistries.ENTITY_TYPE.getKey(type));
            EntityRenderers.PROVIDERS.put(type, provide());
        }
    }

    public static EntityRendererProvider<AbstractArrow> provide() {
        return SpriteArrowRenderer::new;
    }
}
