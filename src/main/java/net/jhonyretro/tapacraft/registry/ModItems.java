package net.jhonyretro.tapacraft.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jhonyretro.tapacraft.TapaCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.registry.Registries;

public class ModItems {
    public static final Item POTATO_OMELETTE = register(
            new Item(new Item.Settings()),
            "potato_omelette");

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(TapaCraft.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.POTATO_OMELETTE))
            .displayName(Text.translatable("TapaCraft"))
            .build();

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(TapaCraft.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        return registeredItem;

    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
           itemGroup.add(POTATO_OMELETTE);
        });
    }
}
