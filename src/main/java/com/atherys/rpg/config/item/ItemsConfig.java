package com.atherys.rpg.config.item;

import com.atherys.core.utils.PluginConfig;
import com.google.inject.Singleton;
import ninja.leaping.configurate.objectmapping.Setting;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class ItemsConfig extends PluginConfig {

    @Setting("items")
    public Set<ItemConfig> ITEMS = new HashSet<>();

    {
        ITEMS.add(new ItemConfig());
    }

    protected ItemsConfig() throws IOException {
        super("config/atherysrpg", "items.conf");
    }
}
