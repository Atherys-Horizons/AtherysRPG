package com.atherys.rpg.config;

import com.atherys.core.utils.PluginConfig;
import com.atherys.rpg.api.damage.AtherysDamageTypes;
import com.atherys.rpg.api.stat.AttributeType;
import com.atherys.rpg.api.stat.AttributeTypes;
import com.google.inject.Singleton;
import ninja.leaping.configurate.objectmapping.Setting;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.equipment.EquipmentTypes;
import org.spongepowered.api.item.inventory.property.EquipmentSlotType;
import org.spongepowered.api.text.Text;

import java.io.IOException;
import java.util.*;

@Singleton
public class AtherysRPGConfig extends PluginConfig {

    @Setting("item-damage-types")
    public Map<ItemType, String> ITEM_DAMAGE_TYPES = new HashMap<>();

    @Setting("offhand-item-types")
    public Set<ItemType> OFFHAND_ITEMS = new HashSet<>();

    @Setting("mainhand-item-types")
    public Set<ItemType> MAINHAND_ITEMS = new HashSet<>();

    @Setting("projectile-damage-types")
    public Map<EntityType, String> PROJECTILE_DAMAGE_TYPES = new HashMap<>();

    @Setting("physical-damage-mitigation-calculation")
    public String PHYSICAL_DAMAGE_MITIGATION_CALCULATION = "1.33 * SOURCE_CON";

    @Setting("magical-damage-mitigation-calculation")
    public String MAGICAL_DAMAGE_MITIGATION_CALCULATION = "1.33 * SOURCE_INT";

    @Setting("damage-production-calculations")
    public Map<String, String> DAMAGE_CALCULATIONS = new HashMap<>();

    @Setting("environmental-damage-calculations")
    public Map<DamageType, String> ENVIRONMENTAL_CALCULATIONS = new HashMap<>();

    @Setting("default-melee-damage-type")
    public String DEFAULT_MELEE_TYPE = AtherysDamageTypes.UNARMED.getId();

    @Setting("default-ranged-damage-type")
    public String DEFAULT_RANGED_TYPE = AtherysDamageTypes.PIERCE.getId();

    @Setting("health-regen-calculation")
    public String HEALTH_REGEN_CALCULATION = "1.33 * SOURCE_CON";

    @Setting("health-regen-duration-in-ticks")
    public long HEALTH_REGEN_DURATION_TICKS = 1;

    @Setting("resource-regen-calculation")
    public String RESOURCE_REGEN_CALCULATION = "1.33 * SOURCE_INT";

    @Setting("resource-limit-calculation")
    public String RESOURCE_LIMIT_CALCULATION = "100.0 + SOURCE_INT * 1.5";

    @Setting("health-limit-calculation")
    public String HEALTH_LIMIT_CALCULATION = "100.0 + SOURCE_CON * 1.5";

    @Setting("default-attributes")
    public Map<AttributeType, Double> DEFAULT_ATTRIBUTES = new HashMap<>();

    @Setting("attribute-upgrade-cost")
    public double ATTRIBUTE_UPGRADE_COST = 100.0;

    @Setting("experience-max")
    public double EXPERIENCE_MAX = 100_000.0;

    @Setting("experience-min")
    public double EXPERIENCE_MIN = 0.0;

    @Setting("experience-start")
    public double EXPERIENCE_START = 0.0;

    @Setting("attribute-max")
    public double ATTRIBUTE_MAX = 99.0;

    @Setting("attribute-min")
    public double ATTRIBUTE_MIN = 0.0;

    @Setting("experience-spending-limit")
    public double EXPERIENCE_SPENDING_LIMIT = 100_000.0;

    @Setting("attribute-spending-limit")
    public double ATTRIBUTE_SPENDING_LIMIT = 100_000.0;

    @Setting("skill-spending-limit")
    public double SKILL_SPENDING_LIMIT = 100_000.0;

    @Setting("display-root-skill")
    public boolean DISPLAY_ROOT_SKILL = true;

    @Setting("attribute-order")
    public List<AttributeType> ATTRIBUTE_ORDER = new ArrayList<>();

    @Setting("attribute-descriptions")
    public Map<AttributeType, Text> ATTRIBUTE_DESCRIPTIONS = new HashMap<>();

    @Setting("skill-message-distance")
    public double SKILL_MESSAGE_DISTANCE = 25;

    @Setting("max-reward-distance")
    public double MAX_REWARD_DISTANCE = 30.0d;

    @Setting("players-keep-inventory-on-pvp")
    public boolean PLAYERS_KEEP_INVENTORY_ON_PVP = false;

    {
        ATTRIBUTE_ORDER.addAll(Arrays.asList(
                AttributeTypes.STRENGTH,
                AttributeTypes.CONSTITUTION,
                AttributeTypes.DEXTERITY,
                AttributeTypes.INTELLIGENCE,
                AttributeTypes.WISDOM,
                AttributeTypes.PHYSICAL_RESISTANCE,
                AttributeTypes.MAGICAL_RESISTANCE,
                AttributeTypes.BASE_ARMOR,
                AttributeTypes.BASE_DAMAGE
        ));

        ATTRIBUTE_DESCRIPTIONS.put(AttributeTypes.STRENGTH, Text.of("Increases weapon damage"));
    }

    {
        // Wood
        ITEM_DAMAGE_TYPES.put(ItemTypes.WOODEN_HOE, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.WOODEN_SHOVEL, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.WOODEN_PICKAXE, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.WOODEN_AXE, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.WOODEN_SWORD, AtherysDamageTypes.BLUNT.getId());

        // Stone
        ITEM_DAMAGE_TYPES.put(ItemTypes.STONE_HOE, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.STONE_SHOVEL, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.STONE_PICKAXE, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.STONE_AXE, AtherysDamageTypes.SLASH.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.STONE_SWORD, AtherysDamageTypes.SLASH.getId());

        // Iron
        ITEM_DAMAGE_TYPES.put(ItemTypes.IRON_HOE, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.IRON_SHOVEL, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.IRON_PICKAXE, AtherysDamageTypes.STAB.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.IRON_AXE, AtherysDamageTypes.SLASH.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.IRON_SWORD, AtherysDamageTypes.STAB.getId());

        // Gold
        ITEM_DAMAGE_TYPES.put(ItemTypes.GOLDEN_HOE, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.GOLDEN_SHOVEL, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.GOLDEN_PICKAXE, AtherysDamageTypes.STAB.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.GOLDEN_AXE, AtherysDamageTypes.SLASH.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.GOLDEN_SWORD, AtherysDamageTypes.STAB.getId());

        // Diamond
        ITEM_DAMAGE_TYPES.put(ItemTypes.DIAMOND_HOE, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.DIAMOND_SHOVEL, AtherysDamageTypes.BLUNT.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.DIAMOND_PICKAXE, AtherysDamageTypes.STAB.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.DIAMOND_AXE, AtherysDamageTypes.SLASH.getId());
        ITEM_DAMAGE_TYPES.put(ItemTypes.DIAMOND_SWORD, AtherysDamageTypes.STAB.getId());

        // Hand
        ITEM_DAMAGE_TYPES.put(ItemTypes.NONE, AtherysDamageTypes.UNARMED.getId());
    }

    {
        // Bow
        PROJECTILE_DAMAGE_TYPES.put(EntityTypes.TIPPED_ARROW, AtherysDamageTypes.PIERCE.getId());
    }

    {
        DAMAGE_CALCULATIONS.put(AtherysDamageTypes.BLUNT.getId(), "CLAMP(SOURCE_CON, 1.0, 15.0)");
        DAMAGE_CALCULATIONS.put(AtherysDamageTypes.STAB.getId(), "CLAMP(SOURCE_STR, 1.0, 15.0)");
        DAMAGE_CALCULATIONS.put(AtherysDamageTypes.SLASH.getId(), "CLAMP(SOURCE_STR, 1.0, 15.0)");
        DAMAGE_CALCULATIONS.put(AtherysDamageTypes.UNARMED.getId(), "CLAMP(SOURCE_INT, 1.0, 15.0)");
        DAMAGE_CALCULATIONS.put(AtherysDamageTypes.PIERCE.getId(), "CLAMP(SOURCE_DEX, 1.0, 15.0)");
        DAMAGE_CALCULATIONS.put(AtherysDamageTypes.BALLISTIC.getId(), "CLAMP(SOURCE_DEX, 1.0, 15.0)");
    }

    {
        DEFAULT_ATTRIBUTES.put(AttributeTypes.STRENGTH, 1.0d);
        DEFAULT_ATTRIBUTES.put(AttributeTypes.CONSTITUTION, 1.0d);
        DEFAULT_ATTRIBUTES.put(AttributeTypes.DEXTERITY, 1.0d);
        DEFAULT_ATTRIBUTES.put(AttributeTypes.INTELLIGENCE, 1.0d);
        DEFAULT_ATTRIBUTES.put(AttributeTypes.WISDOM, 1.0d);
        DEFAULT_ATTRIBUTES.put(AttributeTypes.MAGICAL_RESISTANCE, 1.0d);
        DEFAULT_ATTRIBUTES.put(AttributeTypes.PHYSICAL_RESISTANCE, 1.0d);
    }

    protected AtherysRPGConfig() throws IOException {
        super("config/atherysrpg", "config.conf");
    }
}
